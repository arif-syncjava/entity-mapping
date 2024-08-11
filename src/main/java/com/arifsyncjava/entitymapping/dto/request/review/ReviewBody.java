package com.arifsyncjava.entitymapping.dto.request.review;

import lombok.Getter;

@Getter
public class ReviewBody {
    private String content;
    private Double star;




    public ReviewBody(String content, Double star) {
        this.content = content;
        this.star = star;
    }

}
