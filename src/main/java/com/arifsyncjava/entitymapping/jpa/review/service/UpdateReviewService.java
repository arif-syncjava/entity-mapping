package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.review.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.entity.Product;
import com.arifsyncjava.entitymapping.jpa.entity.Review;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateReviewService implements Command<UpdateReviewRequest, ProductDTO> {

   private final ReviewRepository reviewRepository;
   private final ProductRepository productRepository;

    public UpdateReviewService(ReviewRepository reviewRepository, ProductRepository productRepository) {
        this.reviewRepository = reviewRepository;
        this.productRepository = productRepository;
    }


    @Override
    public ResponseEntity<ProductDTO> execute(UpdateReviewRequest request) {
        Long id = request.getReviewId();
        Product product = productRepository.findByProductId(request.getProductId())
                .orElseThrow(()->new ResourceNotFoundException(
                        ErrorMessage.RESOURCE_NOT_FOUND.getMessage()));

        Review review = reviewRepository.findById(request.getReviewId())
                .orElseThrow(()-> new ResourceNotFoundException(
                        ErrorMessage.RESOURCE_NOT_FOUND.getMessage()));

        review.setId(request.getReviewId());
        review.setContent(request.getBody().getContent());
        review.setStar(request.getBody().getStar());

        reviewRepository.save(review);

        Product updatedProduct =productRepository
               .findByProductId(request.getProductId()).get();

        return ResponseEntity.ok(new ProductDTO(updatedProduct));

    }




}
