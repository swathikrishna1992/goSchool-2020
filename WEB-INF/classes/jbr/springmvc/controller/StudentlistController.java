
//bhushan

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

import jbr.springmvc.model.Student;
import jbr.springmvc.model.User;
import jbr.springmvc.model.UserRole;
import jbr.springmvc.service.StudentService;

@Controller
public class StudentlistController {

	@Autowired
	StudentService stdservice;
	public void setStdservice(StudentService stdservice) {
		this.stdservice = stdservice;
	}
	
	@RequestMapping("/showlist")
    public ModelAndView showlist() {
		
		List<Student> stdList = stdservice.ShowList();
		ModelAndView mav = new ModelAndView();
		mav.addObject("sList",stdList);
		mav.setViewName("std_list");
		return mav;
	}
	
	@RequestMapping(value="/addStdDetails",method = RequestMethod.POST)
	public String studentInsert(@Valid@ModelAttribute("std")Student std,BindingResult result){
		if(result.hasErrors()) {
			return "StudentDetails";
		}
		
		stdservice.studentInsert(std);
		
		return "studentdash";
		}
	
	@RequestMapping(value="/insert",method = RequestMethod.GET)
	public  ModelAndView studentInsert1(@ModelAttribute("std")Student std,HttpSession session,HttpServletRequest request){

		ModelAndView mav = new ModelAndView();

		
		if(request.getSession().getAttribute("userRole")!=null) {
			System.out.println("Inside student list controller");
		mav.setViewName("insert");
		}
		return mav;
}
		
	
	
	//insert method
	
		@RequestMapping(value ="/StdDetails",method =RequestMethod.GET)
	 	public ModelAndView StdDetails() {
	 		
	 		ModelAndView mav = new ModelAndView();
	 		 mav.setViewName("StudentDetails");
	 		  
	 		return mav;
	 				
	 	}
		
	 				
	 
	     
	 	
	 	
	 	
	 	//Edit std profile
	 	
	 	
	 	@RequestMapping(value="/profiledetails",method = RequestMethod.GET)
		public ModelAndView studentEdit(HttpSession session ,Model m) {
			
			ModelAndView mav= new ModelAndView();
			String user =  (String) session.getAttribute("Username");
			try {
			Student slist= stdservice.profileDetails(user);
			m.addAttribute("std",slist);
			mav.setViewName("EditStudent");
			}catch(Exception e) {
				mav.setViewName("StudentDetails");
				return mav;
			}
	 	
			return mav;
			
		}
	 	
		@RequestMapping(value="edit",method = RequestMethod.GET)
		public ModelAndView studentEdit1(@ModelAttribute("stdDetails")Student stdDetails,HttpSession session ,Model m) {
			
			ModelAndView mav= new ModelAndView();
			String user =  (String) session.getAttribute("Username");
			Student slist= stdservice.profileDetails(user);
			m.addAttribute("std",slist);
			mav.setViewName("stdEdit");
			return mav;
			
	 
		}
	 	
		@RequestMapping(value ="/stdupdate",method =RequestMethod.POST)
	 	public ModelAndView addStdDetails(@ModelAttribute("stdDetails")Student stdDetails) {
	 		
	 		
	 		stdservice.studentUpdate(stdDetails);
	 		ModelAndView mav = new ModelAndView();
			 mav.setViewName("studentdash");
	 		 
	 		return mav;
	 		
	 		
	 	}
	 	
		//Admin STUDENT LIST
		
		@RequestMapping("/adminstdlist")
	    public ModelAndView studentlist() {
			
			List<Student> stdList = stdservice.ShowList();
			ModelAndView mav = new ModelAndView();
			mav.addObject("sList",stdList);
			mav.setViewName("adminstdlist");
			return mav;
		}
			
		//Admin std Edit
		
		@RequestMapping(value="/adminStdEdit/{id}",method = RequestMethod.GET)
		public ModelAndView adminStdEdit(@PathVariable int id,Model m) {
			
			ModelAndView mav= new ModelAndView();
			Student slist= stdservice.admStdDetails(id);
			m.addAttribute("std",slist);
			
			//stdservice.studentUpdate(stdDetails);
		
			mav.setViewName("adminstdEdit");
			return mav;
			
	 
		}
		
		 
		@RequestMapping(value ="/adminstd",method=RequestMethod.POST)
	 	public ModelAndView adminStdAddDetails(@ModelAttribute("stdDetails")Student stdDetails) {
	 		System.out.println("admibnjhgsc");
	 		
	 		stdservice.adminStudentUpdate(stdDetails);
	 		ModelAndView mav = new ModelAndView();
			 mav.setViewName("admindash");	 
	 		return mav;
	 	
	 	}
		

	
	
	//Admin Std Delete....
	
		@RequestMapping(value="/admDelete/{id}",method=RequestMethod.GET)
		public String admstdDelete(@PathVariable int id,Model m) {
			//System.out.println("ABCD");
			Student std=new Student();
			System.out.println("id is"+id);
			ModelAndView mav= new ModelAndView();
			stdservice.admstdDelete(id);
			return "redirect:/adminstdlist";
			
		}	
	
		//Admin dash 
		
			@RequestMapping(value="/admindash")
			public ModelAndView admindash()
			{
				ModelAndView mav = new ModelAndView();
				mav.setViewName("admindash");
				return mav;
			}
}
