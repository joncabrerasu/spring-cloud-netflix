package com.onfleek.turnservice.core.usecase;

public class TurnBadRequestException extends RuntimeException {
    public TurnBadRequestException(String message) {
        super(message);
    }
}
