package com.intuit.day04jpa;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository  extends JpaRepository<Employee, EmployeeKey> {
}
