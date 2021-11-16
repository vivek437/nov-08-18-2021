package com.intuit.bankuimonolithapp.service;

import com.intuit.bankuimonolithapp.entity.Account;
import com.intuit.bankuimonolithapp.entity.Statement;
import com.intuit.bankuimonolithapp.repository.AccountRepository;
import com.intuit.bankuimonolithapp.repository.StatementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BankService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private StatementRepository statementRepository;

    public void deposit(String accountNumber, int amount, String type) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() + amount);
            accountRepository.save(account);
            createStatement(accountNumber, amount, type);
        }
     }

     @Transactional
    public void withdraw(String accountNumber, int amount, String type) {
        Optional<Account> optionalAccount = accountRepository.findById(accountNumber);
        if(optionalAccount.isPresent()) {
            Account account = optionalAccount.get();
            account.setBalance(account.getBalance() - amount); //IGNORE THE MANDATORY CHECKS
            accountRepository.save(account);
            createStatement(accountNumber, amount, type);
        }
    }

    private void createStatement(String accountNumber, int amount, String type) {
        Statement statement = new Statement();
        statement.setAmount(amount);
        statement.setAccountNumber(accountNumber);
        statement.setType(type);
        statementRepository.save(statement);
    }
}
