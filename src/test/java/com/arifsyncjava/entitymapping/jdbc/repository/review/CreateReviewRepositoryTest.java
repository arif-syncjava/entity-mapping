package com.arifsyncjava.entitymapping.jdbc.repository.review;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.jdbc.review.repository.CreateReviewRepository;
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
public class CreateReviewRepositoryTest {

    private CreateReviewRepository createReviewRepository;

    @Autowired
    public CreateReviewRepositoryTest(JdbcClient jdbcClient) {
        createReviewRepository = new CreateReviewRepository(jdbcClient);
    }

    @Test
    public void CreateReviewRepository_ReturnAProductDTO () {
        CreateReviewRequest request = new CreateReviewRequest();
        ReviewBody body = new ReviewBody("good", 4.0);
        Long productId = 742412L; // already saved in database
        request.setProductId(productId);
        request.setReviewBody(body);

        ProductDTO productDTO = createReviewRepository.execute(request);

        Assertions.assertThat(productDTO.getProductId()).isEqualTo(742412L);



    }

    @Test
    public void CreateReviewRepository_ReturnException () {
        CreateReviewRequest request = new CreateReviewRequest();
        ReviewBody body = new ReviewBody("good", 4.0);
        request.setProductId(null); // arise exception
        request.setReviewBody(body);

        InvalidArgumentException exception =  assertThrows(InvalidArgumentException.class,
        ()  -> createReviewRepository.execute(request));

        Assertions.assertThat(exception.getStatus()
                .isSameCodeAs(HttpStatus.BAD_REQUEST));


    }









}
