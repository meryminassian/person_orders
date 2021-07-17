package com.example.person_address_order_product.facade.model;

public class OrderFacadeRequest {
    private String trackingNumber;

    public OrderFacadeRequest() {
    }

    public OrderFacadeRequest(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
