package com.dan.api.service;

import org.springframework.stereotype.Service;

import com.dan.api.persistance.repository.MovieRepository;

@Service
public class MovieService {

	private MovieRepository repo;
	
	public MovieService(MovieRepository repo) {
		this.repo = repo;
	}
	
}
