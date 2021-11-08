package com.lab01;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Component;

@Component
public class Conference {
    @Autowired
    private SessionPlanner sessionPlanner;

    public int get50MinTopicsCount() {
        return sessionPlanner.getFiftyMinTopics().size();
    }

    public int get45MinTopicsCount() {
        return sessionPlanner.getFortyFiveMinTopics().size();
    }

    public int get60MinTopicsCount() {
        return sessionPlanner.getSixtyMinTopics().size();
    }
}
