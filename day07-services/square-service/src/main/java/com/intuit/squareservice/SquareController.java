package com.intuit.squareservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareController {

    @Value("${welcome}")
    private String welcome;

    @GetMapping("/welcome")
    public String getWelcome() {
        return welcome;
    }

    @GetMapping("/square/{num}")
    public long getSquare(@PathVariable long num) {
        return num * num;
    }
}
