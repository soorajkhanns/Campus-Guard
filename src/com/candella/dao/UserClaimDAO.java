package com.candella.dao;

import java.util.List;

import com.candella.entity.UserClaims;

public interface UserClaimDAO {
	
	void addUserClaim(UserClaims userclaim);
	UserClaims getUserClaimsById(String claimId);
	List<UserClaims> viewAllUserClaims();

}
