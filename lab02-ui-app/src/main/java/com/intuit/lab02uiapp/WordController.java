package com.intuit.lab02uiapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordController {

    @Autowired
    private PalindromeService palindromeService;

    @PostMapping("/wordplay")
    public HttpEntity<String> palindromeCheck(@RequestParam String word) {
        boolean result = palindromeService.isPalindrome(word);
        if(result) {
            return new ResponseEntity<>(word + " is a palindrome", HttpStatus.OK);
        }
        return new ResponseEntity<>(word + " is not a palindrome", HttpStatus.OK);
    }
}
