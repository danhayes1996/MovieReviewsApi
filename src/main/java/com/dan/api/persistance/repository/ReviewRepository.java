package com.dan.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan.api.persistance.domain.Review;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long>{

}
