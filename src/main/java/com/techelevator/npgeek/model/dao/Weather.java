package com.techelevator.npgeek.model.dao;

import java.util.ArrayList;
import java.util.List;

public class Weather {

	private String parkCode;
	private int day;
	private int lowTemp;
	private int highTemp;
	private double lowTempC;
	private double highTempC;
	private String forecast;
	private List<String> suggestions;
	
	public String getParkCode() {
		return parkCode;
	}
	public void setParkCode(String parkCode) {
		this.parkCode = parkCode;
	}
	public int getDay() {
		return day;
	}
	public void setDay(int day) {
		this.day = day;
	}
	public int getLowTemp() {
		return lowTemp;
	}
	public void setLowTemp(int lowTemp) {
		this.lowTemp = lowTemp;
	}
	public int getHighTemp() {
		return highTemp;
	}
	public void setHighTemp(int highTemp) {
		this.highTemp = highTemp;
	}
	public String getForecast() {
		return forecast;
	}
	public void setForecast(String forecast) {
		this.forecast = forecast;
	}
	public List<String> getSuggestions() {
		
		List<String> suggestions = new ArrayList<String>();
		if (forecast.equals("snow")) {
			suggestions.add("Pack some snowshoes!");
		}
		if (forecast.equals("rain")) {
			suggestions.add("Pack rain gear and wear waterproof shoes!");
		}
		if (forecast.equals("thunderstorms")) {
			suggestions.add("Seek shelter and avoid hiking on exposed ridges!");
		}
		if (forecast.equals("sunny")) {
			suggestions.add("Pack sunblock!");
		}
		if (lowTemp < 20) {
			suggestions.add("Warning exposure to low temperatures can cause frostbite");
		}
		if (highTemp > 75) {
			suggestions.add("Bring an extra gallon of water!");
		}
		if (highTemp - lowTemp > 20) {
			suggestions.add("Wear breathable layers!");
		}
		return suggestions;
	}
	
	private double getConvertedTemperature(int tempInF) {

		double temp = (double) tempInF;
		
		temp = (temp - 32) / 1.8;
		return temp;
	}
	
	public double getLowTempC() {
		lowTempC = getConvertedTemperature(lowTemp);
		return lowTempC;
	}
	
//	public void setLowTempC(int lowTempC) {
//		this.lowTempC = lowTempC;
//	}
	
	public double getHighTempC() {
		highTempC = getConvertedTemperature(highTemp);
		return highTempC;
	}
	
//	public void setHighTempC(int highTempC) {
//		this.highTempC = highTempC;
//	}
	
}
