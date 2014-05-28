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
	private static final String TABLE_OF_INFO = "additionalInfo";
	private static final String EMAIL_COLUMN_NAME = "email";
	private static final String USERNAME_COLUMN_NAME = "user";
	private static final String PASSWORD_COLUMN_NAME = "password";
	private static final String USERS_COLUMNS = "(username, password)";
	
	private Statement stmt = null;
	private ResultSet rs = null;
	
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
	
	private boolean baseContainsEmail(Connection con, String Email){
		String SQLQuery = selectQueryForEmail(Email);
		
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
	
	private String selectQueryForEmail(String Email) {
		
		return "SELECT * FROM " + TABLE_OF_INFO + " WHERE " + EMAIL_COLUMN_NAME 
				+ " ='" + Email + "'";
	}

	public String getRecoveryQuestionAndAnswer(Connection con, String emailOrUsername){
		String Question = "";
		String Answer = "";
		String Username = "";
		String Pass = "";
		String SQLQuery = "";
		
		if(baseContainsEmail(con, emailOrUsername))
			SQLQuery = selectQueryForQuestion(emailOrUsername, true);
		else if(baseContainsUsername(con, emailOrUsername))
			SQLQuery = selectQueryForQuestion(emailOrUsername, false);
		else 
			return "";

		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			while(rs.next()){
				Question = rs.getString("question");
				Answer = rs.getString("answer");
				Username = rs.getString("username");
				Pass = rs.getString("pass"); 
				stmt.close();
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return Question + "/" + Answer + "/" + Username + "/" + Pass;
		
	}

	private String selectQueryForQuestion(String emailOrUsername, boolean email) {
		if(email)
			return "Select username, pass, quesiton, answer from " + TABLE_OF_INFO + " "
					+ "join questions on " + TABLE_OF_INFO + ".questionID = question.ID WHERE " + EMAIL_COLUMN_NAME + " = '" + emailOrUsername + "'";
		else
			return "Select username, pass, question, answer from " + TABLE_OF_INFO + " join " + TABLE_NAME + " on " + TABLE_NAME +".ID = " + TABLE_OF_INFO + ".userID"
				+ " join questions on " + TABLE_OF_INFO + ".questionID = question.ID WHERE " + USERNAME_COLUMN_NAME + " = '" + emailOrUsername + "'";
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
