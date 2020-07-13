package jbr.springmvc.service;

import java.util.List;

import jbr.springmvc.model.Student;

public interface StudentService {

	List<Student> ShowList();
	void deleteStudent(int id);
	void studentInsert(Student std);
	Student profileDetails(String user);
	void studentUpdate(Student stdDetails);
	Student admStdDetails(int id);
	void adminStudentUpdate(Student stdDetails);
	void admstdDelete(int id);
}
