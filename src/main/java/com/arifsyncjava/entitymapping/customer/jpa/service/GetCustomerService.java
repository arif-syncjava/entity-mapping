package com.arifsyncjava.entitymapping.customer.jpa.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.customer.entity.Customer;
import com.arifsyncjava.entitymapping.customer.jpa.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService implements Query<String, Customer> {

    private final CustomerRepository customerRepository;

    public GetCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<Customer> execute(String email) {
//
//        Customer customer = customerRepository.findById(Long.valueOf(email))
//                .orElseThrow(()-> new RuntimeException("not found"));

        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(()-> new RuntimeException("not found"));

        return ResponseEntity.ok(customer);
    }
}
