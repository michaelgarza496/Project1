package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojos.Reimbursement;
import com.revature.services.Services;

@WebServlet("/getReceipt")
public class AjaxGetReceipt extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		
		String s = new ObjectMapper().writeValueAsString(new Services().getReceipt(new Reimbursement(Integer.parseInt(req.getParameter("id")))));
		System.out.println("s: " + s);
		resp.getWriter().write(s);

	}
}
