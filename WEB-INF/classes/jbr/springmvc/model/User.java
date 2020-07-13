package jbr.springmvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;


public class User {
	
	@NotEmpty(message = "UserName should not be empty")
	@Size(min = 3,max = 10)
	private String Username;
	@NotEmpty(message = "EmailId should not be empty")
	@Email
	private String emailId;
	@NotEmpty(message = "Password should not be empty")
	@Size(min = 4,max = 10)
	private String password;
	@NotEmpty(message = "ConfirmPassword should not be empty")
	@Size(min = 4,max = 10)
	private	String confirmPassword;
	@NotEmpty(message = "UserRole should not be empty")
	private String userRole;
		
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return Username;
	}
	
	@Override
	public String toString() {
		return "User [Username=" + Username + ", emailId=" + emailId + ", password="
				+ password + ", userRole=" + userRole + "]";
	}
	public void setUsername(String username) {
		Username = username;
	}
	
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
}
