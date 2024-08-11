package com.arifsyncjava.entitymapping.dto.request;

import lombok.Getter;

@Getter
public class UpdateReviewRequest {
    private Long productId;
    private Long reviewId;
    private ReviewBody body;

    public UpdateReviewRequest() {

    }

    public UpdateReviewRequest(Long productId, Long reviewId, ReviewBody body) {
        this.productId = productId;
        this.reviewId = reviewId;
        this.body = body;
    }


}
