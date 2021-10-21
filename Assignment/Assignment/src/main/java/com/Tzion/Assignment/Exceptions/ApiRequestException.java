package com.Tzion.Assignment.Exceptions;

/**
 * Custom API REQUEST exception for bad requestsl like if there is no have
 * a customers in memory or if the customer already exist.
 */
public class ApiRequestException extends RuntimeException{

    public ApiRequestException(String message) {
        super(message);
    }

    public ApiRequestException(String message, Throwable cause) {
        super(message, cause);
    }
}
