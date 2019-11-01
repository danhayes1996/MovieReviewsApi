package com.dan.api.service;

import java.util.List;

import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.persistance.domain.Movie;

public interface MovieService {
	
	public List<Movie> getAll();
	public Movie getMovieById(long MovieId) throws MovieNotFoundException;
	public List<Movie> getMovies(String name);
	public List<Movie> getNewMovies(int count);
	public List<Movie> getHighestRatedMovies(int count);
	public String createMovie(Movie movie);
	public Movie updateMovie(long movieId, Movie newMovie) throws MovieNotFoundException;
	public Movie deleteMovie(long movieId) throws MovieNotFoundException;

}
