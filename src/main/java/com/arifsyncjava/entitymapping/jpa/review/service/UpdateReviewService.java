package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.entity.Review;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateReviewService implements Command<UpdateReviewRequest, ProductDTO> {

   private final ReviewRepository reviewRepository;

    public UpdateReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }


    @Override
    public ResponseEntity<ProductDTO> execute(UpdateReviewRequest request) {
        Review review = reviewRepository.findById(request.getReviewId())
                .orElseThrow(()-> new RuntimeException(" "));
        review.setId(request.getReviewId());
        review.setContent(request.getBody().getContent());
        review.setStar(request.getBody().getStar());

        reviewRepository.save(review);

    }




}
