package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.dto.request.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.entity.Product;
import com.arifsyncjava.entitymapping.entity.Review;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
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
                .orElseThrow(()->new RuntimeException(" "));

        Review review = new Review();
        review.setContent(request.getReviewBody().getContent());
        review.setStar(request.getReviewBody().getStar());

        Review savedReview = reviewRepository.save(review);

        List<Review> reviewList = product.getReviewList();
        reviewList.add(savedReview);

        Product savedProduct = productRepository.save(product);

        return ResponseEntity.ok(new ProductDTO(savedProduct));

    }


}
