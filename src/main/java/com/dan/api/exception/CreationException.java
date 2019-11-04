package com.dan.api.exception;

public class CreationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public CreationException(String failedCreation) {
		super("Failed to create " + failedCreation + ".");
	}
	
}
