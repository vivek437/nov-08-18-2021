package com.intuit.day01hellosb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.Arrays;
import java.util.List;

@Configuration
public class AppConfiguration {
    @Bean
    public List<String> locationsInIndia() {
        return Arrays.asList("Chennai", "Pune", "Bangalore");
    }

    @Bean
    @Primary
    public List<String> locationsInUSA() {
        return Arrays.asList("Houston", "Charolotte", "Boston");
    }
}
