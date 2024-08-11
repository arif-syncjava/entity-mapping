package com.arifsyncjava.entitymapping.jdbc.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Review {
    private Long id;
    private String content;
    private Double star;
}
