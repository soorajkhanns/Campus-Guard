package com.candella.entity;

import java.time.LocalDate;

public class UserPayment {
    private String paymentId;
    private UserInsurance userInsurance;
    private UserRole userRole;
    private LocalDate paymentDate;
    private double amount;
	public UserPayment(String paymentId, UserInsurance userInsurance, UserRole userRole, LocalDate paymentDate,
			double amount) {
		super();
		this.paymentId = paymentId;
		this.userInsurance = userInsurance;
		this.userRole = userRole;
		this.paymentDate = paymentDate;
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "UserPayment [paymentId=" + paymentId + ", userInsurance=" + userInsurance + ", userRole=" + userRole
				+ ", paymentDate=" + paymentDate + ", amount=" + amount + "]";
	}
	public String getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}
	public UserInsurance getUserInsurance() {
		return userInsurance;
	}
	public void setUserInsurance(UserInsurance userInsurance) {
		this.userInsurance = userInsurance;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public LocalDate getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}

    
}
