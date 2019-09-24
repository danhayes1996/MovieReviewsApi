package com.dan.api.exception;

public class UserNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public UserNotFoundException(long userId) {
		super("User " + userId + " not found");
	}
}
