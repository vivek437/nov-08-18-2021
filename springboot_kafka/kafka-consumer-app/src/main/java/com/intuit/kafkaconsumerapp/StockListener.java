package com.intuit.kafkaconsumerapp;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockListener {
    @KafkaListener(topics = "t-stock")
    public void receiveStock(String symbol) {
        System.out.println("CMP of " + symbol + " is " + (Math.random() * 1000));
    }
}
