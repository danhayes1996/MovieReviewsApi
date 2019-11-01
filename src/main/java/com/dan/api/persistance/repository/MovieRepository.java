package com.dan.api.persistance.repository;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dan.api.persistance.domain.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

	public List<Movie> findByNameContaining(String name);
	
	@Query("SELECT m FROM Movie m ORDER BY m.id DESC")
	public List<Movie> findNewMovies(PageRequest pr);
	
	@Query("SELECT m FROM Movie m ORDER BY m.rating DESC")
	public List<Movie> findHighestRated(PageRequest pr);
}
