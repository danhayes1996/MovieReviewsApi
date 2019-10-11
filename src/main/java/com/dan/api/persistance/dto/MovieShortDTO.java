package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.Movie;

public class MovieShortDTO {

	private long id;
	private String name;
	private String imgUrl;
	private float rating;
	
	public MovieShortDTO(Movie movie) {
		this.id = movie.getId();
		this.name = movie.getName();
		this.imgUrl = movie.getImgUrl();
		this.rating = movie.getRating();
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

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public float getRating() {
		return rating;
	}

	public void setRating(float rating) {
		this.rating = rating;
	}
}
