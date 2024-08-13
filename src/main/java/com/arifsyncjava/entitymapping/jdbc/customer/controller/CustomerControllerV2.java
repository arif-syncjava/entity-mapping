package com.arifsyncjava.entitymapping.jdbc.customer.controller;

import com.arifsyncjava.entitymapping.dto.request.customer.RegistrationForm;
import com.arifsyncjava.entitymapping.dto.response.CustomerDTO;
import com.arifsyncjava.entitymapping.jdbc.customer.service.CreateCustomerServiceV2;
import com.arifsyncjava.entitymapping.jdbc.customer.service.DeleteCustomerServiceV2;
import com.arifsyncjava.entitymapping.jdbc.customer.service.GetCustomerServiceV2;
import com.arifsyncjava.entitymapping.jdbc.customer.service.UpdateCustomerServiceV2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping (path = "/jdbc/customers")
public class CustomerControllerV2 {

    private final CreateCustomerServiceV2 createCustomerServiceV2;
    private final GetCustomerServiceV2 getCustomerServiceV2;
    private final UpdateCustomerServiceV2 updateCustomerServiceV2;
    private final DeleteCustomerServiceV2 deleteCustomerServiceV2;


    public CustomerControllerV2(CreateCustomerServiceV2 createCustomerServiceV2, GetCustomerServiceV2 getCustomerServiceV2, UpdateCustomerServiceV2 updateCustomerServiceV2, DeleteCustomerServiceV2 deleteCustomerServiceV2) {
        this.createCustomerServiceV2 = createCustomerServiceV2;
        this.getCustomerServiceV2 = getCustomerServiceV2;
        this.updateCustomerServiceV2 = updateCustomerServiceV2;
        this.deleteCustomerServiceV2 = deleteCustomerServiceV2;
    }

    @GetMapping (path = "/{email}")
    public ResponseEntity<CustomerDTO> read (@PathVariable ("email") String email) {
        return getCustomerServiceV2.execute(email);
    }

    @PostMapping
    public ResponseEntity<CustomerDTO> create (@RequestBody RegistrationForm request ) {
        return createCustomerServiceV2.execute(request);
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update (@RequestBody RegistrationForm request ) {
        return updateCustomerServiceV2.execute(request);
    }








}






