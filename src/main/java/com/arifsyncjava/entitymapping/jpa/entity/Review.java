package com.arifsyncjava.entitymapping.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "reviews",schema = "customer")
@Getter @Setter
public class Review {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private Double star;

}
