package com.revature.servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.Services;

@WebServlet("/submitApproval")
public class ApprovalRequestServlet extends HttpServlet{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("ApprovalRequestServlet - POST");
		
		List<Reimbursement> approval = new ArrayList<>();
		User user = (User) req.getSession().getAttribute("user");
		
		System.out.println(req.getParameter("numberOfSelects"));
		int numOfSelects = Integer.parseInt(req.getParameter("numberOfSelects"));
		System.out.println("numOfSelects: " + numOfSelects);
		int reqId;
		int statusId;
		int resolver = 0;
		for(int i = 0; i < numOfSelects; i++){
			
			reqId = Integer.parseInt( req.getParameter( Integer.toString(i) ).substring(1) );
			System.out.println("reqId: " + reqId);
			
			statusId = Integer.parseInt( req.getParameter( Integer.toString(i) ).substring(0, 1) );
			System.out.println("statusId: " + statusId);
			if(statusId == 1 || statusId == 2){
				resolver = user.getUserId();
			}else if(statusId == 3){
				resolver = 0;
				continue;
			}
			System.out.println("Adding to approval list");
			approval.add( new Reimbursement(reqId, statusId, "", 0, "", 0.0, "", "", 0, "", resolver, "", ""));
		}
		
		
		new Services().updateAllApprovals(approval);
		resp.sendRedirect("app.html");
	}
}
