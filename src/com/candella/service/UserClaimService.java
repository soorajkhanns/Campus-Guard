package com.candella.service;

import java.util.List;

import com.candella.entity.UserClaims;

public interface UserClaimService {
	
	void addUserClaim(UserClaims userclaim);
	UserClaims getUserClaimsById(String claimId);
	List<UserClaims> viewAllUserClaims();


}
