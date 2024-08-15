package com.arifsyncjava.entitymapping.jdbc.review.repository;

import com.arifsyncjava.entitymapping.JdbcRepository;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Transactional
@Repository
public class DeleteReviewRepository implements JdbcRepository<Long, Optional<Void>> {

    private final JdbcClient jdbc;

    public DeleteReviewRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public Optional<Void> execute(Long  reviewId) {

        if (!reviewIdExist(reviewId)) {
            throw new InvalidArgumentException(
                    ErrorMessage.RESOURCE_NOT_FOUND.getMessage());
        }

        jdbc.sql("DELETE FROM reviews WHERE id = reviewId")
                .param("reviewId",reviewId)
                .update();

        return Optional.empty();

    }


    private boolean reviewIdExist(Long reviewId) {
        return jdbc.sql("SELECT EXISTS " +
                        "(SELECT 1 FROM customer.reviews WHERE id = :reviewId )")
                .param("reviewId", reviewId)
                .query(Boolean.class).single();
    }



}
