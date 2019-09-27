package com.dan.api.persistance.dto;

import com.dan.api.persistance.domain.User;

public class UserDTO {

	private long userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	
	public UserDTO(User user) {
		this.userId = user.getUserId();
		this.email = user.getEmail();
		this.password = user.getPassword();
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
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

	public void setUserPassword(String userPassword) {
		this.password = userPassword;
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
}
