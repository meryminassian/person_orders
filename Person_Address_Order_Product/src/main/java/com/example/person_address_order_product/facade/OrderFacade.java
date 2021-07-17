package com.example.person_address_order_product.facade;

import com.example.person_address_order_product.controller.converter.Converter;
import com.example.person_address_order_product.controller.order.model.OrderRequest;
import com.example.person_address_order_product.controller.order.model.OrderResponse;
import com.example.person_address_order_product.facade.model.OrderFacadeRequest;
import com.example.person_address_order_product.persistence.model.Order;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.persistence.model.Product;
import com.example.person_address_order_product.service.OrderService;
import com.example.person_address_order_product.service.PersonService;
import com.example.person_address_order_product.service.ProductService;
import org.apache.commons.lang.RandomStringUtils;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderFacade {

    private final PersonService personService;
    private final ProductService productService;
    private final OrderService orderService;
    private final Converter converter;

    public OrderFacade(PersonService personService, ProductService productService, OrderService orderService, Converter converter) {
        this.personService = personService;
        this.productService = productService;
        this.orderService = orderService;
        this.converter = converter;
    }

    public OrderResponse create(OrderRequest request){
        Person person = personService.readById(request.getPersonId());

        List<Product> products = new ArrayList<>();
        request.getProductIDs()
                .forEach(each -> products.add(productService.readById(each)));

        OrderFacadeRequest orderFacadeRequest = setTrackingNumber();

        Order order = orderService.create(orderFacadeRequest, person, products);

        OrderResponse orderResponse = converter.convertFromOrderToOrderResponse(order);
        return orderResponse;
    }

    public Boolean delete(Long id){
        return orderService.delete(id);
    }

    private OrderFacadeRequest setTrackingNumber(){
        OrderFacadeRequest orderFacadeRequest = new OrderFacadeRequest();
        String trackingNumber = RandomStringUtils.randomNumeric(15);
        orderFacadeRequest.setTrackingNumber(trackingNumber);
        return orderFacadeRequest;
    }
}
