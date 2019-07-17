package com.techelevator.npgeek.model.dao;

public class SurveyResult {

	private String parkCode;
	private int surveyCount;
	private String parkName;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getSurveyCount() {
		return surveyCount;
	}
	public void setSurveyCount(int surveyCount) {
		this.surveyCount = surveyCount;
	}
	public String getParkName() {
		return parkName;
	}
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
}
