package com.arifsyncjava.entitymapping.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "products")
@Getter @Setter
@EqualsAndHashCode
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key
    private Long productId; // logical key
    private String name;
    private String model;
    private String price;

    @OneToMany
    @JoinColumn(name = "product_id")
    private List<Review> reviewList;



}