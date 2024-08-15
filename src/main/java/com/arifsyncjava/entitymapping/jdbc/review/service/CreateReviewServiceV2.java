package com.arifsyncjava.entitymapping.jdbc.review.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
import com.arifsyncjava.entitymapping.jdbc.review.repository.CreateReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateReviewServiceV2 implements Query<CreateReviewRequest, ProductDTO> {

    private final CreateReviewRepository createReviewRepository;

    public CreateReviewServiceV2(CreateReviewRepository createReviewRepository) {
        this.createReviewRepository = createReviewRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(CreateReviewRequest request) {
        ProductDTO productDTO = createReviewRepository.execute(request);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(productDTO);
    }



}
