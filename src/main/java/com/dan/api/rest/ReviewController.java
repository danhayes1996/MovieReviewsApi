package com.dan.api.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dan.api.persistance.domain.Review;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.dto.UserReviewDTO;
import com.dan.api.service.ReviewService;

@RestController
@RequestMapping("review")
public class ReviewController {
	
	private ReviewService service;
	
	public ReviewController(ReviewService service) {
		this.service = service;
	}
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<UserReviewDTO> getAll(){
		return service.getAll()
					.stream()
					.map(review -> new UserReviewDTO(review))
					.collect(Collectors.toList());
	}
	
//	public List<ReviewDTO> getAllByUserId(long userId){
//		return service.getAllByUserId(userId)
//				.stream()
//				.map(review -> new ReviewDTO(review))
//				.collect(Collectors.toList());
//	}
	
	@RequestMapping(value = "/get/{id}", method = RequestMethod.GET)
	public UserReviewDTO getReview(@PathVariable("id") long reviewId){
		return new UserReviewDTO(service.getReview(reviewId));
	}
	
	@RequestMapping(value = "/create/{userId}", method = RequestMethod.POST)
	public String createReview(@RequestBody Review review, @PathVariable("userId") User user){
		return service.createReview(review, user);
	}
	
	@RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
	public UserReviewDTO updateReview(@PathVariable("id") long reviewId, @RequestBody Review review){
		return new UserReviewDTO(service.updateReview(reviewId, review));
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public UserReviewDTO deleteReview(@PathVariable("id") long reviewId){
		return new UserReviewDTO(service.deleteReview(reviewId));
	}
}
