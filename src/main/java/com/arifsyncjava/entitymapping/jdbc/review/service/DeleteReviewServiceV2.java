package com.arifsyncjava.entitymapping.jdbc.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.jdbc.review.repository.DeleteReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewServiceV2 implements Command<Long,Void> {

    private final DeleteReviewRepository deleteReviewRepository;

    public DeleteReviewServiceV2(DeleteReviewRepository deleteReviewRepository) {
        this.deleteReviewRepository = deleteReviewRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long reviewId) {
        deleteReviewRepository.execute(reviewId);
        return ResponseEntity.noContent().build();
    }

}
