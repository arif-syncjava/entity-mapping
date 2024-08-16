package com.arifsyncjava.entitymapping.jpa.service.review;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.jdbc.review.repository.DeleteReviewRepository;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import com.arifsyncjava.entitymapping.jpa.review.service.DeleteReviewService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class DeleteReviewServiceTest {

    @Mock
    private ReviewRepository reviewRepository;

    @InjectMocks
    private DeleteReviewService deleteReviewService;

    @BeforeEach
    void setup () {
        CreateReviewRequest request = new CreateReviewRequest();
        ReviewBody body = new ReviewBody("good", 4.0);
        request.setProductId(1289907L); // already product save in the database
        request.setReviewBody(body);

    }

    @Test
    public void DeleteReviewService_execute_ReturnSuccess () {


    }

    public void DeleteReviewService_execute_ReturnException() {}





}
