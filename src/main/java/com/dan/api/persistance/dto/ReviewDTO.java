package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Review;

public class ReviewDTO {

	private long id;
	private String title;
	private String content;
	private long likes;
	private MovieDTO movie;
	private UserDTO user;
	
	public ReviewDTO(Review review) {
		this.id = review.getId();
		this.title = review.getTitle();
		this.content = review.getContent();
		this.likes = review.getLikes();
		this.movie = new MovieDTO(review.getMovie());
		this.user = new UserDTO(review.getUser());
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

	public MovieDTO getMovie() {
		return movie;
	}

	public void setMovie(MovieDTO movie) {
		this.movie = movie;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}
}
