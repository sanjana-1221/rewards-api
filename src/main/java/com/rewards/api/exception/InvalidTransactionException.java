package com.rewards.api.exception;

/**
 * Exception thrown when transaction data is invalid
 * or when no transactions are available for a customer.
 */
public class InvalidTransactionException extends RuntimeException {

    /**
     * Creates a new InvalidTransactionException.
     *
     * @param message error message
     */
    public InvalidTransactionException(String message) {
        super(message);
    }
}
