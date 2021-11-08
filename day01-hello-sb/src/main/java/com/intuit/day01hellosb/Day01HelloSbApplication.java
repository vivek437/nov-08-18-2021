package com.intuit.day01hellosb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day01HelloSbApplication implements CommandLineRunner {

    @Autowired
    private HelloWorld helloWorld;

    @Autowired
    private Training training;

    public static void main(String[] args) {
        SpringApplication.run(Day01HelloSbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloWorld.getMessage());
        System.out.println(training.details());
    }
}
