package com.intuit.squareservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SquareController {

    @GetMapping("/square/{num}")
    public long getSquare(@PathVariable long num) {
        return num * num;
    }
}
