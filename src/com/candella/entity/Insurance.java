package com.candella.entity;

public class Insurance {
	
	


	@Override
	public String toString() {
		return planId  + "  " + planName + " " + description + " " + coverage
				 +" " + Amount + " " + CoverageLimit + " " + AgeLimit ;
	}
	private String planId;
	private String planName;
	private String description;
	private long coverage;
	private long Amount;
	private double CoverageLimit;
	private int AgeLimit;
	public Insurance(String planId, String planName, String description, long coverage, long amount, double coverageLimit,
			int ageLimit) {
		super();
		this.planId = planId;
		this.planName = planName;
		this.description = description;
		this.coverage = coverage;
		Amount = amount;
		CoverageLimit = coverageLimit;
		AgeLimit = ageLimit;
		
	}
	public Insurance() {
		// TODO Auto-generated constructor stub
	}
	public String getPlanId() {
		return planId;
	}
	public void setPlanId(String planId) {
		this.planId = planId;
	}
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getCoverage() {
		return coverage;
	}
	public void setCoverage(long coverage) {
		this.coverage = coverage;
	}
	public long getAmount() {
		return Amount;
	}
	public void setAmount(long amount) {
		Amount = amount;
	}
	public double getCoverageLimit() {
		return CoverageLimit;
	}
	public void setCoverageLimit(long coverageLimit) {
		CoverageLimit = coverageLimit;
	}
	public int getAgeLimit() {
		return AgeLimit;
	}
	public void setAgeLimit(int ageLimit) {
		AgeLimit = ageLimit;
	}
	

}
