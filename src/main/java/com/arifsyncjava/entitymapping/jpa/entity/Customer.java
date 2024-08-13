package com.arifsyncjava.entitymapping.jpa.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table (name = "customers",schema = "customer")
@Getter @Setter
public class Customer {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;   // logical key

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "address_id")
    private Address address;



}
