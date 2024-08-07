package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.entity.Customer;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerService implements Command<String,Void> {

    private final CustomerRepository customerRepository;

    public DeleteCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<Void> execute(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(()->new RuntimeException("not found"));
        Long id = customer.getId();
        customerRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
