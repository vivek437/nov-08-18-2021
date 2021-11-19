package com.intuit.day08securedapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SampleController {
    @GetMapping("/hello/{name}")
    public String hello(@PathVariable String name) {
        return "Hello " + name;
    }

    @GetMapping("/hi/{name}")
    public String hi(@PathVariable String name) {
        return "Hi " + name;
    }
}
