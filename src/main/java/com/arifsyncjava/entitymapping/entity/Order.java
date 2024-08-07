package com.arifsyncjava.entitymapping.entity;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table (name = "orders")
public class Order implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String orderNumber;


//    @ManyToMany
//    @JoinTable (name = "orders_products",
//            joinColumns = @JoinColumn (name = "order_id"),
//            inverseJoinColumns = @JoinColumn (name = "product_id")
//    )
//    private List<Product> productList;

//
    @ManyToOne
    //@Column (name = "customer_id")
    private Customer customer;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }

//    public Customer getCustomer() {
//        return customer;
//    }
//
//    public void setCustomer(Customer customer) {
//        this.customer = customer;
//    }

}
