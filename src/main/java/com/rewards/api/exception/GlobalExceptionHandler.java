package com.rewards.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler for the application.
 * Converts exceptions into meaningful HTTP responses.
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Handles invalid transaction related errors.
     *
     * @param ex the thrown exception
     * @return error message map
     */
    @ExceptionHandler(InvalidTransactionException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, String> handleInvalidTransactionException(
            InvalidTransactionException ex) {

        Map<String, String> errorResponse = new HashMap<String, String>();
        errorResponse.put("error", ex.getMessage());

        return errorResponse;
    }
}