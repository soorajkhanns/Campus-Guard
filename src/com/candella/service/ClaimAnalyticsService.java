package com.candella.service;

import java.util.List;
import com.candella.entity.ClaimAnalytics;
import com.candella.entity.UserClaims;

public interface ClaimAnalyticsService {
    void addClaimAnalytics(ClaimAnalytics claimAnalytics);
    ClaimAnalytics getClaimAnalyticsById(UserClaims claimId);
    List<ClaimAnalytics> viewAllClaimAnalytics();
    double calculateAverageClaimPercentageForPlan(String planId);

    List<ClaimAnalytics> viewClaimAnalyticsByClaimId(String claimId);
}
