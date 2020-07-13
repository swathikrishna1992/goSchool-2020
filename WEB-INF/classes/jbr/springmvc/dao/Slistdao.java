package jbr.springmvc.dao;



import java.util.List;


import jbr.springmvc.model.Student;


public interface Slistdao {

   public List<Student> studentList(); 
   public void studentDelete(int id);
   public void studentInsert(Student std);
   public Student profDetails(String user);
   public void stdUpdate(Student stdDetails);
   public Student admstdDetails(int id);
   public void admStudentUpdate(Student stdDetails);
   
   public void admstdDelete(int id);
}
