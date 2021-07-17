package com.example.person_address_order_product.persistence;

import com.example.person_address_order_product.persistence.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
