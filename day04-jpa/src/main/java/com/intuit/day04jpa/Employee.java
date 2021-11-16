package com.intuit.day04jpa;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee {
    @EmbeddedId
    private EmployeeKey employeeKey;

    @Column
    private String name;

    public EmployeeKey getEmployeeKey() {
        return employeeKey;
    }

    public void setEmployeeKey(EmployeeKey employeeKey) {
        this.employeeKey = employeeKey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
