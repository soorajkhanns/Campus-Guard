package com.candella.entity;

import java.time.LocalDate;

public class UserClaims {
	String claimId;
	UserInsurance userInsurance;
	LocalDate claimDate;
	String claimDescription;
	double ClaimAmount;
	double BillAmount;
	LocalDate disbursementDate;
	
	@Override
	public String toString() {
		return "UserClaims [claimId=" + claimId + ", userInsurance=" + userInsurance + ", claimDate=" + claimDate
				+ ", claimDescription=" + claimDescription + ", ClaimAmount="
				+ ClaimAmount + ", BillAmount=" + BillAmount + ", disbursementDate=" + disbursementDate + "]";
	}

	public UserClaims(String claimId, UserInsurance userInsurance, LocalDate claimDate, String claimDescription,
			 double claimAmount, double billAmount, LocalDate disbursementDate) {
		super();
		this.claimId = claimId;
		this.userInsurance = userInsurance;
		this.claimDate = claimDate;
		this.claimDescription = claimDescription;
		ClaimAmount = claimAmount;
		BillAmount = billAmount;
		this.disbursementDate = disbursementDate;
	}
	
	public UserClaims() {
		// TODO Auto-generated constructor stub
	}

	public String getClaimId() {
		return claimId;
	}
	public void setClaimId(String claimId) {
		this.claimId = claimId;
	}
	public UserInsurance getUserInsurance() {
		return userInsurance;
	}
	public void setUserInsurance(UserInsurance userInsurance) {
		this.userInsurance = userInsurance;
	}
	public LocalDate getClaimDate() {
		return claimDate;
	}
	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}
	public String getClaimDescription() {
		return claimDescription;
	}
	public void setClaimDescription(String claimDescription) {
		this.claimDescription = claimDescription;
	}
	
	public double getClaimAmount() {
		return ClaimAmount;
	}
	public void setClaimAmount(double claimAmount) {
		ClaimAmount = claimAmount;
	}
	public double getBillAmount() {
		return BillAmount;
	}
	public void setBillAmount(double billAmount) {
		BillAmount = billAmount;
	}
	public LocalDate getDisbursementDate() {
		return disbursementDate;
	}
	public void setDisbursementDate(LocalDate disbursementDate) {
		this.disbursementDate = disbursementDate;
	}
		
}

						
						
						
						