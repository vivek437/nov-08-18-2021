package com.intuit.bankuimonolithapp.repository;

import com.intuit.bankuimonolithapp.entity.Statement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatementRepository extends JpaRepository<Statement, Integer> {
}
