package com.rewards.api.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for RewardsController.
 */
@SpringBootTest
@AutoConfigureMockMvc
public class RewardsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    /**
     * Tests successful API response for a valid customer.
     */
    @Test
    public void testGetRewardsSuccess() throws Exception {
        mockMvc.perform(get("/api/rewards/C1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerId").value("C1"))
                .andExpect(jsonPath("$.totalPoints").exists());
    }

    /**
     * Tests API error response for invalid customer.
     */
    @Test
    public void testGetRewardsInvalidCustomer() throws Exception {
        mockMvc.perform(get("/api/rewards/UNKNOWN"))
                .andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.error").exists());
    }
}