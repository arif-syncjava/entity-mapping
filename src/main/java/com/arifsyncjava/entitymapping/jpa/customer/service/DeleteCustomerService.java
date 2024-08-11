package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
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
                .orElseThrow(()->new ResourceNotFoundException(
                        ErrorMessage.CUSTOMER_NOT_FOUND.getMessage()
                ));
        Long id = customer.getId();
        customerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
