package com.dan.api.persistance.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dan.api.persistance.domain.Movie;

public class MovieDTO {

	private long movieId;
	private String name;
	private String description;
	private String ageRating;
	private String imgUrl;
	private List<UserReviewDTO> reviews;
	
	public MovieDTO(Movie movie) {
		this.movieId = movie.getId();
		this.name = movie.getName();
		this.description = movie.getDescription();
		this.ageRating = movie.getAgeRating();
		this.imgUrl = movie.getImgUrl();
		this.reviews = movie.getReviews()
							.stream()
							.map(review -> new UserReviewDTO(review))
							.collect(Collectors.toList());
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAgeRating() {
		return ageRating;
	}

	public void setAgeRating(String ageRating) {
		this.ageRating = ageRating;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public List<UserReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<UserReviewDTO> reviews) {
		this.reviews = reviews;
	}
}
