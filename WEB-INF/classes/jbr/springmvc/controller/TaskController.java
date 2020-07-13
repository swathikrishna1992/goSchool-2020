package jbr.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class TaskController {
	
	@RequestMapping(value ="/home", method = RequestMethod.GET)
	public String home(ModelMap model) {
		return "home";
	}	
	
	@RequestMapping(value ="/aboutus", method = RequestMethod.GET)
	public String aboutus(ModelMap model) {
		return "aboutus";
	}

	@RequestMapping(value ="/contactus", method = RequestMethod.GET)
	public String contact(ModelMap model) {
		return "contactus";
	}
	
	@RequestMapping(value ="/contactus", method = RequestMethod.POST)
	public String contactUs(ModelMap model) {
		return "contactus";
	}

	

}
