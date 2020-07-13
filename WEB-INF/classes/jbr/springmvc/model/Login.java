package jbr.springmvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class Login {
	

	@Size(min = 3,max = 10)
	@NotEmpty(message = "User Name should not be empty")
  private String Username;
	@NotEmpty(message = "Password should not be empty")
  private String Password;
  
  

public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	this.Password = password;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}

  

}
