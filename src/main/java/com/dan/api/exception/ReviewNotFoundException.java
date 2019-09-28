package com.dan.api.exception;

public class ReviewNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ReviewNotFoundException(long id) {
		super("Review " + id + " not found");
	}
	
	public ReviewNotFoundException() {
		super("Review not found");
	}
}
