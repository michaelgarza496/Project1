package com.revature.pojos;

public class User {
	
	//State
	private int userId;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private int userRoldId;
	private String role;


	//No-args
	public User() {}




	public String getRole() {
		return role;
	}




	public void setRole(String role) {
		this.role = role;
	}




	public User(int userId, String email, String password, String firstName, String lastName, int userRoldId,
			String role) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.userRoldId = userRoldId;
		this.role = role;
	}




	//Getters and Setters
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getUserRoldId() {
		return userRoldId;
	}

	public void setUserRoldId(int userRoldId) {
		this.userRoldId = userRoldId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userRoldId=" + userRoldId + ", email=" + email + ", password=" + password
				+ ", firstName=" + firstName + ", lastName=" + lastName + "]";
	}
	
	
	
}
