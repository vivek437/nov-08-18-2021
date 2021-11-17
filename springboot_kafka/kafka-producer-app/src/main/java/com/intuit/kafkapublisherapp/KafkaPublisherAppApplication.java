package com.intuit.kafkapublisherapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

@SpringBootApplication
@EnableScheduling
public class KafkaPublisherAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaPublisherAppApplication.class, args);
    }


    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Scheduled(fixedRate = 10, timeUnit = TimeUnit.SECONDS)
    public void sendMessageToTrainingTopic() {
        IntStream
                .range(1, 11)
                .forEach(num -> {
                    int partitionNumber = (num % 3);
                    kafkaTemplate.send("t-training", partitionNumber, num + "", "Data: " + num );
                });
    }
}
