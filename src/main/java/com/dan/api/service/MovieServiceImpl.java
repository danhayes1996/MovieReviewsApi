package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.api.exception.CreationException;
import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.repository.MovieRepository;

@Service
@Primary
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository repo;
	
	@Override
	public List<Movie> getAll() {
		return repo.findAll();
	}

	@Override
	public Movie getMovieById(long MovieId) throws MovieNotFoundException {
		Optional<Movie> result = repo.findById(MovieId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new MovieNotFoundException(MovieId);
	}

	@Override
	public List<Movie> getMovies(String name) {
		return repo.findByNameContaining(name);
	}

	@Override
	public List<Movie> getNewMovies(int count) {
		return repo.findNewMovies(PageRequest.of(0, count));
	}
	
	@Override
	public List<Movie> getHighestRatedMovies(int count) {
		return repo.findHighestRated(PageRequest.of(0, count));
	}

	@Override
	@Transactional
	public Movie createMovie(Movie movie) {
		Movie result = repo.save(movie);
		if(result == null) throw new CreationException("movie");
		else return result;
	}

	@Override
	@Transactional
	public Movie updateMovie(long movieId, Movie newMovie) throws MovieNotFoundException {
		Movie oldMovie = getMovieById(movieId);
		
		if(newMovie.getName() != null) oldMovie.setName(newMovie.getName());
		if(newMovie.getDescription() != null) oldMovie.setDescription(newMovie.getDescription());
		if(newMovie.getAgeRating() != null) oldMovie.setAgeRating(newMovie.getAgeRating());
		if(newMovie.getImgUrl() != null) oldMovie.setImgUrl(newMovie.getImgUrl());
		
		repo.save(oldMovie);
		return oldMovie;
	}

	@Override
	@Transactional
	public Movie deleteMovie(long movieId) throws MovieNotFoundException {
		Movie movie = getMovieById(movieId);
		repo.delete(movie);
		return movie;
	}
}
