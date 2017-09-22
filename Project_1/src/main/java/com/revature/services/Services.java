package com.revature.services;

import java.util.List;

import com.revature.dao.Dao;
import com.revature.dao.DaoImpl;
import com.revature.dao.ReimbursementDao;
import com.revature.dao.ReimbursementDaoImpl;
import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class Services {
	public static String picturePath;
	
	
	public User authenticateUser(User user){
		
		//Create dao object for user to authenticate
		Dao dao = new DaoImpl();
		User dbUser = dao.getUser(user);
		
		//if object comes back null or credentials don't match up, then return null
		if(dbUser != null)
			if(dbUser.getEmail().equals( user.getEmail() ) 
					&& dbUser.getPassword().equals(user.getPassword() ) ){
				return dbUser;
			}
		
		return null;
	}
	
//	public String parseUserToJSON(User user){
//		System.out.println("Services - parseUserToJson");
//		
//		//Object to JSON in file
//		String userInfo = new ObjectMapper().writeValueAsString(user);
//		System.out.println(userInfo);
//		
//		resp.getWriter().write(userInfo);
//		return null;
//	}
	
	public void persistRequest(Reimbursement rb){
		ReimbursementDao dao = new ReimbursementDaoImpl();
		dao.saveReimbursementRequest(rb);
		System.out.println("Services - persistRequest");
	}
	
	public List<Reimbursement> getAllReimbursementRequestsFromUser(User user){
		ReimbursementDao dao = new ReimbursementDaoImpl();
		return dao.getReimbursementByUser(user);
	}
	
	public List<User> getAllEmployees(){
		Dao dao = new DaoImpl();
		return dao.getAllEmployees();
	}
	
	public List<Reimbursement> getAllReimbursementsForManager(){
		ReimbursementDao dao = new ReimbursementDaoImpl();
		return dao.getAllReimbursementsForManager();
	}
	
	public List<Reimbursement> getAllPendingRequests(){
		ReimbursementDao dao = new ReimbursementDaoImpl();
		return dao.getAllPendingRequestsForManager();
	}
	
	public void updateAllApprovals(List<Reimbursement> allAppr){
		ReimbursementDao dao = new ReimbursementDaoImpl();
		dao.updateApproval(allAppr);
	}
	
	public void updateUserInfo(User user){
		Dao dao = new DaoImpl();
		dao.updateUserInfo(user);
	}
	
	public Reimbursement getReceipt(Reimbursement reim) {
		ReimbursementDao dao = new ReimbursementDaoImpl();
		return dao.getReceipt(reim);
	}

}
