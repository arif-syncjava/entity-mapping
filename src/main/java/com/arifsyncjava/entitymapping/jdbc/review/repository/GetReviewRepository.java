package com.arifsyncjava.entitymapping.jdbc.review.repository;

import com.arifsyncjava.entitymapping.JdbcRepository;
import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ReviewDTO;
import com.arifsyncjava.entitymapping.exception.ErrorMessage;
import com.arifsyncjava.entitymapping.exceptions.InvalidArgumentException;
import jakarta.transaction.Transactional;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class GetReviewRepository implements JdbcRepository<Long, ProductDTO> {

    private final JdbcClient jdbc;

    public GetReviewRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }


    @Override
    public ProductDTO execute(Long productId) {
        if (!productIdExist(productId)) {
            throw new InvalidArgumentException(
                    ErrorMessage.RESOURCE_NOT_FOUND.getMessage());
        }
        try {

            Long productPk = jdbc.sql("SELECT id FROM customer.products" +
                            " WHERE product_id = :productId ")
                    .param("productId", productId)
                    .query(Long.class)
                    .single();

            List<ReviewDTO> reviewDTOList = jdbc.sql("SELECT content, star FROM customer.reviews WHERE product_primary_key = :productPk ")
                    .param("productPk", productPk)
                    .query(ReviewDTO.class)
                    .list();

            ProductDTO productDTO = jdbc.sql("SELECT product_id, name, model ,price " +
                            "FROM customer.products WHERE id = :productPk")
                    .param("productPk", productPk)
                    .query(ProductDTO.class).single();

            productDTO.setReviews(reviewDTOList);

            return productDTO;

        } catch (DataAccessException exception) {
            throw new InvalidArgumentException(exception.getMessage());
        }


    }

    private boolean productIdExist(Long productId) {
        return jdbc.sql("SELECT EXISTS " +
                        "(SELECT 1 FROM customer.products WHERE product_id = :productId )")
                .param("productId", productId)
                .query(Boolean.class)
                .single();
    }


}
