package com.intuit.rmqsenderapp;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockSenderController {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/cmp/{symbol}")
    public String getCmp(@PathVariable String symbol) {
        rabbitTemplate.convertAndSend("q-stock", symbol);
        return "Message sent";
    }

    @PostMapping("/publish/{symbol}")
    public String publish(@PathVariable String symbol) {
        rabbitTemplate.convertAndSend("e-stock-exchange", "", symbol);
        return "Message sent";
    }

    @PostMapping("/topics/{symbol}/{key}")
    public String publishToTopicExchange(@PathVariable String symbol, @PathVariable String key) {
        rabbitTemplate.convertAndSend("e-topic-exchange", key, symbol);
        return "Message sent";
    }
}
