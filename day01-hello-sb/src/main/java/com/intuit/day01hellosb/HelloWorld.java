package com.intuit.day01hellosb;

import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class HelloWorld {
    public String getMessage() {
        return "Hi: " + Instant.now();
    }
}
