package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.exception.ReviewNotFoundException;
import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.Movie;
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

	public Review getReview(long reviewId) throws ReviewNotFoundException {
		Optional<Review> result = repo.findById(reviewId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new ReviewNotFoundException(reviewId);
	}
	
	public String createReview(Review review, Movie movie, User user) throws MovieNotFoundException, UserNotFoundException{
		if(movie == null) throw new MovieNotFoundException();
		if(user == null) throw new UserNotFoundException();
		review.setUser(user);
		review.setMovie(movie);
		repo.save(review);
		return "{\"message\":\"Review Successfully Created.\"}";
	}
	
	public Review updateReview(long reviewId, Review newReview) throws ReviewNotFoundException {
		Review oldReview = getReview(reviewId);

		if(newReview.getTitle() != null) oldReview.setTitle(newReview.getTitle());
		if(newReview.getContent() != null) oldReview.setContent(newReview.getContent());
		//TODO: change likes to Long wrapper to check for null?
		oldReview.setLikes(newReview.getLikes());

		repo.save(oldReview);
		return oldReview;
	}
	
	public Review deleteReview(long reviewId) throws ReviewNotFoundException {
		Review review = getReview(reviewId);
		repo.delete(review);
		return review;
	}
}
