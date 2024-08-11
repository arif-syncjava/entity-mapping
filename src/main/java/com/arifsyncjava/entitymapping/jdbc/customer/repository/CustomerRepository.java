package com.arifsyncjava.entitymapping.jdbc.customer.repository;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.jdbc.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    Optional<Customer> create (RegistrationForm request);
    Optional<Customer> read (String email);
    Optional <Customer> update (RegistrationForm request);
    Void delete (String email);








}
