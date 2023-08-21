package com.candella.entity;

import java.time.LocalDate;

public class UserInsurance {
	
	
	private String enrollmentId;
	private String userId;
	private Insurance insurance;
	private UserRole userRole;
	private LocalDate enrollmentDate;
	private LocalDate expiryDate;
	public UserInsurance(String enrollmentId, String userId, Insurance insurance, UserRole userRole,
			LocalDate enrollmentDate, LocalDate expiryDate) {
		super();
		this.enrollmentId = enrollmentId;
		this.userId = userId;
		this.insurance = insurance;
		this.userRole = userRole;
		this.enrollmentDate = enrollmentDate;
		this.expiryDate = expiryDate;
	}
	public UserInsurance() {
		// TODO Auto-generated constructor stub
	}
	public String getEnrollmentId() {
		return enrollmentId;
	}
	public void setEnrollmentId(String enrollmentId) {
		this.enrollmentId = enrollmentId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public Insurance getInsurance() {
		return insurance;
	}
	public void setInsurance(Insurance insurance) {
		this.insurance = insurance;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}
	public LocalDate getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDate enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	public LocalDate getExpiryDate() {
		return expiryDate;
	}
	public void setExpiryDate(LocalDate expiryDate) {
		this.expiryDate = expiryDate;
	}
	@Override
	public String toString() {
		return "" + enrollmentId + "\t" + userId + "\t" + insurance.getPlanId()
				+ "\t" + userRole.getUserRoleId() + "\t" + enrollmentDate + "\t" + expiryDate + "]";
	}
	
}