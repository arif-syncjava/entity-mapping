package com.arifsyncjava.entitymapping.jdbc.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Customer {
    private Long id;
    private String username;
    private String email; // local key

}
