package com.rewards.api.controller;

import com.rewards.api.model.RewardsResponse;
import com.rewards.api.service.RewardsService;
import org.springframework.web.bind.annotation.*;

/**
 * REST controller that exposes reward calculation endpoints.
 */
@RestController
@RequestMapping("/api/rewards")
public class RewardsController {

    private final RewardsService rewardsService;

    /**
     * Creates a RewardsController.
     *
     * @param rewardsService rewards calculation service
     */
    public RewardsController(RewardsService rewardsService) {
        this.rewardsService = rewardsService;
    }

    /**
     * Returns reward points for a given customer.
     *
     * @param customerId customer identifier
     * @return rewards response containing monthly and total points
     */
    @GetMapping("/{customerId}")
    public RewardsResponse getRewards(@PathVariable String customerId) {
        return rewardsService.calculateRewards(customerId);
    }
}
