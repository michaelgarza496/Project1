package com.revature.dao;

import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public interface ReimbursementDao {
	
	//CREATE
	public void saveReimbursementRequest(Reimbursement rb);
	
	//READ
	public List<Reimbursement> getReimbursementByUser(User user);
	public List<Reimbursement> getAllReimbursementsForManager();
	public List<Reimbursement> getAllPendingRequestsForManager();
	public Reimbursement getReceipt(Reimbursement r);
	
	//UPDATE
	public void updateApproval(List<Reimbursement> apprList);
	
	//DELETE
}
