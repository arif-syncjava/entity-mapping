package com.arifsyncjava.entitymapping.customer.jpa.controller;

import com.arifsyncjava.entitymapping.customer.entity.Customer;
import com.arifsyncjava.entitymapping.customer.jpa.service.GetCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping (path = "/customers")
public class CustomerController {

    private final GetCustomerService getCustomerService;

    public CustomerController(GetCustomerService getCustomerService) {
        this.getCustomerService = getCustomerService;
    }

    @GetMapping (path = "/{email}")
    public ResponseEntity<Customer> read (@PathVariable ("email") String email) {
        return getCustomerService.execute(email);
    }





}
