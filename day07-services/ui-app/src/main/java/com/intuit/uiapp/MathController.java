package com.intuit.uiapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;

@RestController
public class MathController {
    @Autowired
    private RestTemplate restTemplate;

    @Value("${square.service.base-url}")
    private String squareServiceBaseUrl;

    @PostMapping("/math/{num}")
    public long getSquare(@PathVariable long num) {
        ResponseEntity<Long> responseEntity = restTemplate.getForEntity(squareServiceBaseUrl + "/" + num, Long.class);
        return responseEntity.getBody();
    }

}
