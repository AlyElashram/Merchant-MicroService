package com.guc.merch.MQ;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


@Component
public class Receiver {
    private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
    @RabbitListener(queues = "Merchant_Queue")
    public void receiveMessage(String message) {
        LOGGER.info("Received message: {}", message);
    }

}