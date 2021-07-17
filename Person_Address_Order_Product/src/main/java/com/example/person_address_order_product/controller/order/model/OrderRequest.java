package com.example.person_address_order_product.controller.order.model;

import java.util.List;

public class OrderRequest {

    private long personId;
    private List<Long> productIDs;

    public OrderRequest() {
    }

    public OrderRequest(long personId, List<Long> productIDs) {
        this.personId = personId;
        this.productIDs = productIDs;
    }

    public List<Long> getProductIDs() {
        return productIDs;
    }

    public void setProductIDs(List<Long> productIDs) {
        this.productIDs = productIDs;
    }

    public long getPersonId() {
        return personId;
    }

    public void setPersonId(long personId) {
        this.personId = personId;
    }


}
