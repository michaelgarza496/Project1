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

@WebServlet("/getManagerViewReimbursementsData")
public class AjaxGetManagerViewReimbursementsDataServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxgetGetManagerViewReimbursementsDataServlet - Get");
		
		List<Reimbursement> allRemb = new Services().getAllReimbursementsForManager();
		
		System.out.println("Parsing requests: " + allRemb);
		//Object to JSON in file
		String rembData = new ObjectMapper().writeValueAsString(allRemb);
		System.out.println("Parsed allRembData: " + rembData);
		
		resp.getWriter().write(rembData);
	}

}
