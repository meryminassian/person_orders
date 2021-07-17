package com.example.person_address_order_product.persistence;

import com.example.person_address_order_product.persistence.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
