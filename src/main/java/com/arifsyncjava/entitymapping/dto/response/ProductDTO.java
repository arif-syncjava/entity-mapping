package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.entity.Product;
import lombok.Getter;

import java.util.List;

@Getter
public class ProductDTO {
    private Long productId;
    private String name;
    private String model;
    private String price;
    private List<ReviewDTO> reviews ;

    public ProductDTO(Product product) {
        this.productId = product.getProductId();
        this.name = product.getName();
        this.model = product.getModel();
        this.price = product.getPrice();
        this.reviews =  product.getReviewList().stream()
                .map(ReviewDTO::new).toList();
    }


}
