package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Product;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductListDTO {
    private Long id;
    private String name;
    private String model;
    private String price;

    public ProductListDTO() {
    }

    public ProductListDTO(Product product) {
        this.id = product.getProductId();
        this.name = product.getName();
        this.model = product.getModel();
        this.price = product.getPrice();
    }


}
