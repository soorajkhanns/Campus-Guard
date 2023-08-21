package com.candella.service;

import java.util.List;

import com.candella.entity.UserPayment;

public interface UserPaymentService {
    void addUserPayment(UserPayment userPayment);
    UserPayment getUserPaymentById(String paymentId);
    List<UserPayment> viewAllUserPayments();
}
