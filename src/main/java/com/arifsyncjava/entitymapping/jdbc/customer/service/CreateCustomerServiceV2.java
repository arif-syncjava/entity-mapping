package com.arifsyncjava.entitymapping.jdbc.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerServiceV2 implements Command<RegistrationForm, CustomerDTO> {

    private final CustomerRepository customerRepository;

    public CreateCustomerServiceV2(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(RegistrationForm request) {

        CustomerDTO customerDTO = customerRepository.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(customerDTO);
    }

}
