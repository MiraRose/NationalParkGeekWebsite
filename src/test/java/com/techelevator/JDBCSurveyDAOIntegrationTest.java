package com.techelevator;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.techelevator.npgeek.model.dao.JDBCSurveyDAO;
import com.techelevator.npgeek.model.dao.JDBCWeatherDAO;
import com.techelevator.npgeek.model.dao.Survey;
import com.techelevator.npgeek.model.dao.SurveyDAO;
import com.techelevator.npgeek.model.dao.SurveyResult;
import com.techelevator.npgeek.model.dao.WeatherDAO;



public class JDBCSurveyDAOIntegrationTest extends DAOIntegrationTest{
	
	
	private SurveyDAO dao;
	private JdbcTemplate jdbcTemplate;
	
	
	@Before
	public void setup() {
		
		jdbcTemplate = new JdbcTemplate(dataSource);
		dao = new JDBCSurveyDAO(dataSource);
		
	}
	
	@Test
	public void save_survey_saves_survey() {
		
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + 
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES ('CODE', 'TEST', 'TEST', 10, 10, 10.0, 10, 'TEST', 1999, 10, 'TEST', 'TEST', 'TEST', 10, 10);";
		jdbcTemplate.update(sql);
		
		Survey survey = makeSurvey();
		
		dao.saveSurvey(survey);
		
		String sql2 = "SELECT * FROM survey_result WHERE parkcode = ?";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql2, "CODE");
		result.next();
		String actual = result.getString("parkcode");
		
		Assert.assertEquals("CODE", actual);
		
	}
	
	@Test
	public void get_survey_results_returns_results() {
		
		String sql = "INSERT INTO park (parkcode, parkname, state, acreage, elevationinfeet, milesoftrail, numberofcampsites, climate, yearfounded, " + 
				"annualvisitorcount, inspirationalquote, inspirationalquotesource, parkdescription, entryfee, numberofanimalspecies) " + 
				"VALUES ('CODE', 'TEST', 'TEST', 10, 10, 10.0, 10, 'TEST', 1999, 10, 'TEST', 'TEST', 'TEST', 10, 10);";
		jdbcTemplate.update(sql);
		
		List<SurveyResult> results = dao.getResultsByParkCount();
		
		Survey survey = makeSurvey();
		
		dao.saveSurvey(survey);
		
		List<SurveyResult> actual = dao.getResultsByParkCount();
		
		Assert.assertEquals(results.size() + 1, actual.size());
	}
	
	private Survey makeSurvey() {
		
		Survey survey = new Survey();
		survey.setParkCode("CODE");
		survey.setEmail("TEST");
		survey.setActivityLevel("inactive");
		survey.setState("Ohio");
		
		return survey;
	}

}
