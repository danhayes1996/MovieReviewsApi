package com.dan.api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.dan.api.exception.MovieNotFoundException;
import com.dan.api.exception.ReviewNotFoundException;
import com.dan.api.exception.UserNotFoundException;
import com.dan.api.persistance.domain.Movie;
import com.dan.api.persistance.domain.Review;
import com.dan.api.persistance.domain.User;
import com.dan.api.persistance.repository.ReviewRepository;

@Service
@Primary
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	private ReviewRepository repo;
	
	@Override
	public List<Review> getAll(){
		return repo.findAll();
	}

	@Override
	public Review getReview(long reviewId) throws ReviewNotFoundException {
		Optional<Review> result = repo.findById(reviewId);
		if(result.isPresent()) {
			return result.get();
		}
		throw new ReviewNotFoundException(reviewId);
	}

	@Override
	@Transactional
	public String createReview(Review review, Movie movie, User user) throws MovieNotFoundException, UserNotFoundException {
		if(movie == null) throw new MovieNotFoundException();
		if(user == null) throw new UserNotFoundException();
		
		review.setUser(user);
		review.setMovie(movie);
		movie.addRating(review.getRating());
		
		repo.save(review);
		return "{\"message\":\"Review Successfully Created.\"}";
	}

	@Override
	@Transactional
	public Review updateReview(long reviewId, Review newReview) throws ReviewNotFoundException {
		Review oldReview = getReview(reviewId);

		if(newReview.getTitle() != null) oldReview.setTitle(newReview.getTitle());
		if(newReview.getContent() != null) oldReview.setContent(newReview.getContent());
		//TODO: change likes to Long wrapper to check for null?
		oldReview.setLikes(newReview.getLikes());

		repo.save(oldReview);
		return oldReview;
	}

	@Override
	@Transactional
	public Review deleteReview(long reviewId) throws ReviewNotFoundException {
		Review review = getReview(reviewId);
		Movie m = review.getMovie();
		m.removeRating(review.getRating());
		
		repo.delete(review);
		return review;
	}
}
