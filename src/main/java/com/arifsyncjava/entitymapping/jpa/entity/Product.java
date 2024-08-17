package com.arifsyncjava.entitymapping.jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table (name = "products",schema = "customer")
@Getter @Setter
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key
    private Long productId; // logical key
    private String name;
    private String model;
    private String price;

    @OneToMany (cascade = CascadeType.ALL, mappedBy = "product",fetch = FetchType.EAGER,
            orphanRemoval = true)
    private List<Review> reviewList = new ArrayList<>();




}