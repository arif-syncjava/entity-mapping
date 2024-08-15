package com.arifsyncjava.entitymapping.dto.request.review;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CreateReviewRequest {
    private Long productId;
    private ReviewBody reviewBody;

    public CreateReviewRequest() {
    }

    public CreateReviewRequest(Long productId, ReviewBody reviewBody) {
        this.productId = productId;
        this.reviewBody = reviewBody;
    }


}
