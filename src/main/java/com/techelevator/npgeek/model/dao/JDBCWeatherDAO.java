package com.techelevator.npgeek.model.dao;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCWeatherDAO implements WeatherDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCWeatherDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public List<Weather> getAllWeatherByParkCode(String parkCode) {
		List<Weather> weatherList = new ArrayList<Weather>();
		
		String sql = "SELECT parkcode, fivedayforecastvalue, low, high, forecast FROM weather WHERE parkcode = ? ORDER BY fivedayforecastvalue;";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sql, parkCode);
		
		while (results.next()) {
			weatherList.add(mapRowToWeather(results));
		}
		
		return weatherList;
	}

	private Weather mapRowToWeather(SqlRowSet results) {
		Weather weather = new Weather();
		
		weather.setParkCode(results.getString("parkcode"));
		weather.setDay(results.getInt("fivedayforecastvalue"));
		weather.setLowTemp(results.getInt("low"));
		weather.setHighTemp(results.getInt("high"));
		weather.setForecast(results.getString("forecast"));
		
		return weather;
	}
}
