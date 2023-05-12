package com.guc.merch.models.listing;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface ListingRepository extends MongoRepository<Listing, String> {
    List<Listing> findBySellerUID(String sellerUID);
}
