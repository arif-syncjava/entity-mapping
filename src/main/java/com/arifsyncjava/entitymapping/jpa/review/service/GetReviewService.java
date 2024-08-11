package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.entity.Product;
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
                .orElseThrow(()-> new ResourceNotFoundException(
                        ErrorMessage.RESOURCE_NOT_FOUND.getMessage()));

        return ResponseEntity.ok(new ProductDTO(product));
    }


}
