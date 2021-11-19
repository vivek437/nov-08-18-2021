package com.intuit.day08graphql;

public class Book {
    private String id;
    private String title;
    private double price;
    private boolean inStock;

    public Book(String id, String title, double price, boolean inStock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.inStock = inStock;
    }

    public Book() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }
}
