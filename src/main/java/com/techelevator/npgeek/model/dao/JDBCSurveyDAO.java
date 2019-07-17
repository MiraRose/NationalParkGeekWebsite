package com.techelevator.npgeek.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCSurveyDAO implements SurveyDAO {

	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCSurveyDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void saveSurvey(Survey survey) {
		String sql = "INSERT INTO survey_result (surveyid, parkcode, emailaddress, state, activitylevel) VALUES (DEFAULT, ?, ?, ?, ?);";
		jdbcTemplate.update(sql, survey.getParkCode(), survey.getEmail(), survey.getState(), survey.getActivityLevel());
		
	}

	@Override
	public List<SurveyResult> getResultsByParkCount() {
		
		List<SurveyResult> parkCodeWithCount = new ArrayList<SurveyResult>();
		
		String sql = "SELECT survey_result.parkcode, parkname, COUNT(survey_result.parkcode) AS count FROM survey_result JOIN park ON survey_result.parkcode = park.parkcode\n" + 
				" GROUP BY survey_result.parkcode, parkname ORDER BY count DESC, parkname;";
		SqlRowSet result = jdbcTemplate.queryForRowSet(sql);
		
		while (result.next()) {
			parkCodeWithCount.add(mapToSurveyResult(result));
		}
		
		return parkCodeWithCount;
	}
	
	private SurveyResult mapToSurveyResult(SqlRowSet result) {
		
		SurveyResult surveyResult = new SurveyResult();
		
		surveyResult.setParkCode(result.getString("parkcode"));
		surveyResult.setSurveyCount(result.getInt("count"));
		surveyResult.setParkName(result.getString("parkname"));
		
		return surveyResult;
	}

}
