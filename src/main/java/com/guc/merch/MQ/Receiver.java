package com.guc.merch.MQ;

import com.guc.merch.services.ListingService;
import com.guc.merch.services.MyAsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Receiver {
    private final MyAsyncService asyncService;
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    @Autowired
    ListingService service;

    public Receiver(MyAsyncService asyncService) {
        this.asyncService = asyncService;
    }

    @RabbitListener(queues = "transaction-queue")
    public void receiveMessage(String message) {
        System.out.println("Received message: " + message);
        asyncService.performAsyncOperation(message);
    }


}