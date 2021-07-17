package com.example.person_address_order_product.controller.converter;

import com.example.person_address_order_product.controller.address.model.AddressResponse;
import com.example.person_address_order_product.controller.order.model.OrderResponse;
import com.example.person_address_order_product.controller.person.model.PersonResponse;
import com.example.person_address_order_product.controller.product.model.ProductResponse;
import com.example.person_address_order_product.persistence.model.Address;
import com.example.person_address_order_product.persistence.model.Order;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.persistence.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public OrderResponse convertFromOrderToOrderResponse(Order order){
        OrderResponse orderResponse = new OrderResponse();
        orderResponse.setId(order.getId());
        orderResponse.setTrackingNumber(order.getTrackingNumber());
        PersonResponse personResponse = convertFromPersonToPersonResponse(order.getPerson());

        List<Product> products = order.getProducts();
        List<ProductResponse> productResponses = products
                .stream()
                .map(each -> convertFromProductToProductResponse(each))
                .collect(Collectors.toList());

        orderResponse.setPersonResponse(personResponse);
        orderResponse.setProductResponseList(productResponses);
        return orderResponse;
    }

    public ProductResponse convertFromProductToProductResponse(Product product){
        ProductResponse productResponse = new ProductResponse();
        productResponse.setId(product.getId());
        productResponse.setDescription(product.getDescription());
        productResponse.setPrice(product.getPrice());
        return productResponse;

    }

    public AddressResponse convertFromAddressToAddressResponse(Address address){
        AddressResponse addressResponse = new AddressResponse();
        addressResponse.setId(address.getId());
        addressResponse.setCountry(address.getCountry());
        addressResponse.setCity(address.getCity());
        addressResponse.setStreet(address.getStreet());
        return addressResponse;
    }

    public PersonResponse convertFromPersonToPersonResponse(Person person){
        AddressResponse addressResponse = convertFromAddressToAddressResponse(person.getAddress());

        PersonResponse personResponse = new PersonResponse();
        personResponse.setId(person.getId());
        personResponse.setFirstName(person.getFirstName());
        personResponse.setLastName(person.getLastName());
        personResponse.setAge(person.getAge());
        personResponse.setAddressResponse(addressResponse);
        return personResponse;
    }
}
