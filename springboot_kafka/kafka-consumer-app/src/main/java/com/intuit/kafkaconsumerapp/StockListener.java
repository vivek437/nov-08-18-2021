package com.intuit.kafkaconsumerapp;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class StockListener {
//    @KafkaListener(topics = "t-stock")
//    public void receiveStock(String symbol) {
//        System.out.println("CMP of " + symbol + " is " + (Math.random() * 1000));
//    }

    @KafkaListener(topics = "t-training", groupId = "training-dev", concurrency = "3")
    public void receiveTrainingData(ConsumerRecord<String, String> record) {
        System.out.println("Thread: " +  Thread.currentThread().getName() + " Key: " + record.key() + ", Partition no: " + record.partition() + ", data: " + record.value());
    }


    @KafkaListener(topics = "t-stock", groupId = "stock-broker")
    public void receiveStockConsumer1(String symbol) {
        System.out.println("Stock broker received " + symbol);
    }

    @KafkaListener(topics = "t-stock", groupId = "news-portal")
    public void receiveStockConsumer2(String symbol) {
        System.out.println("New portal received " + symbol);
    }

    @KafkaListener(topics = "t-stock", groupId = "tax-agency")
    public void receiveStockConsumer3(String symbol) {
        System.out.println("Tax agency received " + symbol);
    }
}
