package com.arifsyncjava.entitymapping.jdbc.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerServiceV2 implements Command<String, CustomerDTO> {

    private final CustomerRepository customerRepository;

    public GetCustomerServiceV2(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(String email) {
        CustomerDTO customerDTO = customerRepository.read(email)
                .orElseThrow(()->new ResourceNotFoundException(
                        ErrorMessage.CUSTOMER_NOT_FOUND.getMessage()));
        return ResponseEntity.ok(customerDTO);
    }

}
