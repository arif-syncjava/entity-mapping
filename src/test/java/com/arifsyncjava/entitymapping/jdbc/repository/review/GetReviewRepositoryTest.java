package com.arifsyncjava.entitymapping.jdbc.repository.review;

import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.review.repository.GetReviewRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.http.HttpStatus;
import org.springframework.jdbc.core.simple.JdbcClient;

import static org.junit.jupiter.api.Assertions.assertThrows;

@JdbcTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class GetReviewRepositoryTest {

    private GetReviewRepository getReviewRepository;

    @Autowired
    public GetReviewRepositoryTest(JdbcClient jdbcClient) {
        getReviewRepository = new GetReviewRepository(jdbcClient);
    }

    @Test
    public void GetReviewRepository_execute_ReturnSuccess () {
        Long productId = 742412L; // already saved in database
        ProductDTO productDTO = getReviewRepository.execute(productId);
        Assertions.assertThat(productDTO).isNotNull();
    }

    @Test  // Resource not found -- this exception should handle in service layer
    public void GetReviewRepository_execute_ReturnException () {
        Long productId = 000000L; // Non exist productId
        InvalidArgumentException exception = assertThrows(InvalidArgumentException.class,
                ()-> getReviewRepository.execute(productId));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));
        Assertions.assertThat(exception.getMessage())
                .isEqualTo("Resource not found. try again with valid identity");
    }













}
