package jbr.springmvc.service;

import org.springframework.stereotype.Service;

import jbr.springmvc.model.Login;
import jbr.springmvc.model.User;

@Service
public interface UserService {

 public int register(User user);

 public User validateUser(Login login);

public boolean isUsernameExist(String username);



public boolean isEmailExist(String emailId);

}
