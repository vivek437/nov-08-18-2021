package com.intuit.rmqreceiverapp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockReceiver {

    @RabbitListener(queues = "q-stock")
    public void receiveStockSymbol(String symbol) {
        double price = Math.random() * 1000;
        String message = String.format("Received %s. CMP is %s", symbol, price+"");
        System.out.println(message);
    }
}
