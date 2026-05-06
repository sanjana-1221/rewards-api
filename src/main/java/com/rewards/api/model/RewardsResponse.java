package com.rewards.api.model;

import java.time.Month;
import java.util.Map;

/**
 * Represents the reward points summary for a customer.
 * Contains monthly reward points and total reward points.
 */
public class RewardsResponse {

    private String customerId;
    private Map<Month, Integer> monthlyPoints;
    private int totalPoints;

    /**
     * Creates a rewards response.
     *
     * @param customerId      customer identifier
     * @param monthlyPoints  reward points grouped by month
     * @param totalPoints    total reward points
     */
    public RewardsResponse(String customerId, Map<Month, Integer> monthlyPoints, int totalPoints) {
        this.customerId = customerId;
        this.monthlyPoints = monthlyPoints;
        this.totalPoints = totalPoints;
    }

    /**
     * Returns customer id.
     *
     * @return customer id
     */
    public String getCustomerId() {
        return customerId;
    }

    /**
     * Returns reward points grouped by month.
     *
     * @return map of Month to points
     */
    public Map<Month, Integer> getMonthlyPoints() {
        return monthlyPoints;
    }

    /**
     * Returns total reward points.
     *
     * @return total points
     */
    public int getTotalPoints() {
        return totalPoints;
    }
}
