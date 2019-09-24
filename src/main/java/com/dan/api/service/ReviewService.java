package com.dan.api.service;

import org.springframework.stereotype.Service;

import com.dan.api.persistance.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository repo;

	public ReviewService(ReviewRepository repo) {
		this.repo = repo;
	}
	
}
