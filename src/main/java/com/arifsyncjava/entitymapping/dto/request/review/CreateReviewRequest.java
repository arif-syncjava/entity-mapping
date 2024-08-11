package com.arifsyncjava.entitymapping.dto.request.review;

import lombok.Getter;

@Getter
public class CreateReviewRequest {
    private Long productId;
    private ReviewBody reviewBody;

    public CreateReviewRequest(Long productId, ReviewBody reviewBody) {
        this.productId = productId;
        this.reviewBody = reviewBody;
    }


}
