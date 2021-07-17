package com.example.person_address_order_product.controller.product.model;

public class ProductResponse {
    private long id;
    private String description;
    private double price;

    public ProductResponse() {

    }

    public ProductResponse(long id, String description, double price) {
        this.id = id;
        this.description = description;
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
