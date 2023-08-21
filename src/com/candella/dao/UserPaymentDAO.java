
	package com.candella.dao;

	import java.util.List;

	import com.candella.entity.UserPayment;

	public interface UserPaymentDAO {
	    void addUserPayment(UserPayment userPayment);
	    UserPayment getUserPaymentById(String paymentId);
	    List<UserPayment> viewAllUserPayments();
	}



