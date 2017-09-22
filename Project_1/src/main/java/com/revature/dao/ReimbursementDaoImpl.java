package com.revature.dao;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class ReimbursementDaoImpl implements ReimbursementDao{
	private static final String USERNAME = "shartywaffles";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@testdb.cjtyi0m7ybgn.us-east-2.rds.amazonaws.com:1521:ORCL";
	
	@Override
	public void saveReimbursementRequest(Reimbursement rb) {
		System.out.println("ReimbursementDaoImpl - saveReimbursementRequest");
		
		String sql = "INSERT INTO REIMBURSEMENT VALUES(null, ?, ?, ?, ?, null, null, ?, 0, ?)";
		
		// Connect to the database
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {

			
//			R_ID
//			R_STATUS_ID
//			R_TYPE_ID
//			R_RECEIPT
//			R_AMOUNT
//			R_SUBMITTED
//			R_RESOLVED
//			R_AUTHOR
//			R_RESOLVER
//			R_DESCRIPTION
			// prepare the statement to send to database
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, rb.getStatusId());
			ps.setInt(2, rb.getTypeId());
			ps.setDouble(4, rb.getAmount());
			ps.setBlob(3, rb.getInputStream());
			ps.setInt(5, rb.getAuthorId());
			ps.setString(6, rb.getDescription());
//ps.setBlob(parameterIndex, inputStream);
			// execute query
			ps.executeQuery();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Reimbursement> getReimbursementByUser(User user) {
		System.out.println("ReimbursementDaoImpl - getReimbursementById");
		
		List<Reimbursement> rb = new ArrayList<>();;
		
		//SQL Statement
//		String sql = "SELECT * FROM REIMBURSEMENT R WHERE R.R_AUTHOR = (SELECT U_ID FROM USERS WHERE U_ID = ?)";
		String sql = "SELECT REIMBURSEMENT.*, R_STATUS.R_STATUS, R_TYPE.R_TYPE, RES.FIRST_NAME, RES.LAST_NAME FROM ((((REIMBURSEMENT "
				+ "INNER JOIN R_STATUS ON REIMBURSEMENT.R_STATUS_ID = R_STATUS.R_STATUS_ID) "
				+ "INNER JOIN R_TYPE ON REIMBURSEMENT.R_TYPE_ID = R_TYPE.R_TYPE_ID) "
				+ "INNER JOIN USERS ON USERS.U_ID = ?) "
				+ "INNER JOIN USERS RES ON REIMBURSEMENT.R_RESOLVER = RES.U_ID) "
				+ "WHERE REIMBURSEMENT.R_AUTHOR = ?";
		
		//Prepared Statement
		// Connect to the database
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, user.getUserId());
			ps.setInt(2, user.getUserId());
			
			//execute query
			ResultSet rs = ps.executeQuery();
//R_ID, R_STATUS_ID, R_TYPE_ID, R_RECEIPT, R_AMOUNT, R_SUBMITTED, R_RESOLVED, R_AUTHOR, R_RESOLVER, R_DESCRIPTION, R_STATUS, R_TYPE, FIRST_NAME, LAST_NAME
			//put values in new user object if found
			while(rs.next()){
				rb.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(11), rs.getInt(3), rs.getString(12), rs.getDouble(5), rs.getString(6).substring(0, rs.getString(6).length()-10), 
						rs.getString(7), rs.getInt(8), user.getFirstName() + " " + user.getLastName(), rs.getInt(9), rs.getString(13) + " " + rs.getString(14), 
						rs.getString(10)));
//				System.out.println(rb.get(0));
			}
		
//			R_ID
//			R_STATUS_ID
//			R_TYPE_ID
//			R_RECEIPT
//			R_AMOUNT
//			R_SUBMITTED
//			R_RESOLVED
//			R_AUTHOR
//			R_RESOLVER
//			R_DESCRIPTION
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(rb);	
		return rb; 
	}

	@Override
	public List<Reimbursement> getAllReimbursementsForManager() {
		System.out.println("getAllReimbursementsForManager");
		
		List<Reimbursement> allReimbursements = new ArrayList<>();
		
		String sql = "SELECT reimbursement.*, auth_user.first_name AS author_first, auth_user.last_name AS author_last, "
				+ "res_user.first_name as reslover_first, res_user.last_name as resolver_last, "
				+ "status.r_status, r_type.r_type FROM ((((reimbursement "
				+ "INNER JOIN users auth_user ON auth_user.u_id = reimbursement.r_author) "
				+ "INNER JOIN users res_user ON reimbursement.r_resolver = res_user.u_id) "
				+ "INNER JOIN r_status status ON reimbursement.r_status_id = status.r_status_id) "
				+ "INNER JOIN r_type ON reimbursement.r_type_id = r_type.r_type_id)";
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//execute query
			ResultSet rs = ps.executeQuery();

//R_ID 1, R_STATUS_ID 2, R_TYPE_ID 3, R_RECEIPT 4, R_AMOUNT 5, 
//R_SUBMITTED 6, R_RESOLVED 7, R_AUTHOR 8, R_RESOLVER 9, R_DESCRIPTION 10, 
//AUTHOR_FIRST 11, AUTHOR_LAST 12, RESLOVER_FIRST 13, RESOLVER_LAST 14, R_STATUS 15
//r_type 16
			
//			public Reimbursement(int reimbursementId, int statusId, String status, int typeId, String type, double amount,
//					String timeSubmitted, String resolved, int authorId, String author, int resolverId, String resolver,
//					String description) {
			while(rs.next()){
				String resolved;
				if(rs.getString(7) == null || rs.getString(7) == ""){
					resolved = "Not resolved";
				}else{
					resolved = rs.getString(7).substring(0, rs.getString(7).length()-10);
				}
				
				allReimbursements.add(new Reimbursement(rs.getInt(1), rs.getInt(2), rs.getString(15), rs.getInt(3), rs.getString(16), rs.getDouble(5), 
						rs.getString(6).substring(0, rs.getString(6).length()-10), resolved, 
						rs.getInt(8), rs.getString(11) + " " + rs.getString(12), rs.getInt(9), rs.getString(13) + " " + rs.getString(14), 
						rs.getString(10)));
//				System.out.println(allReimbursements.get(0));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			System.out.println(allReimbursements);	
		
		return allReimbursements;
	}

	@Override
	public List<Reimbursement> getAllPendingRequestsForManager() {
		System.out.println("ReimbursementDaoImpl - getAllPendingRequestsForManager");
		
		List<Reimbursement> pendingRequests = new ArrayList<>();
		
		String sql = "SELECT auth_user.first_name, auth_user.last_name, r_type.r_type, rb.r_submitted, rb.r_description, rb.r_amount, rb.r_author, rb.r_id "
				+ "FROM ((reimbursement rb "
				+ "INNER JOIN users auth_user ON auth_user.u_id = rb.r_author) "
				+ "INNER JOIN r_type ON rb.r_type_id = r_type.r_type_id) "
				+ "WHERE rb.r_status_id = 3";
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//execute query
			ResultSet rs = ps.executeQuery();

//			FIRST_NAME, LAST_NAME, R_TYPE, R_SUBMITTED, R_DESCRIPTION, amount, author, id
			while(rs.next()){
				
				
				pendingRequests.add(new Reimbursement(rs.getInt(8), 0, "", 0, rs.getString(3), rs.getDouble(6), 
						rs.getString(4).substring(0, rs.getString(4).length()-10), "", rs.getInt(7), rs.getString(1) + " " + rs.getString(2), 0, "", rs.getString(5)));
//				System.out.println(pendingRequests.get(0));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
//			System.out.println(pendingRequests);	
		
		return pendingRequests;
	}

	@Override
	public void updateApproval(List<Reimbursement> apprList) {
		System.out.println("Updating Approvals");
		
		String sql = "UPDATE reimbursement SET r_status_id = ?, r_resolver = ? WHERE r_id = ?";
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps;
			
			for(int i = 0; i < apprList.size(); i++){
				ps = conn.prepareStatement(sql);
				ps.setInt(1, apprList.get(i).getStatusId());
				ps.setInt(2, apprList.get(i).getResolverId());
				ps.setInt(3, apprList.get(i).getReimbursementId());

				//execute query
				ResultSet rs = ps.executeQuery();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Updated approvals");	
	}

	@Override
	public Reimbursement getReceipt(Reimbursement r) {
		
		try(Connection connect = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
		
			String sql = "SELECT r_receipt FROM reimbursement WHERE r_id = ?";
			PreparedStatement ps = connect.prepareStatement(sql);
			ps.setInt(1, r.getReimbursementId());
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				System.out.println("Found image for r_id: " + r.getReimbursementId());
				return new Reimbursement(rs.getBytes(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}


	
}
