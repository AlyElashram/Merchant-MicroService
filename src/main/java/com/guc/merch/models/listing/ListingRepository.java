package com.guc.merch.models.listing;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListingRepository extends MongoRepository<Listing,String> {

}
