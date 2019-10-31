package com.dan.api.exception;

public class MovieNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MovieNotFoundException(long id) {
		super("Movie id not found: " + id);
	}
	
	public MovieNotFoundException() {
		super("Movie not found");
	}
}
