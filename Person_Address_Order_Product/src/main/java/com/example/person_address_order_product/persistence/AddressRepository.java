package com.example.person_address_order_product.persistence;

import com.example.person_address_order_product.persistence.model.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {
}
