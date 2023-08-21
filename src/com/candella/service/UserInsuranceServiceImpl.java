package com.candella.service;

import java.util.List;

import com.candella.dao.UserInsuranceDAO;
import com.candella.dao.UserInsuranceDAOImpl;
import com.candella.entity.UserInsurance;

public class UserInsuranceServiceImpl implements UserInsuranceService {

    private UserInsuranceDAO userInsuranceDAO;

    public UserInsuranceServiceImpl() {
        // Initialize the DAO implementation
        userInsuranceDAO = new UserInsuranceDAOImpl();
    }

    @Override
    public void addUserInsurance(UserInsurance userInsurance) {
        userInsuranceDAO.addUserInsurance(userInsurance);
    }

    @Override
    public UserInsurance getUserInsuranceById(String enrollmentId) {
        return userInsuranceDAO.getUserInsuranceById(enrollmentId);
    }

    @Override
    public List<UserInsurance> viewAllUserInsurance() {
        return userInsuranceDAO.viewAllUserInsurance();
    }
}
