package com.intuit.day02web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HateoasExampleController {

    @GetMapping("/sum/{num1}/{num2}")
    public HttpEntity<Integer> add(@PathVariable int num1, @PathVariable int num2) {
        return new ResponseEntity<>(num1 + num2, HttpStatus.OK);
    }

    @GetMapping("/difference/{num1}/{num2}")
    public HttpEntity<Integer> subtract(@PathVariable int num1, @PathVariable int num2) {
        return new ResponseEntity<>(num1 - num2, HttpStatus.OK);
    }
}
