package com.intuit.lab02palindromeapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PalindromeController {
    @Autowired
    private PalindromeEngine palindromeEngine;

    @GetMapping("/palindrome/{word}")
    public HttpEntity<Boolean> check(@PathVariable String word) {
        return new ResponseEntity<>(palindromeEngine.isPalindrome(word), HttpStatus.OK);
    }

}
