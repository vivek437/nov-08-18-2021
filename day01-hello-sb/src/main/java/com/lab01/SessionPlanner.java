package com.lab01;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@ConfigurationProperties(prefix = "sessions")
public class SessionPlanner {
    private List<String> topics;

    private List<String> sixtyMinTopics = new ArrayList<>();
    private List<String> fortyFiveMinTopics = new ArrayList<>();
    private List<String> fiftyMinTopics = new ArrayList<>();

    @PostConstruct
    public void constructTopicLists() {
        //Much better if implemented using stream and groupingBy
        topics.forEach(topic -> {
            String[] items =  topic.trim().split("-");
            String title = items[0].trim();
            String duration = items[1].trim();
            if(duration.contains("60")) {
                sixtyMinTopics.add(title);
            } else if(duration.contains("50")) {
                fiftyMinTopics.add(title);
            } else {
                fortyFiveMinTopics.add(title);
            }
        });
    }

    public void setTopics(List<String> topics) {
        this.topics = topics;
    }

    public List<String> getSixtyMinTopics() {
        return sixtyMinTopics;
    }

    public List<String> getFortyFiveMinTopics() {
        return fortyFiveMinTopics;
    }

    public List<String> getFiftyMinTopics() {
        return fiftyMinTopics;
    }
}
