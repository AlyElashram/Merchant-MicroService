package com.guc.merch.controllers;


import com.amazonaws.services.s3.model.S3Object;
import com.guc.merch.models.listing.Listing;
import com.guc.merch.services.FileServerService;
import com.guc.merch.services.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;

@RestController
public class ListingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);


    @Autowired
    ListingService service;
    @Autowired
    FileServerService fileServerService;

    @PostMapping("/listing")
    public Listing addListing(@RequestBody Listing listing) {
        LOGGER.info("Calling Service from controller to add a listing");
        return service.addListing(listing);
    }

    @PatchMapping("/listing/{id}")
    public ResponseEntity<Listing> updateListing(@PathVariable String id, @RequestBody HashMap<String, Object> patch) {
        Listing updatedListing = service.updateListing(id, patch);
        if (updatedListing != null)
            return ResponseEntity.ok().body(updatedListing);
        return ResponseEntity.notFound().build();
    }


    @GetMapping("/listings/{sellerUID}")
    public ResponseEntity<List<Listing>> getAllListings(@PathVariable String sellerUID) {
        List listings = service.getAllListings(sellerUID);
        LOGGER.info("{}", listings);
        if (listings != null)
            return ResponseEntity.ok().body(listings);
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/listing/{sellerUID}/{id}")
    public ResponseEntity<Listing> deleteListing(@PathVariable String sellerUID, @PathVariable String id) {
        service.deleteListing(id, sellerUID);
        return ResponseEntity.ok().build();
    }
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
