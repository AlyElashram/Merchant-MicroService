package com.guc.merch.services;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.CompletableFuture;

@Service
public class MyAsyncService {
    private final ListingService listingService;

    public MyAsyncService(ListingService listingService) {
        this.listingService = listingService;
    }

    @Async
    public void performAsyncOperation(String message) {
        String[] input = message.split(":");
        HashMap<String, Object> patch = new HashMap<>();
        patch.put("status",input[1].toUpperCase());
        listingService.updateListing(input[0], patch);
    }
}
