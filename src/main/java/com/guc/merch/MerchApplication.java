package com.guc.merch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class MerchApplication {
    public static void main(String[] args) {
        SpringApplication.run(MerchApplication.class, args);
    }
}
