package com.socialservicefinder.userservice.exceptions;

public class InvalidFetchMyRewardsException extends RuntimeException{
    public InvalidFetchMyRewardsException() {
        super();
    }

    public InvalidFetchMyRewardsException(String message) {
        super(message);
    }

    public InvalidFetchMyRewardsException(String message, Throwable cause) {
        super(message, cause);
    }

}
