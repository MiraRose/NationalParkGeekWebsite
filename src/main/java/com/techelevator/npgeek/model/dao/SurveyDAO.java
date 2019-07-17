package com.techelevator.npgeek.model.dao;

import java.util.List;
import java.util.Map;

public interface SurveyDAO {

	public void saveSurvey(Survey survey);
	public List<SurveyResult> getResultsByParkCount();
	
}
