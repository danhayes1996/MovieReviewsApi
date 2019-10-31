package com.dan.api.exception;

public class InvalidAccountDetailsException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public InvalidAccountDetailsException() {
		super("Invalid Login Details");
	}
}
