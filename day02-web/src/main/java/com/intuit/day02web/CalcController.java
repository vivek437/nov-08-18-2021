package com.intuit.day02web;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.Instant;

@RestController
public class CalcController {

    @GetMapping("/add/{num1}/{num2}")
    public int add(@PathVariable("num1") int num1, @PathVariable int num2) {
        return num1 + num2;
    }

    @GetMapping("/subtract/{num1}/{num2}")
    public HttpEntity<Integer> subtract(@PathVariable("num1") int num1, @PathVariable int num2) {
        int result = num1 - num2;
        ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

    @GetMapping("/divide/{num1}/{num2}")
    public HttpEntity<Integer> divide(@PathVariable("num1") int num1, @PathVariable int num2) {
        int result = num1 / num2;
        ResponseEntity<Integer> response = new ResponseEntity<>(result, HttpStatus.OK);
        return response;
    }

}
