package com.guc.merch;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {
    @Cacheable(cacheNames = "myCache", key = "#id") public String getMyObject(String id) {
        return "This should be cached";
    }

}
