package com.dan.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.service.MovieService;

@RestController
@RequestMapping("movie")
public class MovieController {
	
	private MovieService service;
	
	public MovieController(MovieService service) {
		this.service = service;
	}
}
