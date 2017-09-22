package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2317235905548669432L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("LogoutServlet - GET");
		
//		resp.setHeader("Cache-Control","no-cache"); //Forces caches to obtain a new copy of the page from the origin server
//		resp.setHeader("Cache-Control","no-store"); //Directs caches not to store the page under any circumstance

		// redirect user to login page if this page is initially requested with
		// no authentication or session
		if (req.getSession(false) == null) {
			resp.sendRedirect("index.html");
			System.out.println("Logout (session already null) sendRedirect - index.html");
		}
		
		HttpSession session = req.getSession(false);
		if(session != null){
			session.removeAttribute("user");
			session.invalidate();
			System.out.println("Logout - session invalidated");
			
		}
//		req.getSession().invalidate();
		
		//session = req.getSession(true);
		resp.sendRedirect("index.html");
		System.out.println("Logout sendRedirect - index.html");
		return;
	}

}
