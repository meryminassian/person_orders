package com.example.person_address_order_product.controller.person.model;

import com.example.person_address_order_product.controller.address.model.AddressResponse;

public class PersonResponse {
    private long id;
    private String firstName;
    private String lastName;
    private int age;

    private AddressResponse addressResponse;

    public PersonResponse() {
    }

    public PersonResponse(long id, String firstName, String lastName, int age, AddressResponse addressResponse) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressResponse = addressResponse;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public AddressResponse getAddressResponse() {
        return addressResponse;
    }

    public void setAddressResponse(AddressResponse addressResponse) {
        this.addressResponse = addressResponse;
    }
}
