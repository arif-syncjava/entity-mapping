package com.arifsyncjava.entitymapping.jdbc.review.service;

import com.arifsyncjava.entitymapping.Query;
import com.arifsyncjava.entitymapping.dto.response.ProductListDTO;
import com.arifsyncjava.entitymapping.jdbc.review.repository.GetAllProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllProductService implements Query<Void, List<ProductListDTO>> {

    private final GetAllProductRepository getAllProductRepository;

    public GetAllProductService(GetAllProductRepository getAllProductRepository) {
        this.getAllProductRepository = getAllProductRepository;
    }


    @Override
    public ResponseEntity<List<ProductListDTO>> execute(Void input) {
        return ResponseEntity
                .ok(getAllProductRepository.execute(null));

    }


}
