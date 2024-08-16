package com.arifsyncjava.entitymapping.jdbc.review.controller;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.dto.request.review.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jdbc.review.service.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewControllerV2 {

    private final GetAllProductServiceV2 getAllProductServiceV2;
    private final GetReviewServiceV2 getReviewServiceV2;
    private final CreateReviewServiceV2 createReviewServiceV2;
    private final UpdateReviewServiceV2 updateReviewServiceV2;
    private final DeleteReviewServiceV2 deleteReviewServiceV2;

    public ReviewControllerV2(GetAllProductServiceV2 getAllProductServiceV2, GetReviewServiceV2 getReviewServiceV2, CreateReviewServiceV2 createReviewServiceV2, UpdateReviewServiceV2 updateReviewServiceV2, DeleteReviewServiceV2 deleteReviewServiceV2) {
        this.getAllProductServiceV2 = getAllProductServiceV2;
        this.getReviewServiceV2 = getReviewServiceV2;
        this.createReviewServiceV2 = createReviewServiceV2;
        this.updateReviewServiceV2 = updateReviewServiceV2;
        this.deleteReviewServiceV2 = deleteReviewServiceV2;
    }


    @GetMapping (path = "/jdbc/product-list")
    public ResponseEntity<List<ProductListDTO>> readAll () {
        return getAllProductServiceV2.execute(null);
    }

    @GetMapping (path = "/jdbc/products/{id}")
    public ResponseEntity<ProductDTO> read (@PathVariable ("id") Long productId) {
        return getReviewServiceV2.execute(productId);
    }

    @PostMapping (path = "/jdbc/products/{id}")
    public ResponseEntity<ProductDTO> create (
            @PathVariable ("id") Long productId,
            @RequestBody ReviewBody request) {
        return createReviewServiceV2.execute(new CreateReviewRequest(productId, request));
    }

    @PutMapping (path = "/jdbc/reviews/{reviewId}")
    public ResponseEntity<ProductDTO> update (
            @PathVariable ("reviewId") Long reviewId,
            @RequestBody ReviewBody body)  {
        return updateReviewServiceV2.execute(new UpdateReviewRequest(reviewId, body));


    }

    @DeleteMapping (path ="/jdbc/reviews/{reviewId}")
    public ResponseEntity<Void> delete (@PathVariable Long reviewId) {
        return deleteReviewServiceV2.execute(reviewId);
    }




}
