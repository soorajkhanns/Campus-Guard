package com.candella.entity;

public class UserRole {
	
	public UserRole(String userRoleId, String userType) {
		super();
		this.userRoleId = userRoleId;
		this.userType = userType;
	}
	public UserRole() {
		// TODO Auto-generated constructor stub
	}
	private String userRoleId;
	private String userType;
	@Override
	public String toString() {
		return "UserRole [userRoleId=" + userRoleId + ", userType=" + userType + "]";
	}
	public String getUserRoleId() {
		return userRoleId;
	}
	public void setUserRoleId(String userRoleId) {
		this.userRoleId = userRoleId;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
}
	