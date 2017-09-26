package com.mikesimagination.UnitTests;

import org.junit.Test;
import org.junit.Assert;

import com.revature.pojos.User;

public class UserPojo {

	private User user;
	
	@Test
	public void testGetRole(){
		user = new User(123, "m@yahoo.com", "p4ssw0rd", "Michael", "Garza", 2, "Manager");
		
		Assert.assertEquals("Manager", user.getRole());
		Assert.assertEquals(123, user.getUserId());
		Assert.assertEquals("m@yahoo.com", user.getEmail());
		Assert.assertEquals("p4ssw0rd", user.getPassword());
		Assert.assertEquals("Michael", user.getFirstName());
	}
}
