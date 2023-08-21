package com.candella.service;

import java.util.List;

import com.candella.dao.UserPaymentDAO;
import com.candella.dao.UserPaymentDAOImpl;
import com.candella.entity.UserPayment;

public class UserPaymentServiceImpl implements UserPaymentService {
    private UserPaymentDAO userPaymentDAO;

    public UserPaymentServiceImpl() {
        userPaymentDAO = new UserPaymentDAOImpl();
    }

    @Override
    public void addUserPayment(UserPayment userPayment) {
        userPaymentDAO.addUserPayment(userPayment);
    }

    @Override
    public UserPayment getUserPaymentById(String paymentId) {
        return userPaymentDAO.getUserPaymentById(paymentId);
    }

    @Override
    public List<UserPayment> viewAllUserPayments() {
        return userPaymentDAO.viewAllUserPayments();
    }
}
