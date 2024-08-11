package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Product;

public class ProductListDTO {
    private Long id;
    private String name;
    private String model;
    private String price;

    public ProductListDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.model = product.getModel();
        this.price = product.getPrice();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getModel() {
        return model;
    }

    public String getPrice() {
        return price;
    }
}
