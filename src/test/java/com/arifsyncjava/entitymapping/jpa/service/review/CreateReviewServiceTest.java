package com.arifsyncjava.entitymapping.jpa.service.review;

import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.request.review.ReviewBody;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.jpa.entity.Product;
import com.arifsyncjava.entitymapping.jpa.entity.Review;
import com.arifsyncjava.entitymapping.jpa.review.repository.ProductRepository;
import com.arifsyncjava.entitymapping.jpa.review.repository.ReviewRepository;
import com.arifsyncjava.entitymapping.jpa.review.service.CreateReviewService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.when;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class CreateReviewServiceTest {

    @Mock
    private ProductRepository productRepository;
    @Mock
    private ReviewRepository reviewRepository;
    @InjectMocks
    private CreateReviewService createReviewService;

    @Test
    public void  CreateReviewService_execute_ReturnSuccess () {
        CreateReviewRequest request = new CreateReviewRequest();
        Long productId = 1289907L;  // already product save in the database
        ReviewBody body = new ReviewBody("good", 4.0);
        request.setProductId(productId);
        request.setReviewBody(body);

        Product product = new Product();
        product.setProductId(productId);
        product.setName("random");
        product.setModel("random");
        product.setPrice("45k");

        Review review = new Review(1L, "good", 4.0);
        review.setProduct(product);

        when(productRepository.findByProductId(productId))
                .thenReturn(Optional.of(product));
        when(reviewRepository.save(Mockito.any(Review.class))).thenReturn(review);

        ResponseEntity<ProductDTO> response = createReviewService.execute(request);

        Assertions.assertThat(response.getStatusCode().isSameCodeAs(HttpStatus.OK));


    }

    @Test
    @Disabled
    public void  CreateReviewService_execute_ReturnException () {}




}
