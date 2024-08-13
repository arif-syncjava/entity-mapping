package com.arifsyncjava.entitymapping.jdbc.review.controller;

import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jdbc.review.service.GetAllProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController {

    private final GetAllProductService getAllProductService;

    public ReviewController(GetAllProductService getAllProductService) {
        this.getAllProductService = getAllProductService;
    }

    @GetMapping (path = "/jdbc/product-list")
    public ResponseEntity<List<ProductListDTO>> readAll () {
        return getAllProductService.execute(null);
    }




}
