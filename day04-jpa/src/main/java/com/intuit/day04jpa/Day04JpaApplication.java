package com.intuit.day04jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class Day04JpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(Day04JpaApplication.class, args);
    }

}
