package jbr.springmvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jbr.springmvc.model.School;
import jbr.springmvc.model.Student;
import jbr.springmvc.model.User;
import jbr.springmvc.service.SchoolService;

@Controller
public class schoolController {

	@Autowired
	SchoolService schoolservice;
	
     public void setschoolController(SchoolService schoolservice)
     {
    	 this.schoolservice=schoolservice;

     }
	
     @RequestMapping(value="/insertinfo",method = RequestMethod.GET)
     ModelAndView insertdetails(School school,HttpSession session,HttpServletRequest request)
     {
  		ModelAndView mav = new ModelAndView();

    	 if(request.getSession().getAttribute("Username")!=null) {
    		 String abc=request.getSession().getAttribute("Username").toString();
    		 System.out.println("Username"+abc);
    		 System.out.println("Inside insertdetails");
 		
 		
 		//stdservice.studentInsert(std);
 		
 		mav.setViewName("schoolinfo");
    	 }
 		return mav;
    	 
     }
     
     
     @RequestMapping(value="/insertdetails",method = RequestMethod.POST)
 	public String insertschoolinfo(@Valid@ModelAttribute("school")School school,BindingResult result,HttpSession session){
 		if(result.hasErrors())
 		{
 			return "schoolinfo";
 		}
    	
 		
    		 schoolservice.insertdetails(school);
 		
    	 
 		return "schooldash";
    	
     }   
     

   	@RequestMapping(value="/edtschoolprofile",method = RequestMethod.GET)
  	public ModelAndView schoolEdit(HttpSession session ,Model m) {
  		
  		ModelAndView mav= new ModelAndView();
  		String user =  (String) session.getAttribute("Username");
  		try {
  		School slist= schoolservice.profileDetails(user);
  		m.addAttribute("temp",slist);
  		mav.setViewName("EditSchool");
  		}catch(Exception e)
 		{
 			mav.setViewName("FirstAddDetails");
 			return mav;
 		}
  		return mav;
  		
  	}

   	@RequestMapping(value="schooledit",method = RequestMethod.GET)
 	public ModelAndView schoolEdit1(@ModelAttribute("schoolDetails")School schoolDetails,HttpSession session ,Model m) {
 		
 		ModelAndView mav= new ModelAndView();
 		String user =  (String) session.getAttribute("Username");
 		
 		School slist= schoolservice.profileDetails(user);
 		m.addAttribute("std",slist);
 		mav.setViewName("schoolEdit");
 		
 		return mav;
 	}
   	
   	
   	@RequestMapping(value ="/schoolupdate",method =RequestMethod.POST)
  	public ModelAndView addschoolDetails(@ModelAttribute("school")School school) {
   		
  		schoolservice.schoolUpdate(school);
  		ModelAndView mav = new ModelAndView();
 		 mav.setViewName("schooldash"); 
  		return mav;
  	}
  	
    //school List
    
    @RequestMapping("/schoolList")
    public ModelAndView showlist() {
		
		List<School> stdList = schoolservice.schoollist();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sList",stdList);
		mav.setViewName("school_list");
		return mav;
	}

 //Admin school List
    
    @RequestMapping("/admSchoolList")
    public ModelAndView adminShowlist() {
		
		List<School> stdList = schoolservice.schoollist();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sList",stdList);
		mav.setViewName("adm_school_list");
		return mav;
	}
     
     //admin schoool delete
    @RequestMapping(value="/admSchoolDelete/{id}",method=RequestMethod.GET)
	public String admstdDelete(@PathVariable int id,Model m) {
		//System.out.println("ABCD");
		Student std=new Student();
		System.out.println("id is"+id);
		ModelAndView mav= new ModelAndView();
		schoolservice.admschoolDelete(id);
		return "redirect:/admSchoolList";
		
	}
     
}
