package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.repository.MovieRepository;

@Service
public class MovieService {

	private MovieRepository repo;
	
	public MovieService(MovieRepository repo) {
		this.repo = repo;
	}
	
	public List<Movie> getAll() {
		return repo.findAll();
	}
	
	public Movie getMovieById(long MovieId) throws MovieNotFoundException {
		Optional<Movie> result = repo.findById(MovieId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new MovieNotFoundException(MovieId);
	}
	
	public List<Movie> getMovies(String name) {
		return repo.findByNameContaining(name);
	}
	
	public List<Movie> getNewMovies(int count) {
		return repo.findNewMovies(PageRequest.of(0, count));
	}
	
	public String createMovie(Movie movie) {
		Movie result = repo.save(movie);
		if(result != null) {
			return "{\"message\":\"Movie Successfully Created.\"}";
		}
		return "{\"error\":true, \"message\":\"Failed to Create Movie.\"}";
	}
	
	public Movie updateMovie(long movieId, Movie newMovie) throws MovieNotFoundException {
		Movie oldMovie = getMovieById(movieId);
		
		if(newMovie.getName() != null) oldMovie.setName(newMovie.getName());
		if(newMovie.getDescription() != null) oldMovie.setDescription(newMovie.getDescription());
		if(newMovie.getAgeRating() != null) oldMovie.setAgeRating(newMovie.getAgeRating());
		if(newMovie.getImgUrl() != null) oldMovie.setImgUrl(newMovie.getImgUrl());
		
		repo.save(oldMovie);
		return oldMovie;
	}
	
	public Movie deleteMovie(long movieId) throws MovieNotFoundException {
		Movie movie = getMovieById(movieId);
		repo.delete(movie);
		return movie;
	}
}
