package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.dto.MovieDTO;
import com.dan.api.service.MovieService;

@RestController
@RequestMapping("movie")
//CANT USE MovieReviewsDTO because infinite loop
public class MovieController {
	
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<MovieDTO> getAll() {
		return service.getAll()
					.stream()
					.map(movie -> new MovieDTO(movie))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public MovieDTO getMovie(@PathVariable("id") long movieId) {
		return new MovieDTO(service.getMovie(movieId));
	}
	
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String createMovie(@RequestBody Movie movie){
		return service.createMovie(movie);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public MovieDTO updateMovie(@PathVariable("id") long movieId, @RequestBody Movie movie){
		return new MovieDTO(service.updateMovie(movieId, movie));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public MovieDTO deleteMovie(@PathVariable("id") long movieId){
		return new MovieDTO(service.deleteMovie(movieId));
	}
}
