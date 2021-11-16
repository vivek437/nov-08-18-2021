package com.intuit.bankuimonolithapp.repository;

import com.intuit.bankuimonolithapp.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
