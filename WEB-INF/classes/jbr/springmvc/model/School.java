package jbr.springmvc.model;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class School {


	
	private int id;
	@NotEmpty(message = "Name should not be empty")
	private String name;
	@NotEmpty(message = "Address should not be empty")
	@Size(min = 3,max = 50)
	private String address;
	@NotEmpty(message = "Medium should not be empty")

	private String medium;
	@NotEmpty(message = "Board should not be empty")

	private String board;
	private String Username;
	private String userRole;
	public String getUsername() {
		
		return Username;
	}
	
	
	
	public void setUsername(String username) {
		Username = username;
	}
	public String getUserRole() {
		return userRole;
	}
	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getMedium() {
		return medium;
	}
	public void setMedium(String medium) {
		this.medium = medium;
	}
	public String getBoard() {
		return board;
	}
	public void setBoard(String board) {
		this.board = board;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
}
