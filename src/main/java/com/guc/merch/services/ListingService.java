package com.guc.merch.services;

import com.guc.merch.controllers.ListingController;
import com.guc.merch.models.listing.Listing;
import com.guc.merch.models.listing.ListingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
@CacheConfig(cacheNames = "listings")
public class ListingService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ListingController.class);
    @Autowired
    private ListingRepository listingRepo;

    public Listing addListing(Listing listing) {
        LOGGER.info("Logging From my Service | Currently Adding a listing");
        LOGGER.info("{}", listing);
        return listingRepo.save(listing);
    }
    @Cacheable(value = "listings", key = "#sellerUID")
    public List<Listing> getAllListings(String sellerUID) {
        LOGGER.info("returning all listings");
        return listingRepo.findBySellerUID(sellerUID);
    }

    public Listing updateListing(String id, HashMap<String, Object> patch) {
        Listing listing = listingRepo.findById(id).orElse(null);
        if (listing != null) {
            LOGGER.info("updating listing : {}", id);
            LOGGER.info("patch : {}", patch);

            for(String field: patch.keySet()){
                String methodName = "set"+ field.substring(0, 1).toUpperCase() + field.substring(1);
                LOGGER.info("methodName: {}, value: {}", methodName, patch.get(field));
                try {
                    listing.setField(methodName, patch.get(field));
                }
                catch (Exception e){
                    return null;
                }
            }
            return listingRepo.save(listing);
        }
        return null;
    }

    public Listing getListing(String id){
       Optional<Listing> listing  = listingRepo.findById(id);
       return listing.get();
    }
    @CacheEvict(value = "listings", key = "#sellerUID")
    public void deleteListing(String id, String sellerUID) {
        listingRepo.deleteById(id);
    }


}
