package com.dan.api.persistance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dan.api.persistance.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
