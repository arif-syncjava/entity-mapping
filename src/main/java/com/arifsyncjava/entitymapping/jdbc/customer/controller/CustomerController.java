package com.arifsyncjava.entitymapping.jdbc.customer.controller;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jdbc.customer.service.CreateCustomerService;
import com.arifsyncjava.entitymapping.jdbc.customer.service.DeleteCustomerService;
import com.arifsyncjava.entitymapping.jdbc.customer.service.GetCustomerService;
import com.arifsyncjava.entitymapping.jdbc.customer.service.UpdateCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/jdbc/customers")
public class CustomerController {

    private final CreateCustomerService createCustomerService;
    private final GetCustomerService getCustomerService;
    private final UpdateCustomerService updateCustomerService;
    private final DeleteCustomerService deleteCustomerService;


    public CustomerController(CreateCustomerService createCustomerService, GetCustomerService getCustomerService, UpdateCustomerService updateCustomerService, DeleteCustomerService deleteCustomerService) {
        this.createCustomerService = createCustomerService;
        this.getCustomerService = getCustomerService;
        this.updateCustomerService = updateCustomerService;
        this.deleteCustomerService = deleteCustomerService;
    }


    public ResponseEntity<CustomerDTO> create (@RequestBody RegistrationForm request ) {



    }


















}
