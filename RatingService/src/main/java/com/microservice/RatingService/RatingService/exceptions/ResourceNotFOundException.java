package com.microservice.RatingService.RatingService.exceptions;

public class ResourceNotFOundException extends RuntimeException {
    public ResourceNotFOundException(String s) {
        super(s);
    }

    public ResourceNotFOundException() {
        super("Resource Not Found");
    }
}
