package com.candella.service;

import java.util.List;

import com.candella.dao.InsuranceDAOImpl;
import com.candella.entity.Insurance;

public class InsuranceServiceImpl implements InsuranceService {
	
	 private InsuranceDAOImpl insuranceDAO;

	    public InsuranceServiceImpl() {
	        // Initialize the DAO implementation
	       insuranceDAO = new InsuranceDAOImpl();
	    }

	@Override
	public void addInsurance(Insurance insurance) {
           insuranceDAO.addInsurance(insurance);	
	}

	@Override
	public Insurance getInsurance(String planId) {
		Insurance insurance = insuranceDAO.getInsurance(planId);
		return insurance;
	}

	@Override
	public void updateInsurance(String planId, String column) {
		insuranceDAO.updateInsurance(planId, column);
		
	}

	@Override
	public List<Insurance> viewAllInsurance() {
		
		return insuranceDAO.viewAllInsurance();
		 
	}

}
