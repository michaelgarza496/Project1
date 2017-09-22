package com.revature.dao;

import java.util.List;

import com.revature.pojos.User;

public interface Dao {

	//CREATE
	
	//READ
	public User getUser(User user);
	public List<User> getAllEmployees();
	
	//UPDATE
	public void updateUserInfo(User user);
}
