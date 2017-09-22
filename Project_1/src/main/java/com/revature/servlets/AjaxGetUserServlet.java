package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.User;

@WebServlet("/getUser")
public class AjaxGetUserServlet extends HttpServlet{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7841381660800832812L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxGetUser - GET");
		
																			// 1 = employee
		if( ((User) (req.getSession().getAttribute("user"))).getUserRoldId() == 1  ){
			System.out.println("AjaxGetUserServlet - forwarding to employeeHomePage.html");
			req.getRequestDispatcher("features/userHomePage/employeeHomePage.html").forward(req, resp);
		
																			// 2 = manager
		}else if( ((User) (req.getSession().getAttribute("user"))).getUserRoldId() == 2  ){
			System.out.println("AjaxGetUserServlet - forwarding to managerHomePage.html");
			req.getRequestDispatcher("features/userHomePage/managerHomePage.html").forward(req, resp);
		}
	}

}
