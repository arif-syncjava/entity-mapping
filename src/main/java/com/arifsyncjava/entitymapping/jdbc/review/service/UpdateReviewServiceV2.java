package com.arifsyncjava.entitymapping.jdbc.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.review.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.jdbc.review.repository.UpdateReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateReviewServiceV2 implements Command<UpdateReviewRequest, ProductDTO> {

    private final UpdateReviewRepository updateReviewRepository;

    public UpdateReviewServiceV2(UpdateReviewRepository updateReviewRepository) {
        this.updateReviewRepository = updateReviewRepository;
    }

    @Override
    public ResponseEntity<ProductDTO> execute(UpdateReviewRequest request) {
        ProductDTO productDTO = updateReviewRepository.execute(request);
        return ResponseEntity.ok(productDTO);
    }


}
