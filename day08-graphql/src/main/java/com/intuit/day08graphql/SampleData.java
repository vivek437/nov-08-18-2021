package com.intuit.day08graphql;

import org.apache.catalina.LifecycleState;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class SampleData {

    @Bean
    public List<Book> getBooks() {
        List<Book> books = new ArrayList<>();
        books.add(new Book("b101", "ABC", 100, true));
        books.add(new Book("b102", "DEF", 200, false));
        books.add(new Book("b103", "GHI", 400, true));
        books.add(new Book("b104", "JKL", 300, false));
        books.add(new Book("b105", "MNO", 200, true));
        return books;
    }
}
