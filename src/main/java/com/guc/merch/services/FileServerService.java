package com.guc.merch.services;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.amazonaws.services.s3.model.S3Object;
import com.guc.merch.models.listing.Listing;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashMap;
import java.util.UUID;

@Service
@Slf4j
public class FileServerService {
    @Autowired
    private AmazonS3 amazonS3;

    @Autowired
    private ListingService listingService;

    public void upload(String id,MultipartFile file) throws IOException {
        if (file.isEmpty())
            throw new IllegalStateException("Cannot upload empty file");

        ObjectMetadata objectMetadata = new ObjectMetadata();


        String path = String.format("%s/%s", "scalable-team-bucket", UUID.randomUUID());
        String fileName = String.format("%s", file.getOriginalFilename());


        log.debug("Path: " + path + ", FileName:" + fileName);

        PutObjectResult result = amazonS3.putObject(path, fileName, file.getInputStream(), objectMetadata);
        HashMap imageValues = new HashMap<String,Object>();
        imageValues.put("setImageName",fileName);
        imageValues.put("setImagePath",fileName);
        listingService.updateListing(id,imageValues);


    }

    public S3Object download(String id) {
        Listing listing = listingService.getListing(id);
        String path = listing.getImagePath();
        String fileName = listing.getImageName();
        if(listing!=null && path !=null && fileName!=null){
            return amazonS3.getObject(path, fileName);
        }
        return null;
    }

}
