package com.Tzion.Assignment.Exceptions;

/**
 * This class will contain the exception details and will handle the exception
 * with appropriate message
 */

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiRequestExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(
            ApiRequestException e){

        HttpStatus badRequest = HttpStatus.BAD_REQUEST;

        //will contain the information about the exception
        ApiRequestExceptionData apiRequestExceptionData = new ApiRequestExceptionData(
                e.getMessage(),
                badRequest,
                ZonedDateTime.now(ZoneId.of("Z"))
        );

        //return the entity itself
        return new ResponseEntity<>(apiRequestExceptionData , badRequest);
    }
}
