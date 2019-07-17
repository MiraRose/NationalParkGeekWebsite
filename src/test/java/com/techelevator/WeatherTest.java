package com.techelevator;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.techelevator.npgeek.model.dao.Weather;




public class WeatherTest {
	
	private Weather weather;

	@Before
	public void setup() {
		weather = new Weather();
	}
	
	@Test
	public void forecast_suggestion_return_all_proper_suggestions() {
		
		
		weather = makeWeather();
		
		List<String> actuals = weather.getSuggestions();
		
		List<String> expecteds = new ArrayList<String>();
		expecteds.add("Pack some snowhoes!");
		
		Assert.assertEquals("Just snow", expecteds.size(), actuals.size());
		
		weather.setLowTemp(19);
		List<String> actuals2 = weather.getSuggestions();
		
		expecteds.add("Warning exposure to low temperatures can cause frostbite");
		Assert.assertEquals("Snow and low temp", expecteds.size(), actuals2.size());
		
		weather.setHighTemp(70);
		List<String> actuals3 = weather.getSuggestions();
		
		expecteds.add("Warning exposure to low temperatures can cause frostbite");
		Assert.assertEquals("Snow, low and difference", expecteds.size(), actuals3.size());
		
	}
	
	@Test
	public void given_F_returns_correct_C() {
		
		weather = makeWeather();
		
		Assert.assertEquals(-1.11, weather.getHighTempC(), 2);
	}
	
	private Weather makeWeather() {
		
		weather.setForecast("snow");
		weather.setDay(1);
		weather.setHighTemp(30);
		weather.setLowTemp(21);
		weather.setParkCode("TEST");
		
		return weather;
		
	}
	
}
