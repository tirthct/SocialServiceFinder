package com.socialservicefinder.organizationservice.exceptions;

public class InvalidLoginException extends RuntimeException{
    public InvalidLoginException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidLoginException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidLoginException() {
        super();
    }
}
