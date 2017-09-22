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

@WebServlet("/getAllReimbursements")
public class AjaxGetAllRequestsDataServlet extends HttpServlet{
	private static final long serialVersionUID = -1325284785080912599L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetAllRequestsDataServlet - GET");
		
		User user = (User) req.getSession().getAttribute("user");
		List<Reimbursement> allRemb = new Services().getAllReimbursementRequestsFromUser(user);
		
		System.out.println("Parsing requests: " + allRemb);
		//Object to JSON in file
		String rembData = new ObjectMapper().writeValueAsString(allRemb);
		System.out.println("Parsed rembData: " + rembData);
		
		resp.getWriter().write(rembData);
	}
}
