package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jpa.entity.Product;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductService implements Query<Void, List<ProductListDTO>> {

    private final ProductRepository productRepository;

    public GetAllProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<List<ProductListDTO>> execute(Void input) {
        List<Product> productList = productRepository.findAll();
        List<ProductListDTO> productListDTOList =
                productList.stream().map(ProductListDTO::new).toList();

        return ResponseEntity.ok(productListDTOList);
    }

}
