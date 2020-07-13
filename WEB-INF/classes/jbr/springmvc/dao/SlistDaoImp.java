package jbr.springmvc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jbr.springmvc.model.Student;

@Repository
public class SlistDaoImp implements Slistdao {

	@Autowired
	public JdbcTemplate jt;
	
	 public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	 
	 
	@Override
	public List<Student> studentList() {
		String sql = "select * from studentInformation where flag=true";
		List<Student> slist = jt.query(sql,new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student std = new Student();
				std.setId(rs.getInt("studentId"));
				std.setFirst_name(rs.getString("firstName"));
				std.setMiddle_name(rs.getString("middleName"));
				std.setLast_name(rs.getString("LastName"));
				std.setAddress(rs.getString("Address"));
				std.setDob(rs.getString("DOB"));
				std.setGender(rs.getString("gender"));
				return std;
	
			}
			
			
			
		});
		return slist;
	}

	@Override
	public void studentInsert(Student std) {
		
		boolean flag =true;
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = sra.getRequest().getSession();
		String uname = session.getAttribute("Username").toString();
		String sql="insert into studentInformation(firstName,middleName,LastName,Address,DOB,gender,Username,flag) values(?,?,?,?,?,?,?,?)";
		jt.update(sql,new Object[]{std.getFirst_name(),std.getMiddle_name(),std.getLast_name(),std.getAddress(),std.getDob(),std.getGender(),uname,flag});
		
		
	}


	@Override
	public void studentDelete(int id) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public Student profDetails(String user) {
		String sql= "select * from studentInformation where Username=?";
		return  jt.queryForObject(sql, new Object[]{user},new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				System.out.println("Inside Dao");
				Student std = new Student();
				
				std.setFirst_name(rs.getString("firstName"));
				std.setMiddle_name(rs.getString("middleName"));
				std.setLast_name(rs.getString("LastName"));
				std.setAddress(rs.getString("Address"));
				std.setDob(rs.getString("DOB"));
				std.setGender(rs.getString("gender"));
				return std;
			}
			
		});
		
	}


	@Override
	public void stdUpdate(Student stdDetails) {
		ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpSession session = sra.getRequest().getSession();
		String uname = session.getAttribute("Username").toString();
		String sql= "update studentInformation set firstName=?,middleName=?,LastName=?,Address=?,DOB=?,gender=? where Username='"+uname+"'";
		Student std = new Student();
		int i=jt.update(sql,new Object[]{stdDetails.getFirst_name(),stdDetails.getMiddle_name(),stdDetails.getLast_name(),stdDetails.getAddress(),stdDetails.getDob(),stdDetails.getGender()});
		System.out.println("updated row:="+i);
		
	
}


	@Override
	public Student admstdDetails(int id) {
		String sql= "select * from studentInformation where studentId=?";
		return  jt.queryForObject(sql, new Object[]{id},new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student std = new Student();			
				std.setFirst_name(rs.getString("firstName"));
				std.setMiddle_name(rs.getString("middleName"));
				std.setLast_name(rs.getString("LastName"));
				std.setAddress(rs.getString("Address"));
				std.setDob(rs.getString("DOB"));
				std.setGender(rs.getString("gender"));
				return std;
			}
			
		});
	}


	@Override
	public void admStudentUpdate(Student stdDetails) {
		
		
		String sql= "update studentInformation set firstName=?,middleName=?,LastName=?,Address=?,DOB=?,gender=? where studentId=?";
		Student std = new Student();
		
		int i=jt.update(sql,new Object[]{std.getFirst_name(),std.getMiddle_name(),std.getLast_name(),std.getAddress(),std.getDob(),std.getGender(),std.getId()});
		System.out.println("updated row:="+i);
		
	}

	
	//Student delete method for Admin..

	@Override
	public void admstdDelete(int id) {
		
		String sql= "update studentInformation set flag=false where studentId=?";
		Student std = new Student();
		int i=jt.update(sql,new Object[]{id});
		System.out.println("updated row:="+i);
		
		//jt.update(sql);
		
	}


	


}
