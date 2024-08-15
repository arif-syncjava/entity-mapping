package com.arifsyncjava.entitymapping.jdbc.review.repository;

import com.arifsyncjava.entitymapping.JdbcRepository;
import com.arifsyncjava.entitymapping.dto.request.review.CreateReviewRequest;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class CreateReviewRepository implements JdbcRepository<CreateReviewRequest, ProductDTO> {

    private final JdbcClient jdbc;

    public CreateReviewRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public ProductDTO execute(CreateReviewRequest request) {

        try {
            Long productPk = jdbc.sql("SELECT id FROM customer.products" +
                            " WHERE product_id = :productId")
                    .param("productId", request.getProductId())
                    .query(Long.class).single();

            jdbc.sql("INSERT INTO customer.reviews (content,star,product_primary_key)" +
                            "VALUES (:content,:star,:product_primary_key)")
                    .param("content",request.getReviewBody().getContent())
                    .param("star", request.getReviewBody().getStar())
                    .param("product_primary_key",productPk)
                    .update();


            List<ReviewDTO> reviewDTOList = jdbc.sql("SELECT content, star FROM customer.reviews WHERE product_primary_key = :productPk ")
                    .param("productPk", productPk)
                    .query(ReviewDTO.class)
                    .list();

            ProductDTO productDTO = jdbc.sql("SELECT product_id, name, model ,price " +
                            "FROM customer.products WHERE product_id = :productId")
                    .param("productId", request.getProductId())
                    .query(ProductDTO.class).single();

            productDTO.setReviews(reviewDTOList);

            return productDTO;

        } catch (DataAccessException exception) {
            throw new InvalidArgumentException(exception.getMessage());
        }



    }

}
