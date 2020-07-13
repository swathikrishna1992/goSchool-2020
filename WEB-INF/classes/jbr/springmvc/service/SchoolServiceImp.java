package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springmvc.dao.SchoolDao;
import jbr.springmvc.model.School;
@Service
public class SchoolServiceImp implements SchoolService {

	@Autowired
	SchoolDao schooldao;
	
	@Override
	public void insertdetails(School school) {
		
		schooldao.insertdetails(school);
	}
	
	@Override
	public School profileDetails(String user) {
		
		School std= schooldao.updateProfile(user);
		return std;
	}

	

	@Override
	public School schoolUpdate(School school) {
		 School std = schooldao.schoolupdate(school);
		return std;
	}

	@Override
	public List<School> schoollist() {
		List<School> slist = schooldao.showschools();
		return slist;
	}

	@Override
	public void admschoolDelete(int id) {
		schooldao.admSchooldelete(id);	
	}

}
