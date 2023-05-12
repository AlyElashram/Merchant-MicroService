package com.guc.merch.controllers;


import com.guc.merch.models.listing.Listing;
import com.guc.merch.services.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ListingController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);


    @Autowired
    ListingService service;

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
}
