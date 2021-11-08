package com.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
//@ConfigurationProperties(prefix = "company")
public class Company {
    @Autowired
    @Qualifier("locationsInIndia")
    private List<String> locations;

    @Value("${company.name}")
    private String name;

    @Value("${company.headOffice}")
    private String headOffice;

    @Value("${company.employees}")
    private long employees;


    @Autowired
    private Employee ceo;

    public List<String> getLocations() {
        return locations;
    }

    public void setLocations(List<String> locations) {
        this.locations = locations;
    }

    @Override
    public String toString() {
        return "Company{" +
                "locations=" + locations +
                ", name='" + name + '\'' +
                ", headOffice='" + headOffice + '\'' +
                ", employees=" + employees +
                ", ceo=" + ceo +
                '}';
    }
}
