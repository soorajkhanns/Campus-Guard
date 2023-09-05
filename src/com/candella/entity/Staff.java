package com.candella.entity;

import java.time.LocalDate;

public class Staff {
	
	private String staffId;
	private String staffName;
	private String staffAddress;
	public String getStaffId() {
		return staffId;
	}
	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}
	public String getStaffName() {
		return staffName;
	}
	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}
	public String getStaffAddress() {
		return staffAddress;
	}
	public void setStaffAddress(String staffAddress) {
		this.staffAddress = staffAddress;
	}
	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodGroup() {
		return bloodGroup;
	}
	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public Staff(String staffId, String staffName, String staffAddress, LocalDate dob, String gender, String bloodGroup,
			long phoneNo) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.staffAddress = staffAddress;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.phoneNo = phoneNo;
	}
	
	@Override
	public String toString() {    
		return "Staff [staffId=" + staffId + ", staffName=" + staffName + ", staffAddress=" + staffAddress + ", dob="
				+ dob + ", gender=" + gender + ", bloodGroup=" + bloodGroup + ", phoneNo=" + phoneNo + "]";
	}
	public Staff() {
		// TODO Auto-generated constructor stub
	}
	private LocalDate dob;
	private String gender;
	private String bloodGroup;
	private long phoneNo;
	
	

}
