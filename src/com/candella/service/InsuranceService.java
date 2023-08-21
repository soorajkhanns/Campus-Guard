package com.candella.service;

import java.util.List;

import com.candella.entity.Insurance;

public interface InsuranceService {
	void addInsurance(Insurance insurance);
	Insurance getInsurance(String planId);
	void updateInsurance(String planId, String column);
	List<Insurance> viewAllInsurance();
	

}
