package com.dan.api.persistance.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dan.api.persistance.domain.Movie;

public class MovieReviewsDTO {
	private long id;
	private String name;
	private String description;
	private String ageRating;
	private String imgUrl;
	private int runtime;
	private float rating;
	private int ratingsCount;
	private List<ReviewUserDTO> reviews;
	
	public MovieReviewsDTO(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.description = movie.getDescription();
		this.ageRating = movie.getAgeRating();
		this.imgUrl = movie.getImgUrl();
		this.runtime = movie.getRuntime();
		this.rating = movie.getRating();
		this.ratingsCount = movie.getRatingsCount();
		this.reviews = movie.getReviews()
							.stream()
							.map(review -> new ReviewUserDTO(review))
							.collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public int getRuntime() {
		return runtime;
	}

	public void setRuntime(int runtime) {
		this.runtime = runtime;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}

	public int getRatingsCount() {
		return ratingsCount;
	}

	public void setRatingsCount(int ratingsCount) {
		this.ratingsCount = ratingsCount;
	}
	
	public List<ReviewUserDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewUserDTO> reviews) {
		this.reviews = reviews;
	}
	
}
