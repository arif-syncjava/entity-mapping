//package com.arifsyncjava.entitymapping.jpa.review.service;
//
//import com.arifsyncjava.entitymapping.Command;
//import com.arifsyncjava.entitymapping.dto.request.RegistrationForm;
//import com.arifsyncjava.entitymapping.dto.request.UpdateReviewRequest;
//import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
//import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
//import com.arifsyncjava.entitymapping.entity.Product;
//import com.arifsyncjava.entitymapping.entity.Review;
//import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
//import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class UpdateReviewService implements Command<UpdateReviewRequest, ProductDTO> {
//
//    private final ProductRepository productRepository;
//    private final ReviewRepository reviewRepository;
//
//    public UpdateReviewService(ProductRepository productRepository,
//                               ReviewRepository reviewRepository) {
//        this.productRepository = productRepository;
//        this.reviewRepository = reviewRepository;
//    }
//
//
//    @Override
//    public ResponseEntity<ProductDTO> execute(UpdateReviewRequest request) {
//        Product product = productRepository.findByProductId(request.getProductId())
//                .orElseThrow(() -> new RuntimeException(" "));
//        //Review oldReview = product.getReviews()
//                .get(Math.toIntExact(request.getReview().getId()));
//        oldReview.setContent(request.getReview().getContent());
//        oldReview.setStar(request.getReview().getStar());
//        //reviewRepository.save(oldReview);
//        List<Review> reviewList = product.getReviews();
//        List< ReviewDTO> reviewDTOList = reviewList.stream()
//                .map(ReviewDTO::new).toList();
//        return ResponseEntity.ok(new ProductDTO(product,reviewDTOList));
//    }
//
//
//}
