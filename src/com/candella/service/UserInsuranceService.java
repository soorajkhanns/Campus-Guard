package com.candella.service;

import java.util.List;

import com.candella.entity.UserInsurance;

public interface UserInsuranceService {
	 void addUserInsurance(UserInsurance userInsurance);
	    UserInsurance getUserInsuranceById(String enrollmentId);
	    List <UserInsurance>viewAllUserInsurance();

}



