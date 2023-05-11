package com.guc.merch.Listing;


import java.util.List;

import com.guc.merch.MQ.Receiver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
        ListingService service;

        @PostMapping("/addListing")
        public Listing addListing(@RequestBody Listing listing) {
            LOGGER.info("Calling Service from controller to add a listing");
            return service.addListing(listing);
        }


        @GetMapping("/getAllUser")
        public List<Listing> getAllListings(){
           return service.getAllListings();
        }
    }
