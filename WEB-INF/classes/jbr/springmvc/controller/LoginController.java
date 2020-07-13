package jbr.springmvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.service.UserService;

@Controller
public class LoginController {

  @Autowired
  UserService userService;
  

  public void setUserService(UserService userService) {
	this.userService = userService;
}


@RequestMapping(value = "/login", method = RequestMethod.GET)
  public ModelAndView showLogin(HttpServletRequest request, HttpServletResponse response) {

	 ModelAndView mav = new ModelAndView("login");
	 
	try {
    	
    	System.out.println(request.getSession().getAttribute("userRole"));
    	if(request.getSession().getAttribute("userRole")!=null){
    	if(request.getSession().getAttribute("userRole").toString().equals("admin")) {
    		
    		mav.setViewName("admindash");
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("student")) {
    		mav.setViewName("studentdash");
    		
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("school")) {
    		mav.setViewName("schooldash");
    	}
    	
    	}
		}
    catch(Exception e)
    {
    	System.out.println("inside catch");
    	return mav;
    }
   
    mav.addObject("user", new User());

    return mav;
  }


@RequestMapping(value = "/logout", method = RequestMethod.GET)
  public ModelAndView logout(HttpServletRequest request,HttpServletResponse response) {
	
	ModelAndView mav ;
	request.getSession().invalidate(); 
	LoginController obj = new LoginController();
	mav=obj.showLogin(request,response);
	return mav;
    
  }



  @RequestMapping(value = "/loginProcess", method = RequestMethod.POST)
  public String loginProcess(@Valid @ModelAttribute("user") Login login,BindingResult result, HttpServletRequest request, HttpServletResponse response,HttpSession session) {
	  
	  if(result.hasErrors())
	  {
		  return "login";
	  }
	
   try { 	
    	User u = userService.validateUser(login);
    	System.out.println(u.getUsername()+"  "+u.getUserRole());
    	String role = u.getUserRole().toString();
    	System.out.println(u.getUserRole());
    	request.getSession().setAttribute("Username",u.getUsername());
    	  request.getSession().setAttribute("userRole",u.getUserRole());
    	if(request.getSession().getAttribute("userRole").toString().equals("admin")) {
    		return "admindash";
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("student")) {
    		
    		return "studentdash";
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("school")) {
    		
    		return "schooldash";
    	}
    	else return "login";
    	
    	
    }
    catch(Exception e)
    {
    	System.out.println("inside catch");
    	return "login";
    }
  }
  
  @RequestMapping(value = "/loginProcess", method = RequestMethod.GET)
  public String loginProcess1(HttpServletRequest request, HttpServletResponse response,HttpSession session) {

    try {
    	
    	System.out.println(request.getSession().getAttribute("userRole"));
    	if(request.getSession().getAttribute("userRole")!=null){
    	if(request.getSession().getAttribute("userRole").toString().equals("admin")) {
    		
    		return "admindash";
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("student")) {
    		
    		return "studentdash";
    	}
    	else if(request.getSession().getAttribute("userRole").toString().equals("school")) {
    		
    		return "schooldash";
    	}
    	else return "login";
    	}else {
    		return "login";
    	}
    	
    	
    }
    catch(Exception e)
    {
    	System.out.println("inside catch");
    	return "login";
    }
  }
}

