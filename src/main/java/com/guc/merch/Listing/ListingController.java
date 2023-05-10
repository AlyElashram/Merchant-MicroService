package com.guc.merch.Listing;


import java.util.List;

import com.guc.merch.MQ.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class ListingController {
        private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);
        @Autowired
        private ListingRepository listingRepo;


        @PostMapping("/addListing")
        public Listing addListing(@RequestBody Listing user) {
            return listingRepo.save(user);
        }


        @GetMapping("/getAllUser")
        public List<Listing> getAllUser(){
            List<Listing> all = listingRepo.findAll();
            LOGGER.info("Received message: {}", all);
            return all;
        }
    }
