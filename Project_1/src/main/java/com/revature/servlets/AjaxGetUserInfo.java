package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.User;

@WebServlet("/getUserInfo")
public class AjaxGetUserInfo extends HttpServlet{
	private static final long serialVersionUID = 8249355338138899300L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetUserInfo - Get");
		
		User user = (User) req.getSession().getAttribute("user");
		
		System.out.println("Parsing user: " + user);
		//Object to JSON in file
		String userInfo = new ObjectMapper().writeValueAsString(user);
		System.out.println("Parsed user: " + userInfo);
		
		resp.getWriter().write(userInfo);
	}
}
