package jbr.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jbr.springmvc.dao.Slistdao;
import jbr.springmvc.model.Student;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	Slistdao slist;
	
	@Override
	public List<Student> ShowList() {
		
		List<Student> StdList = slist.studentList();
		return StdList;
	}

	
		
		
	@Override
	public void deleteStudent(int id) {
		slist.studentDelete(id);
		
	}





	@Override
	public void studentInsert(Student std) {
		slist.studentInsert(std);
		
	}

	@Override
	public Student profileDetails(String user) {
		Student list = slist.profDetails(user);
		return list;
	}
	@Override
	public void studentUpdate(Student stdDetails) {
		// TODO Auto-generated method stub
		slist.stdUpdate(stdDetails);
	}
	@Override
	public Student admStdDetails(int id) {
		Student std = slist.admstdDetails(id);
		return std;
	}
	
	@Override
	public void adminStudentUpdate(Student stdDetails) {
		slist.admStudentUpdate(stdDetails);
		
	}
	@Override
	public void admstdDelete(int id) {
		
		slist.admstdDelete(id);
	}
	



	
}
