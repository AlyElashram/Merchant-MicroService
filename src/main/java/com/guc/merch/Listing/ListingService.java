package com.guc.merch.Listing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ListingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);
    @Autowired
    private ListingRepository listingRepo;

    public Listing addListing(Listing listing){
        LOGGER.info("Logging From my Service | Currently Adding a listing");
        LOGGER.info("{}",listing);
        return listingRepo.save(listing);
    }
    public List<Listing> getAllListings(){
        List<Listing> all = listingRepo.findAll();
        LOGGER.info("Received message: {}", all);
        return all;
    }
}
