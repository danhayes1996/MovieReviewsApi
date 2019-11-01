package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.dto.MovieReviewsDTO;
import com.dan.api.persistance.dto.MovieShortDTO;
import com.dan.api.service.MovieService;

@CrossOrigin
@RestController
@RequestMapping("movie")
public class MovieController {
	
	@Autowired
	private MovieService service;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<MovieReviewsDTO> getAll() { 
		return service.getAll()
					.stream()
					.map(movie -> new MovieReviewsDTO(movie))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public MovieReviewsDTO getMovieById(@PathVariable("id") long movieId) {
		return new MovieReviewsDTO(service.getMovieById(movieId));
	}
	
	@RequestMapping(value = "/new/{count}", method = RequestMethod.GET)
	public List<MovieShortDTO> getNewMovies(@PathVariable("count") int count) {
		return service.getNewMovies(count)
					.stream()
					.map(movie -> new MovieShortDTO(movie))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/best/{count}", method = RequestMethod.GET)
	public List<MovieShortDTO> getHighestRatedMovies(@PathVariable("count") int count) {
		return service.getHighestRatedMovies(count)
					.stream()
					.map(movie -> new MovieShortDTO(movie))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/find/{name}", method = RequestMethod.GET)
	public List<MovieShortDTO> getMovies(@PathVariable("name") String name) { 
		return service.getMovies(name)
					.stream()
					.map(movie -> new MovieShortDTO(movie))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public MovieReviewsDTO updateMovie(@PathVariable("id") long movieId, @RequestBody Movie movie){
		return new MovieReviewsDTO(service.updateMovie(movieId, movie));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public MovieReviewsDTO deleteMovie(@PathVariable("id") long movieId){
		return new MovieReviewsDTO(service.deleteMovie(movieId));
	}
}
