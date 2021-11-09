package com.intuit.lab02uiapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PalindromeService {

    @Value("${palindrome.service.base.url}")
    private String palindromeServiceBaseUrl;

    @Autowired
    private RestTemplate restTemplate;

    public boolean isPalindrome(String word) {
        String url = palindromeServiceBaseUrl + "/" + word;
        ResponseEntity<Boolean> response = restTemplate.getForEntity(url, Boolean.class);
        return response.getBody();
    }
}
