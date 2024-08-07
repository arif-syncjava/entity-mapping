package com.arifsyncjava.entitymapping.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table (name = "customers")
public class Customer implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String email;   // logical key

    @OneToOne (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "address_id")
    private Address address;

    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn (name = "customer_id")
    private Set<Order> orders;



    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

//    public List<Order> getOrders() {
//        return orders;
//    }
//
//    public void setOrders(List<Order> orders) {
//        this.orders = orders;
//    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }





}
