package com.arifsyncjava.entitymapping.jpa.review.repository;

import com.arifsyncjava.entitymapping.jpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    Optional<Product> findByProductId (Long productId);


}
