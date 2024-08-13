package com.arifsyncjava.entitymapping.jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "products",schema = "customer")
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

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "product_id")
    private List<Review> reviewList;



}