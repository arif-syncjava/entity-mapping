package com.arifsyncjava.entitymapping.dto.request;

import lombok.Getter;

@Getter
public class CreateReviewBody {
    private String content;
    private Double star;

    public CreateReviewBody(String content, Double star) {
        this.content = content;
        this.star = star;
    }

}
