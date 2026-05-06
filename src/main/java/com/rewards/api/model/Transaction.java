package com.rewards.api.model;

import java.time.LocalDate;

/**
 * Represents a single customer transaction.
 * Each transaction contains the customer identifier,
 * the transaction amount, and the transaction date.
 */
public class Transaction {

    private String customerId;
    private double amount;
    private LocalDate transactionDate;

    /**
     * Creates a transaction instance.
     *
     * @param customerId       unique customer identifier
     * @param amount           transaction amount
     * @param transactionDate  date of the transaction
     */
    public Transaction(String customerId, double amount, LocalDate transactionDate) {
        this.customerId = customerId;
        this.amount = amount;
        this.transactionDate = transactionDate;
    }

    /**
     * Returns the customer id.
     *
     * @return customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Returns the transaction amount.
     *
     * @return transaction amount
     */
    public double getAmount() {
        return amount;
    }

    /**
     * Returns the transaction date.
     *
     * @return transaction date
     */
    public LocalDate getTransactionDate() {
        return transactionDate;
    }
}