package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountManager implements WebVariables {
	
	public static final int WRONG_PARAMS = 0;	//agar viyeneb
	public static final int FAILED = 1;
	public static final int ADDED = 2;
	
	
	public int addUser(Connection con, User e, String password){
		if (baseContainsUsername(con, e.getUsername()))
			return FAILED;
		
		addNewUser(con, e, password);
		return ADDED;
	}
	
	
	public boolean contains(Connection con, String username, String password){
		String SQLQuery = selectQueryForUsername(USERS_TABLE, username);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			System.out.println("Exception found while using Statment or ResultSet");
			ex.printStackTrace();
		}
		
		boolean contains = false;
		try {
			while (rs.next()) {
				String pass = rs.getString(PASSWORD_COL);
				if (password.equals(pass))
					contains = true;
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
		
		return contains;
	}
	
	
	public User getUser(String username){
		return null;
	}
	
	
	private boolean baseContainsUsername(Connection con, String username){
		String SQLQuery = selectQueryForUsername(USERS_TABLE, username);
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException e) {
			System.out.println("Exception found while using Statment or ResultSet");
			e.printStackTrace();
		}
		
		boolean contains = false;
		try {
			while (rs.next())
				contains = true;
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
		
		return contains;
	}
	
	private String selectQueryForUsername(String table, String username){
		return "SELECT * FROM " + table + " WHERE " + USERNAME_COL 
				+ "='" + username + "'";
	}
	
	private void addNewUser(Connection con, User e, String password){
		String SQLQuery = insertQuery(USERS_TABLE, e, password);
		
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
	
	private String insertQuery(String table, User e, String password){
		String query = "INSERT INTO " + table + " " + USERS_COLUMNS + " VALUES ('" 
				+ e.getUsername() + "', '" + password + "')";
		System.out.println(query);
		return query;
	}
}
