package com.arifsyncjava.entitymapping.jdbc.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.jdbc.review.repository.GetReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GetReviewServiceV2 implements Command<Long, ProductDTO> {

    private final GetReviewRepository getReviewRepository;

    public GetReviewServiceV2(GetReviewRepository getReviewRepository) {
        this.getReviewRepository = getReviewRepository;
    }


    @Override
    public ResponseEntity<ProductDTO> execute(Long productId) {
        ProductDTO productDTO = getReviewRepository.execute(productId);
        return ResponseEntity.ok(productDTO);
    }


}
