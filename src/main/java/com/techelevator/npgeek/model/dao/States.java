package com.techelevator.npgeek.model.dao;

import java.util.Arrays;

public class States {

	private String[] states;

	public String[] getStates() {
		
		String[] states = {"California", "Alabama", "Arkansas", "Arizona", "Alaska", "Colorado", 
				"Connecticut", "Delaware", "Florida", "Georgia", "Hawaii", "Idaho", "Illinois", 
				"Indiana", "Iowa", "Kansas", "Kentucky", "Louisiana", "Maine", "Maryland", 
				"Massachusetts", "Michigan", "Minnesota", "Mississippi", "Missouri", "Montana", 
				"Nebraska", "Nevada", "New Hampshire", "New Jersey", "New Mexico", "New York", "North Carolina", 
				"North Dakota", "Ohio", "Oklahoma", "Oregon", "Pennsylvania", "Rhode Island", "South Carolina", 
				"South Dakota", "Tennessee", "Texas", "Utah", "Vermont", "Virginia", "Washington", "West Virginia", 
				"Wisconsin", "Wyoming", "Puerto Rico", "Virgin Islands" };
		
		Arrays.sort(states);
		
		return states;
	}

	public void setStates(String[] states) {
		this.states = states;
	}
	
	
}
