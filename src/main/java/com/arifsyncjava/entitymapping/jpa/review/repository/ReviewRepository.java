package com.arifsyncjava.entitymapping.jpa.review.repository;

import com.arifsyncjava.entitymapping.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {





}
