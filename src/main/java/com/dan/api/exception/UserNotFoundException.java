package com.dan.api.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(long id) {
		super("User id not found: " + id);
	}
	
	public UserNotFoundException() {
		super("User not found");
	}
}
