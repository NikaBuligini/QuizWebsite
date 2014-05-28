package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLManager implements WebVariables {
	
	private static final String COOKIE_INSERT = "INSERT INTO " + COOKIES_TABLE + " " +
			COOKIES_COLUMNS	+ " VALUES ";
	
	public static int getUserIDByUsername(Connection con, String username){
		return get(con, USERS_TABLE, USERNAME_COL, username, "ID");
	}
	
	
	public static int getUserIDByEMail(Connection con, String email){
		return get(con, USER_INFO_TABLE, INFO_EMAIL_COL, email, INFO_USER_ID_COL);
	}
	
	
	public static int getUserIDByCookie(Connection con, String value) {
		return get(con, COOKIES_TABLE, COOKIES_VALUE_COL, value, COOKIES_USER_COL);
	}
	
	
	public static String getCookieByUserID(Connection con, int userID) {
		String SQLQuery = "SELECT * FROM " + COOKIES_TABLE + " WHERE " + COOKIES_USER_COL +
				"=" + userID;
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		String result = null;
		try {
			while (rs.next())
				result = rs.getString(COOKIES_VALUE_COL);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}
	
	
	public static void addCookie(Connection con, String value, int userID) {
		String SQLQuery = COOKIE_INSERT + "('" + value + "', " + userID + ")";
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(SQLQuery);
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static void updateCookie(Connection con, String value, int userID) {
		String SQLQuery = "UPDATE " + COOKIES_TABLE + " SET " + COOKIES_VALUE_COL + "='" +
				value + "' WHERE "+ COOKIES_USER_COL + "=" + userID;
		
		Statement stmt = null;
		try {
			stmt = con.createStatement();
			stmt.executeUpdate(SQLQuery);
			stmt.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	
	public static boolean containsCookie(Connection con, String value){
		int result = get(con, COOKIES_TABLE, COOKIES_VALUE_COL, value, COOKIES_USER_COL);
		return result == 0;
	}
	
	
	
	private static int get(Connection con, String table, String column, String value, String ID_col){
		String SQLQuery = "SELECT * FROM " + table + " WHERE " + column + "='" + value + "'";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		int result = 0;
		try {
			while (rs.next())
				result = rs.getInt(ID_col);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
		return result;
	}
}
