package com.rewards.api.service;

import com.rewards.api.model.RewardsResponse;

/**
 * Service interface for calculating reward points.
 */
public interface RewardsService {

    /**
     * Calculates reward points for a given customer.
     *
     * @param customerId customer identifier
     * @return rewards response containing monthly and total points
     */
    RewardsResponse calculateRewards(String customerId);
}

