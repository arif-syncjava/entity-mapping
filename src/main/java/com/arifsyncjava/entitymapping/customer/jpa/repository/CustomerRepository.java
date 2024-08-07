package com.arifsyncjava.entitymapping.customer.jpa.repository;

import com.arifsyncjava.entitymapping.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

    Optional<Customer> findByEmail (String email);



}
