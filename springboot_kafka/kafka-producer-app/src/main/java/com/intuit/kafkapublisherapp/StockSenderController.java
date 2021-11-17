package com.intuit.kafkapublisherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StockSenderController {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping("/stock/{symbol}")
    public HttpEntity<Void> getCmp(@PathVariable String symbol) {
        kafkaTemplate.send("t-stock", symbol);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
