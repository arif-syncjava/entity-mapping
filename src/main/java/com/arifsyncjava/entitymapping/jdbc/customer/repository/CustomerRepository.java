package com.arifsyncjava.entitymapping.jdbc.customer.repository;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jdbc.model.Customer;

import java.util.Optional;

public interface CustomerRepository {

    CustomerDTO create (RegistrationForm request);
    Optional<CustomerDTO> read (String email);
    CustomerDTO update (RegistrationForm request);
    void delete (String email);
    boolean emailExist (String email);








}
