package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.entity.Product;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetReviewService implements Query<Long,ProductDTO> {

   private final ProductRepository productRepository;

    public GetReviewService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(Long productId) {
        Product product = productRepository.findByProductId(productId)
                .orElseThrow(()-> new RuntimeException("not found"));

        return ResponseEntity.ok(new ProductDTO(product));
    }


}
