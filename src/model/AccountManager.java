package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountManager {
	
	public static final int WRONG_PARAMS = 0;
	public static final int FAILED = 1;
	public static final int ADDED = 2;
	
	private static final String TABLE_NAME = "users";
	private static final String USERNAME_COLUMN_NAME = "user";
	private static final String PASSWORD_COLUMN_NAME = "password";
	private static final String USERS_COLUMNS = "(username, password)";
	
	
	public int addUser(Connection con, User e, String password){
		if (isValid(e))
			return WRONG_PARAMS;
		if (baseContainsUsername(con, e.getUsername()))
			return FAILED;
		
		addNewUser(con, e, password);
		return ADDED;
	}
	
	
	public boolean contains(Connection con, String username, String password){
		String SQLQuery = selectQueryForUsername(username);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			System.out.println("Exception found while using Statment or ResultSet");
			ex.printStackTrace();
		}
		
		try {
			while (rs.next()) {
				String pass = rs.getString(PASSWORD_COLUMN_NAME);
				if (password.equals(pass)){
					stmt.close();
					rs.close();
					return true;
				}
			}
		} catch (SQLException e1) {
			System.out.println("Exception in contains method");
			e1.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			System.out.println("Exception while closing in contains method");
			e1.printStackTrace();
		}
		
		return false;
	}
	
	
	public User getUser(String username){
		return null;
	}
	
	/*
	 * amistvis axali shezgudvebis damateba shegvidzlia
	 */
	private boolean isValid(User e){
		return e.getUsername().equals("") || e.getUsername() == null;
	}
	
	private boolean baseContainsUsername(Connection con, String username){
		String SQLQuery = selectQueryForUsername(username);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException e) {
			System.out.println("Exception found while using Statment or ResultSet");
			e.printStackTrace();
		}
		
		try {
			while (rs.next()){
				stmt.close();
				rs.close();
				return true;
			}
		} catch (SQLException e) {
			System.out.println("Exception while using rs.next()");
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e) {
			System.out.println("Exception while closing Statement or ResultSet");
			e.printStackTrace();
		}
		
		return false;
	}
	
	private String selectQueryForUsername(String username){
		return "SELECT * FROM " + TABLE_NAME + " WHERE " + USERNAME_COLUMN_NAME 
				+ "='" + username + "'";
	}
	
	private void addNewUser(Connection con, User e, String password){
		String SQLQuery = insertQuery(e, password);
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(SQLQuery);
		} catch (SQLException e1) {
			System.out.println("Exception while executing InsertQuery");
			e1.printStackTrace();
		}
		
		try {
			stmt.close();
		} catch (SQLException e1) {
			System.out.println("Exception while closing Statement");
			e1.printStackTrace();
		}
	}
	
	private String insertQuery(User e, String password){
		return "INSERT INTO " + TABLE_NAME + " " + USERS_COLUMNS + " VALUES (" 
				+ e.getUsername() + ", " + password + ")";
	}
}
