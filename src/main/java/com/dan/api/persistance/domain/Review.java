package com.dan.api.persistance.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;

@Entity
public class Review {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotNull
	@Column(columnDefinition = "VARCHAR(64)")
	private String title;
	
	@NotNull
	@Column(columnDefinition = "BLOB")
	private String content;
	
	@Column(columnDefinition = "BIGINT(20) DEFAULT 0")
	private long likes;
	
	@NotNull
	@Column(columnDefinition = "INT(2)")
	private int rating;
	
	@NotNull
	@ManyToOne
	private Movie movie;
	
	@NotNull
	@ManyToOne
	private User user;

	public long getId() {
		return id;
	}

	public void setId(long reviewId) {
		this.id = reviewId;
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

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
