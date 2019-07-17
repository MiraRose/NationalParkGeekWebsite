package com.techelevator.npgeek.model.dao;

import java.util.List;

public interface WeatherDAO {

	public List<Weather> getAllWeatherByParkCode(String parkCode);
}
