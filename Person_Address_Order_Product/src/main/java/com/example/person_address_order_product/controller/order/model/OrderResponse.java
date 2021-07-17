package com.example.person_address_order_product.controller.order.model;

import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.controller.product.model.ProductResponse;

import java.util.List;

public class OrderResponse {
    private long id;
    private String trackingNumber;
    private PersonResponse personResponse;
    private List<ProductResponse> productResponseList;

    public OrderResponse() {
    }

    public OrderResponse(long id, String trackingNumber, PersonResponse personResponse, List<ProductResponse> productResponseList) {
        this.id = id;
        this.trackingNumber = trackingNumber;
        this.personResponse = personResponse;
        this.productResponseList = productResponseList;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public PersonResponse getPersonResponse() {
        return personResponse;
    }

    public void setPersonResponse(PersonResponse personResponse) {
        this.personResponse = personResponse;
    }

    public List<ProductResponse> getProductResponseList() {
        return productResponseList;
    }

    public void setProductResponseList(List<ProductResponse> productResponseList) {
        this.productResponseList = productResponseList;
    }
}
