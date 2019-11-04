package com.dan.api.service;

import java.util.List;

import com.dan.api.exception.CreationException;
import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.exception.ReviewNotFoundException;
import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.domain.Review;
import com.dan.api.persistance.domain.User;

public interface ReviewService {
	
	public List<Review> getAll();
	public Review getReview(long reviewId) throws ReviewNotFoundException;
	public Review createReview(Review review, Movie movie, User user) throws CreationException, MovieNotFoundException, UserNotFoundException;
	public Review updateReview(long reviewId, Review newReview) throws ReviewNotFoundException;
	public Review deleteReview(long reviewId) throws ReviewNotFoundException;

}
