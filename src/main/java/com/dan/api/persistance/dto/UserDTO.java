package com.dan.api.persistance.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.dan.api.persistance.domain.User;

public class UserDTO {

	private long userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private List<ReviewDTO> reviews;
	
	public UserDTO(User user) {
		this.userId = user.getId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.reviews = user.getReviews()
							.stream()
							.map(review -> new ReviewDTO(review))
							.collect(Collectors.toList());
	}
	
	public long getUserId() {
		return userId;
	}
	
	public void setUserId(long userId) {
		this.userId = userId;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String userEmail) {
		this.email = userEmail;
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

	public List<ReviewDTO> getReviews() {
		return reviews;
	}

	public void setReviews(List<ReviewDTO> reviews) {
		this.reviews = reviews;
	}
}
