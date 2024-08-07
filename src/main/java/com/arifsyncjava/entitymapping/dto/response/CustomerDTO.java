package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.entity.Address;
import com.arifsyncjava.entitymapping.entity.Customer;

public class CustomerDTO {
    private String username;
    private String email;
    private AddressDTO addressDTO;

    public CustomerDTO(Customer customer, AddressDTO addressDTO) {
        this.username = customer.getUsername();
        this.email = customer.getEmail();
        this.addressDTO =addressDTO;
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
