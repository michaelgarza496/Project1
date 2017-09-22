package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getAllReimbursementsPage")
public class AjaxGetAllRequestsPage extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 55289132335389102L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetAllRequests - GET");
		
		req.getRequestDispatcher("features/reimbursementsPage/viewReimbursements.html").forward(req, resp);
	}
}
