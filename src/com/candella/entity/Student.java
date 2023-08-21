package com.candella.entity;

import java.time.LocalDate;

public class Student {
	
	
	
	private String studentId;
	private String studentName;
	private String studentAddress;
	private LocalDate dob;
	private String gender;
	private String bloodGroup;
	private long phoneNo;
	public Student(String studentId, String studentName, String studentAddress, LocalDate dob, String gender,
			String bloodGroup, long phoneNo) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentAddress = studentAddress;
		this.dob = dob;
		this.gender = gender;
		this.bloodGroup = bloodGroup;
		this.phoneNo = phoneNo;
	}
	public Student() {
		// TODO Auto-generated constructor stub

	}
	public String getStudentId() {
		return studentId;
	}
	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAddress() {
		return studentAddress;
	}
	public void setStudentAddress(String studentAddress) {
		this.studentAddress = studentAddress;
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

}
