package com.example.person_address_order_product.service;

import com.example.person_address_order_product.controller.address.model.AddressRequest;
import com.example.person_address_order_product.persistence.AddressRepository;
import com.example.person_address_order_product.persistence.model.Address;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    private final AddressRepository addressRepository;

    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }


    public Address create(AddressRequest request){
        Address savedAddress = addressRepository.save(convertFromRequestToAddress(request));
        return savedAddress;
    }

    public Address update(Long id, AddressRequest request){
        Address byId = addressRepository.getById(id);
        Address updatedAddress = convertFromRequestToGivenAddress(byId, request);
        Address saved = addressRepository.save(updatedAddress);
        return saved;
    }

    private Address convertFromRequestToGivenAddress(Address address, AddressRequest request){
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        return address;

    }
    private Address convertFromRequestToAddress(AddressRequest request){
        Address address = new Address();
        address.setCountry(request.getCountry());
        address.setCity(request.getCity());
        address.setStreet(request.getStreet());
        return address;
    }
}
