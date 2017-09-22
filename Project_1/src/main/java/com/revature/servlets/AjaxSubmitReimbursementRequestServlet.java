package com.revature.servlets;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;
import com.revature.services.Services;

@MultipartConfig(maxFileSize = 16177215)
@WebServlet("/submitReimbursementRequest")
public class AjaxSubmitReimbursementRequestServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("AjaxSubmitReimbursementRequestServlet - GET");
		
		Reimbursement rb = new Reimbursement();
		User user = (User) req.getSession().getAttribute("user");
//		public Reimbursement(int statusId, int typeId, double amount, int authorId, String description) {
		
		rb.setStatusId(3);
		System.out.println(Integer.parseInt(req.getParameter("reqType")));
		rb.setTypeId(Integer.parseInt(req.getParameter("reqType")));
		rb.setAmount(Double.parseDouble(req.getParameter("amount")));
		rb.setAuthorId(user.getUserId());
		rb.setDescription(req.getParameter("description"));
		
		//trying for image
		InputStream inputStream = null; // input stream of the upload file
        // obtains the upload file part in this multipart request
        Part filePart = req.getPart("receiptImage");
//		rb.setReceipt(req.getParameter("receiptImage"));
        inputStream = filePart.getInputStream();
        rb.setInputStream(inputStream);
		
		new Services().persistRequest(rb);
		resp.sendRedirect("app.html");
		
	}
}
