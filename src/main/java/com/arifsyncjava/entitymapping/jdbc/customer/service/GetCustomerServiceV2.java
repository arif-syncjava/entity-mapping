package com.arifsyncjava.entitymapping.jdbc.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetCustomerServiceV2 implements Command<String, CustomerDTO> {

    private final CustomerJdbcRepository customerJdbcRepository;

    public GetCustomerServiceV2(CustomerJdbcRepository customerJdbcRepository) {
        this.customerJdbcRepository = customerJdbcRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(String email) {
        CustomerDTO customerDTO = customerJdbcRepository.read(email)
                .orElseThrow(()->new ResourceNotFoundException(
                        ErrorMessage.CUSTOMER_NOT_FOUND.getMessage()));
        return ResponseEntity.ok(customerDTO);
    }

}
