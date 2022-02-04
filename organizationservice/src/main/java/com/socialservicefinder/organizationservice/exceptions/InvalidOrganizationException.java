package com.socialservicefinder.organizationservice.exceptions;

public class InvalidOrganizationException extends RuntimeException {
    public InvalidOrganizationException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }

    public InvalidOrganizationException(String errorMessage) {
        super(errorMessage);
    }

    public InvalidOrganizationException() {
        super();
    }
}
