package com.arifsyncjava.entitymapping.dto.response;

import com.arifsyncjava.entitymapping.jpa.entity.Review;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ReviewDTO {
    private String content;
    private Double star;

    public ReviewDTO() {
    }

    public ReviewDTO (Review review) {
        this.content = review.getContent();
        this.star = review.getStar();
    }



}
