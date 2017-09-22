package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getManagerViewReimbursementsPage")
public class AjaxgetManagerViewReimbursementsPage extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxgetManagerViewReimbursementsPage - GET");
		
		req.getRequestDispatcher("features/manager/managerViewAllRequests.html").forward(req, resp);;
	}
}
