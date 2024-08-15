package com.arifsyncjava.entitymapping.jdbc.review.repository;

import com.arifsyncjava.entitymapping.JdbcRepository;
import com.arifsyncjava.entitymapping.dto.request.review.UpdateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import com.arifsyncjava.entitymapping.exceptions.ResourceNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class UpdateReviewRepository implements JdbcRepository<UpdateReviewRequest, ProductDTO> {

    private final JdbcClient jdbc;

    public UpdateReviewRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public ProductDTO execute(UpdateReviewRequest request) {

        if (!reviewIdExist(request.getReviewId())) {
            throw new ResourceNotFoundException(
                    ErrorMessage.RESOURCE_NOT_FOUND.getMessage()
            );

        }

        try {
            jdbc.sql("UPDATE customer.reviews" +
                            "SET content = :content, star = :star WHERE id  = :reviewId ")
                    .param("content", request.getBody().getContent())
                    .param("star",request.getBody().getStar())
                    .param("reviewId",request.getReviewId())
                    .update();


        Long productPk = jdbc.sql("SELECT product_primary_key WHERE id = : id ")
                .param("id", request.getReviewId())
                .query(Long.class)
                .single();

        ProductDTO productDTO = jdbc.sql("SELECT p.product_id , p.name, p.model, p.price" +
                "WHERE id = :id")
                .param("id", productPk)
                .query(ProductDTO.class).single();

        List<ReviewDTO> reviewDTOList = jdbc.sql("SELECT content,star FROM" +
                "customer.reviews WHERE id = :id")
                .param("id", request.getReviewId())
                .query(ReviewDTO.class)
                .list();
        productDTO.setReviews(reviewDTOList);


        return productDTO;

        }catch (DataAccessException exception) {
            throw new InvalidArgumentException("An error arise on database operation");
        }

    }

    private boolean reviewIdExist(Long reviewId) {
        return jdbc.sql("SELECT EXISTS (SELECT 1 FROM customer.reviews WHERE id = :reviewId")
                .param("reviewId", reviewId)
                .query(Boolean.class).single();
    }


}
