package com.example.person_address_order_product.controller.person.model;

import com.example.person_address_order_product.controller.address.model.AddressRequest;

public class PersonRequest {
    private String firstName;
    private String lastName;
    private int age;

    private AddressRequest addressRequest;

    public PersonRequest() {

    }

    public PersonRequest(String firstName, String lastName, int age, AddressRequest addressRequest) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.addressRequest = addressRequest;
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

    public AddressRequest getAddressRequest() {
        return addressRequest;
    }

    public void setAddressRequest(AddressRequest addressRequest) {
        this.addressRequest = addressRequest;
    }
}
