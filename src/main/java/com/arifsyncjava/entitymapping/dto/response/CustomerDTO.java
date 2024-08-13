package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Customer;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CustomerDTO {
    private String username;
    private String email;
    private AddressDTO addressDTO;

    public CustomerDTO() {
    }

    public CustomerDTO(Customer customer) {
        this.username = customer.getUsername();
        this.email = customer.getEmail();
        this.addressDTO = new AddressDTO(customer.getAddress());
    }




}
