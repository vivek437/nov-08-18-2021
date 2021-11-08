package com.intuit.day01hellosb;

import com.info.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com")
public class Day01HelloSbApplication implements CommandLineRunner {

    @Autowired
    private HelloWorld helloWorld;

    @Autowired
    private Training training;

    @Autowired
    private Company company;

    public static void main(String[] args) {
        SpringApplication.run(Day01HelloSbApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println(helloWorld.getMessage());
        System.out.println(training.details());
        System.out.println(company);
    }
}
