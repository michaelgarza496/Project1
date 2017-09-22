package com.revature.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojos.Reimbursement;
import com.revature.pojos.User;

public class DaoImpl implements Dao{
	
	private static final String USERNAME = "shartywaffles";
	private static final String PASSWORD = "p4ssw0rd";
	private static final String URL = "jdbc:oracle:thin:@testdb.cjtyi0m7ybgn.us-east-2.rds.amazonaws.com:1521:ORCL";

	@Override
	public User getUser(User user) {
		User getUser = null;
		
		//Make the sql statement to get the values from the database
		String sql = "SELECT u.U_ID, u.email, u.password, u.FIRST_NAME, u.LAST_NAME, ur.U_ROLE_ID, "
				+ "ur.U_ROLE FROM USERS u INNER JOIN U_ROLE ur ON u.U_ROLE_ID = "
				+ "ur.U_ROLE_ID AND u.email=? AND u.password=?";
		
		try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
		
		//Connect to the database
		try(Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)){
				
			//prepare the statement to send to database
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getEmail());
			ps.setString(2, user.getPassword());
			
			//execute query
			ResultSet rs = ps.executeQuery();
			
			//put values in new user object if found
			while(rs.next()){
				getUser = new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), 
						rs.getString(5), rs.getInt(6), rs.getString(7));
			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		return getUser;
	}

	@Override
	public List<User> getAllEmployees() {
		List<User> allEmployees = new ArrayList<>();
		
		//Set up our sql statement
		String sql = "SELECT * FROM USERS WHERE U_ROLE_ID = 1";
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			
			//execute query
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()){
				allEmployees.add(new User(rs.getInt(1), rs.getString(4), "", rs.getString(2), rs.getString(3), rs.getInt(6), ""));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
//		System.out.println(allEmployees);	
			
			
		return allEmployees;
	}

	@Override
	public void updateUserInfo(User user) {
		//Set up our sql statement
		String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, password = ? WHERE u_id = ?";
		
		try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD)) {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, user.getFirstName());
			ps.setString(2, user.getLastName());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPassword());
			ps.setInt(5, user.getUserId());
			
			//execute query
			ps.executeQuery();
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
}
