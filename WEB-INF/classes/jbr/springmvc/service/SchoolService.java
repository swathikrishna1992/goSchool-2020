package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.School;

public interface SchoolService {

	 void insertdetails(School school);
	 List<School> schoollist();
	 School profileDetails(String user); 
	 School schoolUpdate(School school);
	 void admschoolDelete(int id);
}
