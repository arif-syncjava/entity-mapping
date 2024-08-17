package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.entity.Product;
import com.arifsyncjava.entitymapping.jpa.entity.Review;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateReviewService implements Command<CreateReviewRequest, ProductDTO> {

    private final ProductRepository productRepository;
    private final ReviewRepository reviewRepository;

    public CreateReviewService(ProductRepository productRepository,
                               ReviewRepository reviewRepository) {
        this.productRepository = productRepository;
        this.reviewRepository = reviewRepository;
    }


    @Override
    public ResponseEntity<ProductDTO> execute(CreateReviewRequest request) {

        Product product = productRepository.findByProductId(request.getProductId())
                .orElseThrow(()->new ResourceNotFoundException(
                        ErrorMessage.RESOURCE_NOT_FOUND.getMessage()));

        Review review = new Review();
        review.setContent(request.getReviewBody().getContent());
        review.setStar(request.getReviewBody().getStar());
        review.setProduct(product);
        reviewRepository.save(review);

        Product savedProduct = productRepository
                .findByProductId(product.getProductId()).get();

        List<ReviewDTO> reviewDTOList = savedProduct.getReviewList()
                .stream().map(ReviewDTO::new).toList();


        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ProductDTO(savedProduct, reviewDTOList));

    }


}
