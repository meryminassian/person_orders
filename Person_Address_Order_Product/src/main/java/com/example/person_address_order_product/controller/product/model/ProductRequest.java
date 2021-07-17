package com.example.person_address_order_product.controller.product.model;

public class ProductRequest {
    private String description;
    private double price;

    public ProductRequest() {
    }

    public ProductRequest(String description, double price) {
        this.description = description;
        this.price = price;
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
