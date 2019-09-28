package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Movie;

public class MovieDTO {

	private long id;
	private String name;
	private String description;
	private String ageRating;
	private String imgUrl;
	
	public MovieDTO(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.description = movie.getDescription();
		this.ageRating = movie.getAgeRating();
		this.imgUrl = movie.getImgUrl();
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
}
