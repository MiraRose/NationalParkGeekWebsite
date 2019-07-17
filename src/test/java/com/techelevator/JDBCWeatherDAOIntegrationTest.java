package com.techelevator;


import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import com.techelevator.npgeek.model.dao.JDBCWeatherDAO;
import com.techelevator.npgeek.model.dao.Weather;
import com.techelevator.npgeek.model.dao.WeatherDAO;


public class JDBCWeatherDAOIntegrationTest extends DAOIntegrationTest{
	
	
	private WeatherDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	
	@Before
	public void setup() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCWeatherDAO(dataSource);
		
	}

	@Test
	public void get_weather_by_parkcode_returns_weather() {
		
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + 
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES ('CODE', 'TEST', 'TEST', 10, 10, 10.0, 10, 'TEST', 1999, 10, 'TEST', 'TEST', 'TEST', 10, 10);";
		jdbcTemplate.update(sql);
		
		List<Weather> weatherList = dao.getAllWeatherByParkCode("CODE");
		
		int parkListOriginalSize = weatherList.size();
		
		String sql2 = "INSERT INTO weather (parkcode, fivedayforecastvalue, low, high, forecast) \n" + 
		"VALUES ('CODE', 1, 10, 30, 'snow');";
		jdbcTemplate.update(sql2);
		
		List<Weather> weatherListTwo = dao.getAllWeatherByParkCode("CODE");
		int parkListNewSize = weatherListTwo.size();
		
		Assert.assertEquals(parkListOriginalSize + 1, parkListNewSize);
	}
	
	
	
	
}
