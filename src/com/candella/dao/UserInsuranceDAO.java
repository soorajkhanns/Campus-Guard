package com.candella.dao;

import java.util.List;

import com.candella.entity.UserInsurance;

public interface UserInsuranceDAO {
	
	 void addUserInsurance(UserInsurance userInsurance);
	    UserInsurance getUserInsuranceById(String enrollmentId);
	    List <UserInsurance>viewAllUserInsurance();

}
