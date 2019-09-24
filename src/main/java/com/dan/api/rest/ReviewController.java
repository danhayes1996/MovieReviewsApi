package com.dan.api.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.service.ReviewService;

@RestController
@RequestMapping("review")
public class ReviewController {
	
	private ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
}
