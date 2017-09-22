package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojos.User;
import com.revature.services.Services;


@WebServlet("/index")
public class loginServlet extends HttpServlet{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7276104988131879746L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		resp.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance

		System.out.println("LoginServlet - POST");
		
		//create a user object
		User clientUser = new User();

		//get the email and password supplied in the login page
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		//set the email and password to the user object
		clientUser.setEmail(email);
		clientUser.setPassword(password);
		
		//authenticate user
		clientUser = new Services().authenticateUser(clientUser);// Either receive a valid user or null
		
//		System.out.println(clientUser);
//		System.out.println("The user entered: " + email + " with a password of " + password);
		
		if(clientUser != null){
			System.out.println("clientUser != null");
			
			HttpSession session = req.getSession(true); //j_session_id stored in a cookie on the client's browser
			session.setAttribute("user", clientUser); //The parameters: name, and the actual object that you want to store in the session

			clientUser = null;

			resp.sendRedirect("app.html");

			
			
		}else{
			resp.sendRedirect("index.html");
		}
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
		resp.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance
	}
}
