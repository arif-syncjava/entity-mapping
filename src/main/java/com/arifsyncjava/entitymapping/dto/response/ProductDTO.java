package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class ProductDTO {
    private Long productId;
    private String name;
    private String model;
    private String price;
    private List<ReviewDTO> reviews;

    public ProductDTO() {
    }

    public ProductDTO(Product product, List<ReviewDTO> reviewDTOList) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.model = product.getModel();
        this.price = product.getPrice();
        this.reviews = reviewDTOList;
    }



}
