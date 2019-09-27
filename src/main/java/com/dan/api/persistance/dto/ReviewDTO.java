package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Review;

//used to get a review without the user (used in UserDTO)
public class ReviewDTO {

	private long reviewId;
	private String title;
	private String content;
	private long likes;
	private MovieDTO movie;
	
	public ReviewDTO(Review review) {
		this.reviewId = review.getId();
		this.title = review.getTitle();
		this.content = review.getContent();
		this.likes = review.getLikes();
		this.movie = new MovieDTO(review.getMovie());
	}
	
	public long getReviewId() {
		return reviewId;
	}
	
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String reviewTitle) {
		this.title = reviewTitle;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String reviewContent) {
		this.content = reviewContent;
	}
	
	public long getLikes() {
		return likes;
	}
	
	public void setLikes(long reviewLikes) {
		this.likes = reviewLikes;
	}

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}
}
