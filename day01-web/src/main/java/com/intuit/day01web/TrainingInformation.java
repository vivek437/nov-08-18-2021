package com.intuit.day01web;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TrainingInformation {
    private String name;

    @JsonProperty("numberOfDays")
    private long duration;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    public List<String> getTopics() {
        return topics;
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    private List<String> topics;

    @Override
    public String toString() {
        return "TrainingInformation{" +
                "name='" + name + '\'' +
                ", duration=" + duration +
                ", topics=" + topics +
                '}';
    }
}
