package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.AddressDTO;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.entity.Address;
import com.arifsyncjava.entitymapping.entity.Customer;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements Command<RegistrationForm, CustomerDTO> {

    private final CustomerRepository customerRepository;

    public CreateCustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(RegistrationForm request) {
        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setEmail(request.getEmail());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setCityZone(request.getCityZone());

        customer.setAddress(address);

        customerRepository.save(customer);


        return ResponseEntity.ok(new CustomerDTO(customer,
                new AddressDTO(address)));
    }
}
