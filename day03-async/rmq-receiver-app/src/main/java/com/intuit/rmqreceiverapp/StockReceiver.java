package com.intuit.rmqreceiverapp;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StockReceiver {

    @RabbitListener(queues = { "${queue.stock}" })
    public void receiveStockSymbol(String symbol) {
        double price = Math.random() * 1000;
        String message = String.format("Received %s. CMP is %s", symbol, price+"");
        System.out.println(message);
    }

    @RabbitListener(queues = { "${queue.type}" })
    public void receiveStockSymbolFromExchange(String symbol) {
        double price = Math.random() * 1000;
        String message = String.format("Received %s. CMP is %s", symbol, price+"");
        System.out.println(message);
    }
}
