package com.arifsyncjava.entitymapping.jpa.review.controller;

import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jpa.review.service.GetProductsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    private final GetProductsService getProductsService;

    public ReviewController(GetProductsService getProductsService) {
        this.getProductsService = getProductsService;
    }

    @RequestMapping (path = "/product-list")
    public ResponseEntity<List<ProductListDTO>> readAll () {
        return getProductsService.execute(null);
    }


}
