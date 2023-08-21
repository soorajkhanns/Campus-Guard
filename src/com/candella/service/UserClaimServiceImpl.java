package com.candella.service;

import java.util.List;

import com.candella.dao.UserClaimDAO;
import com.candella.dao.UserClaimDAOImpl;
import com.candella.entity.UserClaims;

public class UserClaimServiceImpl implements UserClaimService {
	UserClaimDAO userClaimDAO =new UserClaimDAOImpl();
	
	
	@Override
	public void addUserClaim(UserClaims userclaim) {
		userClaimDAO.addUserClaim(userclaim);
	}

	@Override
	public UserClaims getUserClaimsById(String claimId) {
		return userClaimDAO.getUserClaimsById(claimId);
		
		
	}

	@Override
	public List<UserClaims> viewAllUserClaims() {
		return userClaimDAO.viewAllUserClaims();
	}
	
}

