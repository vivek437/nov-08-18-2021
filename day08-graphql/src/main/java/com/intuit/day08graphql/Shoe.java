package com.intuit.day08graphql;

public class Shoe {
    private String id;
    private String make;
    private double price;
    private boolean inStock;

    public Shoe(String id, String title, double price, boolean inStock) {
        this.id = id;
        this.make = title;
        this.price = price;
        this.inStock = inStock;
    }

    public Shoe() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
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
