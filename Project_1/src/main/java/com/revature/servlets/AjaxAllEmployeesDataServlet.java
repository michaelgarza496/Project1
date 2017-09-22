package com.revature.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.Services;

@WebServlet("/getAllEmployeesData")
public class AjaxAllEmployeesDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxAllEmployeesDataServlet - GET");
		
		
		List<User> allEmployees = new Services().getAllEmployees();
		
		System.out.println("Parsing requests: " + allEmployees);
		//Object to JSON in file
		String allEmployeesData = new ObjectMapper().writeValueAsString(allEmployees);
		System.out.println("Parsed rembData: " + allEmployeesData);
		
		resp.getWriter().write(allEmployeesData);
	}

}
