package com.arifsyncjava.entitymapping.jpa.review.controller;

import com.arifsyncjava.entitymapping.dto.request.ReviewBody;
import com.arifsyncjava.entitymapping.dto.request.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jpa.review.service.*;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewController {

    private final GetAllProductService  getAllProductService;
    private final GetReviewService getReviewService;
    private final CreateReviewService createReviewService;
    private final UpdateReviewService updateReviewService;
    private final DeleteReviewService deleteReviewService;

    public ReviewController(GetAllProductService getAllProductService,
                            GetReviewService getReviewService, CreateReviewService createReviewService,
                            UpdateReviewService updateReviewService,
                            DeleteReviewService deleteReviewService) {
        this.getAllProductService = getAllProductService;
        this.getReviewService = getReviewService;
        this.createReviewService = createReviewService;
        this.updateReviewService = updateReviewService;
        this.deleteReviewService = deleteReviewService;
    }


    @GetMapping(path = "/product-list")
    public ResponseEntity<List<ProductListDTO>> readAll () {
        return getAllProductService.execute(null);
    }

    @GetMapping (path = "/products/{id}")
    public ResponseEntity<ProductDTO> read ( @PathVariable ("id") Long productId) {
        return getReviewService.execute(productId);
    }

    @PostMapping (path = "/products/{id}" )
    public ResponseEntity<ProductDTO> create (@PathVariable ("id") Long id, @RequestBody ReviewBody request) {
           return createReviewService.execute(new CreateReviewRequest(id,request));
    }

    @PutMapping (path = "/products/{productId}/{reviewId}")
    public ResponseEntity<ProductDTO> update (
            @PathVariable Long productId,
            @PathVariable Long reviewId,
            @RequestBody ReviewBody body) {
        return updateReviewService.execute(
                new UpdateReviewRequest(productId,reviewId,body));
    }

    @DeleteMapping (path = "/review/{id}")
    public ResponseEntity<Void> delete (@PathVariable ("id") Long id) {
        return deleteReviewService.execute(id);
    }













}
