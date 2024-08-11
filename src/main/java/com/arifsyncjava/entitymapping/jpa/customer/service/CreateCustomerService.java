package com.arifsyncjava.entitymapping.jpa.customer.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jpa.customer.repository.AddressRepository;
import com.arifsyncjava.entitymapping.jpa.customer.repository.CustomerRepository;
import com.arifsyncjava.entitymapping.jpa.entity.Address;
import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateCustomerService implements Command<RegistrationForm, CustomerDTO> {

    private final CustomerRepository customerRepository;
    private final AddressRepository addressRepository;

    public CreateCustomerService(CustomerRepository customerRepository,
                                 AddressRepository addressRepository) {
        this.customerRepository = customerRepository;
        this.addressRepository = addressRepository;
    }


    @Override
    public ResponseEntity<CustomerDTO> execute(RegistrationForm request) {

        if (customerRepository.findByEmail(request.getEmail()).isPresent()) {
            throw new InvalidArgumentException(ErrorMessage.EMAIL_AlREADY_USED.getMessage());
        }

        Customer customer = new Customer();
        customer.setUsername(request.getUsername());
        customer.setEmail(request.getEmail());

        Address address = new Address();
        address.setCity(request.getCity());
        address.setCityZone(request.getCityZone());


        customer.setAddress(address);

        Customer savedCustomer = customerRepository.save(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new CustomerDTO(savedCustomer));

    }



}
