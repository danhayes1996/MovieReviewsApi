package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dan.api.exception.ReviewNotFoundException;
import com.dan.api.persistance.domain.Review;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.repository.ReviewRepository;

@Service
public class ReviewService {

	private ReviewRepository repo;

	public ReviewService(ReviewRepository repo) {
		this.repo = repo;
	}
	
	public List<Review> getAll(){
		return repo.findAll();
	}

	public Review getReview(long ReviewId) throws ReviewNotFoundException {
		Optional<Review> result = repo.findById(ReviewId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new ReviewNotFoundException(ReviewId);
	}
	
	public String createReview(Review review, User user) {
		review.setUser(user);
		Review result = repo.save(review);
		if(result != null) {
			return "{\"message\":\"Review Successfully Created.\"}";
		}
		return "{\"error\":true, \"message\":\"Failed to Create Review.\"}";
	}
	
	public Review updateReview(long reviewId, Review newReview) throws ReviewNotFoundException {
		Review oldReview = getReview(reviewId);
		//if(newReview.getEmail() != null) oldReview.setEmail(newReview.getEmail());
		repo.save(oldReview);
		return oldReview;
	}
	
	public Review deleteReview(long reviewId) throws ReviewNotFoundException {
		Review review = getReview(reviewId);
		repo.delete(review);
		return review;
	}
}
