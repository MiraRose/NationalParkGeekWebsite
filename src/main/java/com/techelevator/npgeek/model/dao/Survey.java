package com.techelevator.npgeek.model.dao;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

public class Survey {

	private long id;
	
	@NotBlank(message = "Please select a park!")
	private String parkCode;
	
	@NotBlank(message = "Please enter an email!")
	@Email(message = "Not a valid email!")
	private String email;
	
	@NotBlank(message = "Please select a state!")
	private String state;
	
	@NotBlank(message = "Please select an activity level!")
	private String activityLevel;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getActivityLevel() {
		return activityLevel;
	}
	public void setActivityLevel(String activityLevel) {
		this.activityLevel = activityLevel;
	}
	
}
