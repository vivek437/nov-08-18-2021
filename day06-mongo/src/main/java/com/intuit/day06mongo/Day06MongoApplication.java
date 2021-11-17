package com.intuit.day06mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Day06MongoApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(Day06MongoApplication.class, args);
    }

    @Autowired
    private PeopleService peopleService;

    @Override
    public void run(String... args) throws Exception {
        //peopleService.savePerson("Ram", "Narain", 12);
        //peopleService.savePerson("Sam", "Thomas", 22);
        //peopleService.updateAge("6194cb62da6e2611de858afd", 45);
        //peopleService.delete("6194cb63da6e2611de858afe");
        System.out.println(peopleService.loadAllPersons());

    }
}
