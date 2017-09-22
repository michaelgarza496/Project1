package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/getReimbursementPage")
public class AjaxGetReimbursementRequestServlet extends HttpServlet{
	private static final long serialVersionUID = 6206806622372775968L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetReimburstmentRequestServlet - GET");
		
		req.getRequestDispatcher("features/reimbursementsPage/reimbursementRequestPage.html").forward(req, resp);
	}
}
