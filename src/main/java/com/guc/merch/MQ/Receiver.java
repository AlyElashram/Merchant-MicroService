package com.guc.merch.MQ;

import com.guc.merch.services.ListingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class Receiver {
    @Autowired
    ListingService service;
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    @RabbitListener(queues = "Merchant_Queue")
    public void receiveMessage(String message) {
        //TODO:parse message here and call service class using reflection?

    }



}