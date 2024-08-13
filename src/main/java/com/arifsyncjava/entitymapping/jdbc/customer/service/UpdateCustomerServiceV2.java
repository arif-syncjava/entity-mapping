package com.arifsyncjava.entitymapping.jdbc.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jdbc.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateCustomerServiceV2 implements Command<RegistrationForm, CustomerDTO> {

    private final CustomerRepository customerRepository;

    public UpdateCustomerServiceV2(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(RegistrationForm request) {
        CustomerDTO customerDTO = customerRepository.update(request);
        return ResponseEntity.ok(customerDTO);
    }


}
