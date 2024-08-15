package com.arifsyncjava.entitymapping.jdbc.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerJdbcRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteCustomerServiceV2 implements Command<String,Void> {

    private final CustomerJdbcRepository customerJdbcRepository;

    public DeleteCustomerServiceV2(CustomerJdbcRepository customerJdbcRepository) {
        this.customerJdbcRepository = customerJdbcRepository;
    }


    @Override
    public ResponseEntity<Void> execute(String email) {
        customerJdbcRepository.delete(email);
        return ResponseEntity.noContent().build();
    }
}
