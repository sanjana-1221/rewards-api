package com.rewards.api.service;

import com.rewards.api.exception.InvalidTransactionException;
import com.rewards.api.model.RewardsResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for RewardsService.
 */
@SpringBootTest
public class RewardsServiceTest {

    @Autowired
    private RewardsService rewardsService;

    /**
     * Tests reward calculation for a valid customer.
     */
    @Test
    public void testCalculateRewardsForValidCustomer() {
        RewardsResponse response = rewardsService.calculateRewards("C1");

        assertNotNull(response);
        assertEquals("C1", response.getCustomerId());
        assertTrue(response.getTotalPoints() > 0);
        assertFalse(response.getMonthlyPoints().isEmpty());
    }

    /**
     * Tests exception handling for invalid customer.
     */
    @Test
    public void testCalculateRewardsForInvalidCustomer() {
        Exception exception = assertThrows(
                InvalidTransactionException.class,
                () -> rewardsService.calculateRewards("INVALID")
        );

        assertTrue(exception.getMessage().contains("No transactions found"));
    }
}
