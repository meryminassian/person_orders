package com.example.person_address_order_product.persistence;

import com.example.person_address_order_product.persistence.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    //product_table doest have property called "name"
    //List<Product> findByFirstnameContaining(String title);

    List<Product> findByDescriptionContainingIgnoreCase(String title);
}
