package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Review;

public class ReviewShortDTO {
	private long id;
	private String title;
	private String content;
	private long likes;
	private long movieId;
	private long userId;
	
	public ReviewShortDTO(Review review) {
		this.id = review.getId();
		this.title = review.getTitle();
		this.content = review.getContent();
		this.likes = review.getLikes();
		this.movieId = review.getMovie().getId();
		this.userId = review.getUser().getId();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public long getLikes() {
		return likes;
	}

	public void setLikes(long likes) {
		this.likes = likes;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}
}
