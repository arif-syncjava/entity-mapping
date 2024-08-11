package com.arifsyncjava.entitymapping.jpa.entity;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table (name = "orders")
@Getter @Setter
@EqualsAndHashCode
public class Order {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;

    @OneToMany
    @JoinColumn (name = "order_number")
    private List<Product> productList;


}
