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
import com.revature.services.Services;

@WebServlet("/getApproveOrDenyReimbursementsData")
public class AjaxGetApproveOrDenyReimbursementsData extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetManagerViewReimbursementsData - GET");
		
		List<Reimbursement> pendingRem = new Services().getAllPendingRequests();
		
		System.out.println("Parsing requests: " + pendingRem);
		//Object to JSON in file
		String pendingRemData = new ObjectMapper().writeValueAsString(pendingRem);
		System.out.println("Parsed allRembData: " + pendingRemData);
		
		resp.getWriter().write(pendingRemData);
	}

}
