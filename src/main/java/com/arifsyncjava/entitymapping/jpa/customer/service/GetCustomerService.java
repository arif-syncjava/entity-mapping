package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.AddressDTO;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.entity.Customer;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
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
                .orElseThrow(()-> new RuntimeException("not found"));

        return ResponseEntity.ok(new CustomerDTO(customer));
    }

}
