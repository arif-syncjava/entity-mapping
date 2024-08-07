package com.arifsyncjava.entitymapping.customer.jpa.controller;

import com.arifsyncjava.entitymapping.customer.dto.request.RegistrationForm;
import com.arifsyncjava.entitymapping.customer.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.customer.entity.Customer;
import com.arifsyncjava.entitymapping.customer.jpa.service.CreateCustomerService;
import com.arifsyncjava.entitymapping.customer.jpa.service.DeleteCustomerService;
import com.arifsyncjava.entitymapping.customer.jpa.service.GetCustomerService;
import com.arifsyncjava.entitymapping.customer.jpa.service.UpdateCustomerService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/customers")
public class CustomerController {

    private final GetCustomerService getCustomerService;
    private final CreateCustomerService createCustomerService;
    private final UpdateCustomerService updateCustomerService;
    private final DeleteCustomerService deleteCustomerService;

    public CustomerController(GetCustomerService getCustomerService, CreateCustomerService createCustomerService, UpdateCustomerService updateCustomerService, DeleteCustomerService deleteCustomerService) {
        this.getCustomerService = getCustomerService;
        this.createCustomerService = createCustomerService;
        this.updateCustomerService = updateCustomerService;
        this.deleteCustomerService = deleteCustomerService;
    }


    @GetMapping (path = "/{email}")
    public ResponseEntity<Customer> read (@PathVariable ("email") String email) {
        return getCustomerService.execute(email);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create (@RequestBody RegistrationForm request) {
        return createCustomerService.execute(request);
    }







}
