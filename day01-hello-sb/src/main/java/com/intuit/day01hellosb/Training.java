package com.intuit.day01hellosb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Training {

    private Instructor instructor;

    public Training(@Autowired Instructor instructor) {
        this.instructor = instructor;
    }

    public String details() {
        return "Spring boot intermediate training by " + instructor.getName();
    }
}
