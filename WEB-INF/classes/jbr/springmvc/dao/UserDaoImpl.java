package jbr.springmvc.dao;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;
import jbr.springmvc.model.UserRole;

@Repository
public class UserDaoImpl implements UserDao {

  @Autowired
  JdbcTemplate jdbcTemplate;

  public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
	this.jdbcTemplate = jdbcTemplate;
}




public int register(User user) {
	  
    String sql = "insert into registration (username,emailid,password,userrole) values (?,?,aes_encrypt(?,'mypassword'),?)";
    
    return jdbcTemplate.update(sql, new Object[] {user.getUsername(), user.getEmailId(),user.getPassword(),user.getUserRole()});
    
  }
  
  


@Override
public User validateUser(Login login) {
	String sql = "select * from registration where username=? and aes_decrypt(password,'mypassword')=?";
	
//@SuppressWarnings("unused")
User  users =  jdbcTemplate.queryForObject(sql, new Object[] {login.getUsername(),login.getPassword()}, new RowMapper<User>(){

	
	@Override
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		
			System.out.println("Inside Dao");
			User user=new User();
		 
		    user.setUsername(rs.getString("username"));
		    user.setPassword(rs.getString("password"));
		      
		    user.setEmailId(rs.getString("emailid"));
		    user.setUserRole(rs.getString("userrole"));
		    
		    System.out.println(user.toString());
		    return user;
		    
	} 		
});

return users;

}
}



