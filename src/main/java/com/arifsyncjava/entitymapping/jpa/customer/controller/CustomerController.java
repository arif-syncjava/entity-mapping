package com.arifsyncjava.entitymapping.jpa.customer.controller;

import com.arifsyncjava.entitymapping.dto.request.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jpa.customer.service.CreateCustomerService;
import com.arifsyncjava.entitymapping.jpa.customer.service.DeleteCustomerService;
import com.arifsyncjava.entitymapping.jpa.customer.service.GetCustomerService;
import com.arifsyncjava.entitymapping.jpa.customer.service.UpdateCustomerService;
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
    public ResponseEntity<CustomerDTO> read (@PathVariable ("email") String email) {
        return getCustomerService.execute(email);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create (@RequestBody RegistrationForm request) {
        return createCustomerService.execute(request);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update (@RequestBody RegistrationForm request) {
        return updateCustomerService.execute(request);
    }

    @DeleteMapping (path = "/{email}")
    public ResponseEntity<Void> delete (@PathVariable ("email") String email) {
          return deleteCustomerService.execute(email);
    }







}
