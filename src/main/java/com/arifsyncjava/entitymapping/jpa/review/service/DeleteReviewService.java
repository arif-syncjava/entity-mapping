package com.arifsyncjava.entitymapping.jpa.review.service;

import com.arifsyncjava.entitymapping.Command;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class DeleteReviewService implements Command<Long,Void> {

    private final ReviewRepository reviewRepository;

    public DeleteReviewService(ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public ResponseEntity<Void> execute(Long id) {

        if (reviewRepository.existsById(id)) {
            reviewRepository.deleteById(id);
        } else {
            throw new ResourceNotFoundException(
                    ErrorMessage.RESOURCE_NOT_FOUND.getMessage());
        }

        return ResponseEntity.noContent().build();

    }



}
