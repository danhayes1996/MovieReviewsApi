package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.domain.Review;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.dto.ReviewDTO;
import com.dan.api.persistance.dto.ReviewShortDTO;
import com.dan.api.service.ReviewService;

@CrossOrigin
@RestController
@RequestMapping("review")
public class ReviewController {
	
	private ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<ReviewShortDTO> getAll(){
		return service.getAll()
					.stream()
					.map(review -> new ReviewShortDTO(review))
					.collect(Collectors.toList());
	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public ReviewDTO getReview(@PathVariable("id") long reviewId){
		return new ReviewDTO(service.getReview(reviewId));
	}
	
	@RequestMapping(value = "/create/{movieId}/{userId}", method = RequestMethod.POST)
	public String createReview(@RequestBody Review review, @PathVariable("movieId") Movie movie, @PathVariable("userId") User user){
		return service.createReview(review, movie, user);
	}

	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public ReviewDTO updateReview(@PathVariable("id") long reviewId, @RequestBody Review review){
		return new ReviewDTO(service.updateReview(reviewId, review));
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public ReviewDTO deleteReview(@PathVariable("id") long reviewId){
		return new ReviewDTO(service.deleteReview(reviewId));
	}
}
