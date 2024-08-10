package com.arifsyncjava.entitymapping.dto.request;

import lombok.Getter;

@Getter
public class CreateReviewRequest {
    private Long productId;
    private CreateReviewBody reviewBody;

    public CreateReviewRequest(Long productId, CreateReviewBody reviewBody) {
        this.productId = productId;
        this.reviewBody = reviewBody;
    }


}
