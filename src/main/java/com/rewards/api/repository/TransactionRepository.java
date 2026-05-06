package com.rewards.api.repository;

import com.rewards.api.model.Transaction;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

/**
 * Repository that provides mock transaction data.
 * This simulates a data source without using a database.
 */
@Repository
public class TransactionRepository {

    /**
     * Returns a list of all transactions.
     *
     * @return list of transactions
     */
    public List<Transaction> findAllTransactions() {
        return Arrays.asList(
                // Customer C1 transactions
                new Transaction("C1", 120.00, LocalDate.of(2026, 1, 10)),
                new Transaction("C1", 75.00, LocalDate.of(2026, 2, 5)),
                new Transaction("C1", 200.00, LocalDate.of(2026, 3, 15)),

                // Customer C2 transactions
                new Transaction("C2", 50.00, LocalDate.of(2026, 1, 20)),
                new Transaction("C2", 90.00, LocalDate.of(2026, 2, 12)),
                new Transaction("C2", 130.00, LocalDate.of(2026, 3, 25))
        );
    }
}

