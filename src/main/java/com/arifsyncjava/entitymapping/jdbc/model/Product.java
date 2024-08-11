package com.arifsyncjava.entitymapping.jdbc.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Product {
    private Long id; // primary key
    private Long productId; // logical key
    private String name;
    private String model;
    private String price;
}
