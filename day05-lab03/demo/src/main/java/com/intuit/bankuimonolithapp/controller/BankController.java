package com.intuit.bankuimonolithapp.controller;

import com.intuit.bankuimonolithapp.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    private BankService bankService;

    @PostMapping("/deposit")
    public HttpEntity<Void> deposit(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount, @RequestParam String type) {
        bankService.deposit(accountNumber, amount, type);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public HttpEntity<Void> withdraw(@RequestParam("accountnumber") String accountNumber, @RequestParam int amount, @RequestParam String type) {
        bankService.withdraw(accountNumber, amount, type);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
