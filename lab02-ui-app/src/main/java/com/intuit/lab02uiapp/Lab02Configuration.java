package com.intuit.lab02uiapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class Lab02Configuration {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
