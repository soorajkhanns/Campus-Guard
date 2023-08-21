package com.candella.service;

import java.util.List;

import com.candella.dao.ClaimAnalyticsDAOImpl;
import com.candella.entity.ClaimAnalytics;
import com.candella.entity.UserClaims;

public class ClaimAnalyticsServiceImpl implements ClaimAnalyticsService {

    

    private ClaimAnalyticsDAOImpl claimAnalyticsDAOImpl=new ClaimAnalyticsDAOImpl();


    public ClaimAnalyticsServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
    public void addClaimAnalytics(ClaimAnalytics claimAnalytics) {
        claimAnalyticsDAOImpl.addClaimAnalytics(claimAnalytics);
    }

    @Override
    public ClaimAnalytics getClaimAnalyticsById(UserClaims claimId) {
        return claimAnalyticsDAOImpl.getClaimAnalyticsById(claimId);
    }


    @Override
    public List<ClaimAnalytics> viewClaimAnalyticsByClaimId(String claimId) {
        return claimAnalyticsDAOImpl.viewClaimAnalyticsByClaimId(claimId);
    }

	@Override
	public List<ClaimAnalytics> viewAllClaimAnalytics() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double calculateAverageClaimPercentageForPlan(String planId) {
        return claimAnalyticsDAOImpl.calculateAverageClaimPercentageForPlan(planId);
	}


}
