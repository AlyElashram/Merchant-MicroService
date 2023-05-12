package com.guc.merch.controllers;

import com.amazonaws.services.s3.model.S3Object;
import com.guc.merch.models.listing.Listing;
import com.guc.merch.services.FileServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileServerController {
    @Autowired
    FileServerService fileServerService;

    @PostMapping("/listing/image/{id}")
    public ResponseEntity<Listing> uploadImage(@RequestParam("file") MultipartFile file, @RequestBody String id) {
        try {
            fileServerService.upload(id, file);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
    @GetMapping("/listing/image/{id}")
    public ResponseEntity<S3Object> downloadImage(@RequestBody String id){
        S3Object obj = fileServerService.download(id);
        return obj == null ? ResponseEntity.badRequest().build() : ResponseEntity.ok().body(obj);
    }
}
