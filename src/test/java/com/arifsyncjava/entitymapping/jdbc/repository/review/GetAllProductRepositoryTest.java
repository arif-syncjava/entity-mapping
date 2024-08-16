package com.arifsyncjava.entitymapping.jdbc.repository.review;

import com.arifsyncjava.entitymapping.dto.response.ProductDTO;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jdbc.review.repository.GetAllProductRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.simple.JdbcClient;

import java.util.List;

@JdbcTest
@AutoConfigureTestDatabase (replace = AutoConfigureTestDatabase.Replace.NONE)
public class GetAllProductRepositoryTest {

    private GetAllProductRepository getAllProductRepository;

    @Autowired
    public GetAllProductRepositoryTest(JdbcClient jdbcClient) {
        getAllProductRepository = new GetAllProductRepository(jdbcClient);
    }

    @Test
    public void GetAllProductRepository_execute_ReturnSuccess() {
        List<ProductListDTO> productDTOList =      // manually saved in the database
                getAllProductRepository.execute(null);
        Assertions.assertThat(productDTOList.size()).isEqualTo(5);

    }








}
