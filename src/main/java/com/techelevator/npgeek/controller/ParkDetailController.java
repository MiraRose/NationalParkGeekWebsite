package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.techelevator.npgeek.model.dao.Park;
import com.techelevator.npgeek.model.dao.ParkDAO;
import com.techelevator.npgeek.model.dao.Weather;
import com.techelevator.npgeek.model.dao.WeatherDAO;

@Controller
@SessionAttributes({"temp", "park", "weathers"})

public class ParkDetailController {

	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	@RequestMapping("/details")
	public String displayDetails(@RequestParam String parkCode, ModelMap map) {
		
		Park park = parkDAO.getParkByCode(parkCode);
		List<Weather> weatherList = weatherDAO.getAllWeatherByParkCode(parkCode);
		
		
		map.addAttribute("park", park);
		map.addAttribute("weathers", weatherList);
		
		if (!map.containsAttribute("temp")) {
			map.addAttribute("temp", "f");
		}
		
		
		return "details";
	}
	
	@RequestMapping(path="/details", method = RequestMethod.POST)
	public String changeTemp(@RequestParam String temp, ModelMap map) {
		
		map.addAttribute("temp", temp);
	
		return "details";
	}
	
	
}
