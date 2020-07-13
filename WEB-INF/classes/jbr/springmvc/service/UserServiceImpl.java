package jbr.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import jbr.springmvc.dao.UserDao;
import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

@Service
public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;
  

  public void setUserDao(UserDao userDao) {
	this.userDao = userDao;
}
  
  @Autowired
  JdbcTemplate jdbc;

public void setJdbc(JdbcTemplate jdbc) {
	this.jdbc = jdbc;
}

public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

  
@Override
public boolean isUsernameExist(String username) {
	String sql = "select count(Username) from registration where Username = ?";
	Integer count = jdbc.queryForObject(sql,new Object[] {username}, Integer.class);
	if(count == 1)
		return true;
	else
		return false;
}


@Override
public boolean isEmailExist(String emailId) {
	String sql = "select count(emailId) from registration where emailId = ?";
	Integer count = jdbc.queryForObject(sql,new Object[] {emailId}, Integer.class);
	if(count >= 1)
		return true;
	else
		return false;
}





}
