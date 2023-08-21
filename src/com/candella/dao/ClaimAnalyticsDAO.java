package com.candella.dao;

import java.util.List;
import com.candella.entity.ClaimAnalytics;
import com.candella.entity.UserClaims;

public interface ClaimAnalyticsDAO {
    void addClaimAnalytics(ClaimAnalytics claimAnalytics);
    ClaimAnalytics getClaimAnalyticsById(UserClaims claimId);
    double calculateAverageClaimPercentageForPlan(String planId);
    List<ClaimAnalytics> viewClaimAnalyticsByClaimId(String claimId);
}
