package com.arifsyncjava.entitymapping.customer.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "address")
public class Address {
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String city;
    private String cityZone;

//    @JoinColumn (name = "customer_id")
//    private Customer customer;




    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityZone() {
        return cityZone;
    }

    public void setCityZone(String cityZone) {
        this.cityZone = cityZone;
    }
}
