package com.intuit.day08graphql;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataMutationResolver implements GraphQLMutationResolver {
    @Autowired
    private List<Book> booksList;
    @Autowired
    private List<Shoe> shoesList;

    public String addBook(String title, double price) {
        Book newBook = new Book("b" + (int)(Math.random() * 10000), title, price, true);
        booksList.add(newBook);
        return newBook.getId();
    }

    public String addShoe(String make, double price) {
        Shoe newShoe = new Shoe("s" + (int)(Math.random() * 10000), make, price, true);
        shoesList.add(newShoe);
        return newShoe.getId();
    }
}
