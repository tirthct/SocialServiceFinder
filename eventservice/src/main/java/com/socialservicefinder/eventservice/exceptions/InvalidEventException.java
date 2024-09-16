package com.socialservicefinder.eventservice.exceptions;

public class InvalidEventException extends RuntimeException {
    public InvalidEventException() {
        super();
    }

    public InvalidEventException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidEventException(String errorMessage, Throwable throwable) {
        super(errorMessage, throwable);
    }
}
