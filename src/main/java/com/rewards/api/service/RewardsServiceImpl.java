package com.rewards.api.service;

import com.rewards.api.exception.InvalidTransactionException;
import com.rewards.api.model.RewardsResponse;
import com.rewards.api.model.Transaction;
import com.rewards.api.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.time.Month;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Implementation of reward points calculation logic.
 */
@Service
public class RewardsServiceImpl implements RewardsService {

    private final TransactionRepository transactionRepository;

    public RewardsServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    /**
     * Calculates rewards for the given customer by grouping
     * transactions per month and summing reward points.
     *
     * @param customerId customer identifier
     * @return rewards response
     */
    @Override
    public RewardsResponse calculateRewards(String customerId) {

        List<Transaction> customerTransactions =
                transactionRepository.findAllTransactions()
                        .stream()
                        .filter(t -> t.getCustomerId().equals(customerId))
                        .collect(Collectors.toList());

        if (customerTransactions.isEmpty()) {
            throw new InvalidTransactionException(
                    "No transactions found for customer: " + customerId);
        }

        // Group reward points by transaction month
        Map<Month, Integer> monthlyPoints =
                customerTransactions.stream()
                        .collect(Collectors.groupingBy(
                                t -> t.getTransactionDate().getMonth(),
                                Collectors.summingInt(
                                        t -> calculatePoints(t.getAmount()))
                        ));

        // Calculate total points
        int totalPoints = monthlyPoints.values()
                .stream()
                .mapToInt(Integer::intValue)
                .sum();

        return new RewardsResponse(customerId, monthlyPoints, totalPoints);
    }

    /**
     * Calculates reward points for a single transaction amount.
     *
     * @param amount transaction amount
     * @return reward points
     */
    private int calculatePoints(double amount) {

        if (amount < 0) {
            throw new InvalidTransactionException(
                    "Transaction amount cannot be negative");
        }

        int points = 0;

        if (amount > 100) {
            points += (int) ((amount - 100) * 2);
            amount = 100;
        }

        if (amount > 50) {
            points += (int) (amount - 50);
        }

        return points;
    }
}