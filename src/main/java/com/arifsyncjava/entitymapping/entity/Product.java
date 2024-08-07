package com.arifsyncjava.entitymapping.entity;

import jakarta.persistence.*;

@Entity
@Table (name = "products")
public class Product {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // primary key
    private Long productId; // logical key
    private String name;
    private String model;
    private String price;

//    @OneToMany (cascade = CascadeType.ALL, orphanRemoval = true)
//    @JoinColumn (name = "product_id")
//    private List<Review> reviews;

//    @ManyToMany (mappedBy = "productList")
//    @JsonIgnore
//    private List<Product> productList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

//    public List<Review> getReviews() {
//        return reviews;
//    }
//
//    public void setReviews(List<Review> reviews) {
//        this.reviews = reviews;
//    }

//    public List<Product> getProductList() {
//        return productList;
//    }
//
//    public void setProductList(List<Product> productList) {
//        this.productList = productList;
//    }
}
