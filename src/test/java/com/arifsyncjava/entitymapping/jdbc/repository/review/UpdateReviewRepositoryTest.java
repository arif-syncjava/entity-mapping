package com.arifsyncjava.entitymapping.jdbc.repository.review;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.dto.request.review.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.review.repository.CreateReviewRepository;
import com.arifsyncjava.entitymapping.jdbc.review.repository.UpdateReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.junit.jupiter.api.Assertions.assertThrows;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UpdateReviewRepositoryTest {

    private UpdateReviewRepository updateReviewRepository;
    private CreateReviewRepository createReviewRepository;

    @Autowired
    public UpdateReviewRepositoryTest(JdbcClient jdbcClient) {
        updateReviewRepository = new UpdateReviewRepository(jdbcClient);
        createReviewRepository = new CreateReviewRepository(jdbcClient);
    }

    @Test
    public void  UpdateReviewRepository_execute_ReturnSuccess() {
        CreateReviewRequest request = new CreateReviewRequest();
        ReviewBody body = new ReviewBody("good", 4.0);
        Long productId = 742412L; // already saved in database
        request.setProductId(productId);
        request.setReviewBody(body);
        createReviewRepository.execute(request);

        UpdateReviewRequest updateRequest = new UpdateReviewRequest();
        updateRequest.setProductId(productId);
        ReviewBody updateBody = new ReviewBody("good", 4.0);
        updateRequest.setReviewId(15L); // set manually
        updateRequest.setBody(updateBody);

        ProductDTO productDTO = updateReviewRepository.execute(updateRequest);

        Assertions.assertThat(productDTO.getReviews().size())
                .isEqualTo(1L);


    }


    @Test @Disabled
    public void reviewIdExist_Test () {
        Long reviewId = 15L;
        boolean b = updateReviewRepository.reviewIdExist(reviewId);
        Assertions.assertThat(b).isTrue();
    }












}
