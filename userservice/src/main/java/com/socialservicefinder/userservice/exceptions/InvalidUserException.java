package com.socialservicefinder.userservice.exceptions;

public class InvalidUserException extends RuntimeException {
	public InvalidUserException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

	public InvalidUserException(String errorMessage) {
		super(errorMessage);
	}

	public InvalidUserException() {
		super();
	}
}
