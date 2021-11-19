package com.intuit.day08graphql;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ShoeQueryResolver implements GraphQLQueryResolver {

    @Autowired
    private List<Shoe> shoesList;

    public List<Shoe> allShoes() {
        //You can talk to other services and fetch data
        //You can talk to databases and fetch data
        return shoesList;
    }

    public List<Shoe> shoes(boolean inStock) {
        //You can talk to other services and fetch data
        //You can talk to databases and fetch data
        return shoesList
                .stream()
                .filter(e -> e.isInStock() == inStock)
                .collect(Collectors.toList());
    }
}
