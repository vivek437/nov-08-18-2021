package com.intuit.day08graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private List<Book> booksList;

    public List<Book> books() {
        //You can talk to other services and fetch data
        //You can talk to databases and fetch data
        return booksList;
    }
}
