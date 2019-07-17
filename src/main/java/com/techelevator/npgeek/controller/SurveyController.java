package com.techelevator.npgeek.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.npgeek.model.dao.Park;
import com.techelevator.npgeek.model.dao.ParkDAO;
import com.techelevator.npgeek.model.dao.States;
import com.techelevator.npgeek.model.dao.Survey;
import com.techelevator.npgeek.model.dao.SurveyDAO;
import com.techelevator.npgeek.model.dao.SurveyResult;

@Controller


public class SurveyController {
	
	@Autowired
	private SurveyDAO surveyDAO;
	
	@Autowired
	private ParkDAO parkDAO;

	@RequestMapping("/survey")
	public String displaySurveyPage(@Valid @ModelAttribute("survey") Survey survey,
	        BindingResult result, ModelMap map) {
		
		addParksAndStatesForForm(map);
		
		return "survey";
	}
	
	@RequestMapping(path="/survey", method = RequestMethod.POST)
	public String takeSurvey(@Valid @ModelAttribute("survey") Survey survey,
	        BindingResult result, ModelMap map, RedirectAttributes attr) {
		
		if(result.hasErrors()) {
			addParksAndStatesForForm(map);
            return "survey";
       }
		
		Park selectedPark = parkDAO.getParkByCode(survey.getParkCode());
		
		String selectedParkName = selectedPark.getParkName();
		
		surveyDAO.saveSurvey(survey);
		
		attr.addFlashAttribute("survey", selectedParkName);
		
		return "redirect:/results";
	}
	
	@RequestMapping("/results")
	public String displaySurveyResults(ModelMap map) {
		
		List<SurveyResult> results = surveyDAO.getResultsByParkCount();
		map.addAttribute("results", results);
		
		return "surveyResults";
	}
	
	private void addParksAndStatesForForm(ModelMap map) {
		
		List<Park> parks = parkDAO.getAllParks();
		map.addAttribute("parks", parks);
		String[] states = new States().getStates();
		map.addAttribute("states", states);
		
	}
}
