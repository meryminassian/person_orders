package com.example.person_address_order_product.controller.order;

import com.example.person_address_order_product.controller.order.model.OrderRequest;
import com.example.person_address_order_product.controller.order.model.OrderResponse;
import com.example.person_address_order_product.facade.OrderFacade;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private final OrderFacade orderFacade;

    public OrderController(OrderFacade orderFacade) {
        this.orderFacade = orderFacade;
    }


    //create
    @PostMapping(value = "/order")
    public ResponseEntity<OrderResponse> create(@RequestBody OrderRequest request){
        ResponseEntity<OrderResponse> body = ResponseEntity.status(HttpStatus.CREATED).body(orderFacade.create(request));
        return body;
    }

    //cancel
    @DeleteMapping(value = "/order/cancel/{id}")
    public ResponseEntity<Boolean> cancel(@PathVariable Long id){
        ResponseEntity<Boolean> body = ResponseEntity.status(HttpStatus.CREATED).body(orderFacade.delete(id));
        return body;
    }

}
