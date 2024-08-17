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
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "product_primary_key")
    private Product product;


    public Review() {
    }

    public Review(Long id, String content, Double star) {
        this.id = id;
        this.content = content;
        this.star = star;
    }

}
