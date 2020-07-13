package jbr.springmvc.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import jbr.springmvc.model.School;
import jbr.springmvc.model.Student;


public interface SchoolDao {

	void insertdetails(School school);
	List<School> showschools();
	School updateProfile(String user);
	School schoolupdate(School school);
	void admSchooldelete(int id);
}
