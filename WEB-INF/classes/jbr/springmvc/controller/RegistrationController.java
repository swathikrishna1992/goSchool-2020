package jbr.springmvc.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class RegistrationController {
  @Autowired
  public UserService userService;

  @RequestMapping(value = "/register", method = RequestMethod.GET)
  public ModelAndView showRegister(HttpServletRequest request, HttpServletResponse response) {
    ModelAndView mav = new ModelAndView("register");
    mav.addObject("user", new User());

    return mav;
  }

  @RequestMapping(value = "/addUser", method = RequestMethod.POST)
  public String addUser(@Valid @ModelAttribute("user") User user,BindingResult result,HttpServletRequest request, HttpServletResponse response) {
	  
	  if (result.hasErrors()) {
		  return "register";
		
	}
	  
	  try {
		  userService.register(user);
		  return "login";
	  }
	  catch(Exception e){
		  return "register";
    
	  }
  }
  

  @RequestMapping(value="/check_username",method = RequestMethod.GET)
	@ResponseBody
	public String checkAvailability(@RequestParam String username)
	{
		if(userService.isUsernameExist(username))
			return "";
		else if(username == "")
			return "Username Cannot blank";
		else
			return "Username is invalid";
	}

}
