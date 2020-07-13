package jbr.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import jbr.springmvc.model.School;
import jbr.springmvc.model.Student;

@Repository
public class Schooldaoimp implements SchoolDao {

	@Autowired
	public JdbcTemplate jt;
	
	 public void setJt(JdbcTemplate jt) {
		this.jt = jt;
	}
	
	
	 @Override
		public void insertdetails(School school) {
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = sra.getRequest().getSession();
			String Username = session.getAttribute("Username").toString();
			
			
			boolean flag=true;
			String sql="insert into schoolinformation(schooltype,schoolname,schooladdress,board,username,flag) values(?,?,?,?,?,?)";
			jt.update(sql,new Object[]{school.getMedium(),school.getName(),school.getAddress(),school.getBoard(),Username,flag});
			
			
		}
	 
	 


		@Override
		public List<School> showschools() {
			String sql = "select * from schoolinformation where flag=true";
			List<School> slist = jt.query(sql,new RowMapper<School>() {

				@Override
				public School mapRow(ResultSet rs, int rowNum) throws SQLException {
					School std = new School();
					
					std.setMedium(rs.getString("schoolType"));
					std.setName(rs.getString("schoolName"));
					std.setAddress(rs.getString("schoolAddress"));
					std.setBoard(rs.getString("Board"));
					return std;
		 
		}

			});
		  return slist;	  
		}


		@Override
		public School updateProfile(String user) {
			
			String sql= "select * from schoolinformation where Username=?";
			return  jt.queryForObject(sql, new Object[]{user},new RowMapper<School>() {

				@Override
				public School mapRow(ResultSet rs, int rowNum) throws SQLException {
					//System.out.println("Inside Dao");
					School std = new School();
					
					std.setMedium(rs.getString("schoolType"));
					std.setName(rs.getString("schoolName"));
					std.setAddress(rs.getString("schoolAddress"));
					std.setBoard(rs.getString("Board"));
					return std;
				}
				
			});
		
		}


		@Override
		public School schoolupdate(School school) {
			ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
			HttpSession session = sra.getRequest().getSession();
			String uname = session.getAttribute("Username").toString();
			String sql= "update schoolinformation set schoolName=?,schoolAddress=?,Board=? where Username='"+uname+"'";
			School std = new School();
			int i=jt.update(sql,new Object[]{school.getName(),school.getAddress(),school.getBoard()});
			System.out.println("updated row:="+i);
			
			return null;
		}

		//admin school delete
		
				@Override
				public void admSchooldelete(int id) {
						
						String sql= "update schoolinformation set flag=false where schoolId=?";
						School std = new School();
						int i=jt.update(sql,new Object[]{id});
					}
					
	

}
