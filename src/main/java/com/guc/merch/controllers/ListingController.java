package com.guc.merch.controllers;


import java.util.List;

import com.guc.merch.models.listing.Listing;
import com.guc.merch.services.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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


        @GetMapping("/listings")
        public List<Listing> getAllListings(){
           return service.getAllListings();
        }
    }
