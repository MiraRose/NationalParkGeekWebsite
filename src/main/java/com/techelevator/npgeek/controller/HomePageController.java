package com.techelevator.npgeek.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techelevator.npgeek.model.dao.Park;
import com.techelevator.npgeek.model.dao.ParkDAO;


@Controller
public class HomePageController {

	@Autowired
	private ParkDAO parkDAO;
	
	@RequestMapping("/")
	public String displayHomePage(ModelMap map) {
		
		List<Park> parks = parkDAO.getAllParks();
		map.addAttribute("parks", parks);
		
		return "homePage";
	}
	
}
