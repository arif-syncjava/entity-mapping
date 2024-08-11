package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Customer;

public class CustomerDTO {
    private String username;
    private String email;
    private AddressDTO addressDTO;

    public CustomerDTO(Customer customer) {
        this.username = customer.getUsername();
        this.email = customer.getEmail();
        this.addressDTO = new AddressDTO(customer.getAddress());
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public AddressDTO getAddress() {
        return addressDTO;
    }


}
