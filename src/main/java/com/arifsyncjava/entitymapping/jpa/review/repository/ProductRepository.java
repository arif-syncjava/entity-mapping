package com.arifsyncjava.entitymapping.jpa.review.repository;

import com.arifsyncjava.entitymapping.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
