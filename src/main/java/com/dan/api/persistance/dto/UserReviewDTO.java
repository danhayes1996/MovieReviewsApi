package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Review;

public class UserReviewDTO {

	private long reviewId;
	private String title;
	private String content;
	private long likes;
	private long userId;
	
	public UserReviewDTO(Review review) {
		this.reviewId = review.getId();
		this.title = review.getTitle();
		this.content = review.getContent();
		this.likes = review.getLikes();
		this.userId = review.getUser().getId();
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
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
}
