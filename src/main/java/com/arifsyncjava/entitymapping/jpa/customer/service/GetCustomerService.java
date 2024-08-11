package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerService implements Query<String, CustomerDTO> {

    private final CustomerRepository customerRepository;

    public GetCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(String email) {
        Customer customer = customerRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException(
                        ErrorMessage.CUSTOMER_NOT_FOUND.getMessage()));

        return ResponseEntity.ok(new CustomerDTO(customer));
    }


}
