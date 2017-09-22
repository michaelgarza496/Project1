package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.User;
import com.revature.services.Services;

@WebServlet("/updatePersonalInfo")
public class UpdatePersonalInfoServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User user = (User) req.getSession().getAttribute("user");
		
		user.setEmail(req.getParameter("emailUpdate"));
		user.setPassword(req.getParameter("passwordUpdate"));
		user.setFirstName(req.getParameter("firstNameUpdate"));
		user.setLastName(req.getParameter("lastNameUpdate"));
		
		new Services().updateUserInfo(user);
		resp.sendRedirect("app.html");
	}
}
