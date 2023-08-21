package com.candella.entity;

public class ClaimAnalytics {
    private UserClaims userClaim;      // Reference to UserClaims object
    private String claimType;
    private String claimStatus;
    private int claimPercentage;
    
    public ClaimAnalytics( UserClaims userClaim, String claimType, String claimStatus,
			int claimPercentage) {
		super();
		this.userClaim = userClaim;
		this.claimType = claimType;
		this.claimStatus = claimStatus;
		this.claimPercentage = claimPercentage;
	}

	
    public UserClaims getUserClaim() {
        return userClaim;
    }

    public void setUserClaim(UserClaims userClaim) {
        this.userClaim = userClaim;
    }

    public String getClaimType() {
        return claimType;
    }

    public void setClaimType(String claimType) {
        this.claimType = claimType;
    }

    public String getClaimStatus() {
        return claimStatus;
    }

    public void setClaimStatus(String claimStatus) {
        this.claimStatus = claimStatus;
    }

    public int getClaimPercentage() {
        return claimPercentage;
    }

    public void setClaimPercentage(int claimPercentage) {
        this.claimPercentage = claimPercentage;
    }

    // Add constructors as needed (e.g., default constructor, constructor with parameters)

    // Add any other methods or overrides as needed

}
