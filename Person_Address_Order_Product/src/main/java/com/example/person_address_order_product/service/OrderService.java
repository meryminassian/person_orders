package com.example.person_address_order_product.service;

import com.example.person_address_order_product.facade.model.OrderFacadeRequest;
import com.example.person_address_order_product.persistence.OrderRepository;
import com.example.person_address_order_product.persistence.model.Order;
import com.example.person_address_order_product.persistence.model.Person;
import com.example.person_address_order_product.persistence.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order create(OrderFacadeRequest request, Person person, List<Product> products){
        Order order = convertFromOrderFacadeReqToOrder(request, person, products);
        Order savedOrder = orderRepository.save(order);
        return savedOrder;
    }

    public Boolean delete(Long id){
        orderRepository.deleteById(id);
        return !orderRepository.existsById(id);
    }

    private Order convertFromOrderFacadeReqToOrder(OrderFacadeRequest orderFacadeRequest, Person person, List<Product> products){
        Order order = new Order();
        order.setPerson(person);
        order.setTrackingNumber(orderFacadeRequest.getTrackingNumber());
        order.setProducts(products);
        return order;
    }
}
