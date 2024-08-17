package com.arifsyncjava.entitymapping.jdbc.repository.review;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.jdbc.review.repository.CreateReviewRepository;
import com.arifsyncjava.entitymapping.jdbc.review.repository.DeleteReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.Optional;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeleteReviewRepositoryTest {


    private DeleteReviewRepository deleteReviewRepository;

    @Autowired
    public DeleteReviewRepositoryTest(JdbcClient jdbcClient) {
        deleteReviewRepository = new DeleteReviewRepository(jdbcClient);
    }


    @Test @Disabled
    public void  DeleteReviewRepository_ReturnSuccess () {
        Long reviewId = 15L; // already saved in database
        Optional<Void> optional = deleteReviewRepository.execute(reviewId);
        Assertions.assertThat(optional.isEmpty());
    }




}
