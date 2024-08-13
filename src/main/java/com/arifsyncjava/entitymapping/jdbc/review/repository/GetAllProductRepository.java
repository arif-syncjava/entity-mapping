package com.arifsyncjava.entitymapping.jdbc.review.repository;

import com.arifsyncjava.entitymapping.JdbcRepository;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import jakarta.transaction.Transactional;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

import java.util.List;

@Transactional
@Repository
public class GetAllProductRepository implements JdbcRepository<Void, List<ProductListDTO>> {

    private final JdbcClient jdbc;

    public GetAllProductRepository(JdbcClient jdbc) {
        this.jdbc = jdbc;
    }

    @Override
    public List<ProductListDTO> execute(Void input) {
        return jdbc.sql("SELECT * FROM customer.products")
                .query(ProductListDTO.class).list();
    }


}
