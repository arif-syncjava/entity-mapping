package com.arifsyncjava.entitymapping.dto.request;

import com.arifsyncjava.entitymapping.entity.Review;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UpdateReviewRequest {
    private Long productId;
    private Review review;

}
