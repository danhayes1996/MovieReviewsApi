package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Review;

public class ReviewDTO {

	private long reviewId;
	private String title;
	private String content;
	private long likes;
	
	public ReviewDTO(Review review) {
		this.reviewId = review.getReviewId();
		this.title = review.getTitle();
		this.content = review.getContent();
		this.likes = review.getLikes();
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
}
