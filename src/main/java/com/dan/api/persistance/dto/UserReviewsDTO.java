package com.dan.api.persistance.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dan.api.persistance.domain.User;

public class UserReviewsDTO {

	private long id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private List<ReviewMovieDTO> reviews;
	
	public UserReviewsDTO(User user) {
		this.id = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.reviews = user.getReviews()
							.stream()
							.map(review -> new ReviewMovieDTO(review))
							.collect(Collectors.toList());
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public List<ReviewMovieDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewMovieDTO> reviews) {
		this.reviews = reviews;
	}
}
