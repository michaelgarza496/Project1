package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojos.User;

@WebServlet("/getNavBar")
public class AjaxNavBarServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2285341946907233363L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("NavBarServlet - GET");
		
		if (((User) req.getSession().getAttribute("user")).getUserRoldId() == 1) {
			req.getRequestDispatcher("features/navbar/employeeNavBar.html").forward(req, resp);
			System.out.println("NavBarServlet - Employee NavBar");
		}else if(((User) req.getSession().getAttribute("user")).getUserRoldId() == 2){
			System.out.println("NavBarServlet - Manager NavBar");
			req.getRequestDispatcher("features/navbar/managerNavBar.html").forward(req, resp);
		}
	}
}
