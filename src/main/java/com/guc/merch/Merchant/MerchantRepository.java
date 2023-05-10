package com.guc.merch.Merchant;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MerchantRepository extends MongoRepository<Merchant,String> {
    @Query("{email:'?0'}")
    Merchant FindMerchantByEmail(String email);



}
