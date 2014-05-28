package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionManager implements WebVariables{
	
	private static String SELECT_ALL = "SELECT * FROM " + SEQ_QUESTIONS_TABLE;
	private static String SELECT_ID = "SELECT ID FROM " + SEQ_QUESTIONS_TABLE;
	
	public static ArrayList<String> getQuestions(Connection con) {
		String SQLQuery = SELECT_ALL;
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			System.out.println("Exception: Question Manager, getQuestions, Statment or ResultSet");
			ex.printStackTrace();
		}
		
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs.next())
				list.add(rs.getString(SEQ_QUESTION_COL));
		} catch (SQLException e) {
			System.out.println("Exception: Question Manager, getQuestions, while(rs.next())");
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			System.out.println("Exception: Question Manager, getQuestions, close()");
			e1.printStackTrace();
		}
		
		return list;
	}
	
	public static int getQuestionID(Connection con, String question) {
		String SQLQuery = SELECT_ID + " WHERE " + SEQ_QUESTION_COL + "='" + question + "'";
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			System.out.println("Exception: Question Manager, getQuestionID, Statment or ResultSet");
			ex.printStackTrace();
		}
		
		int result = 0;
		try {
			while (rs.next())
				result = rs.getInt(SEQ_QUESTION_COL);
		} catch (SQLException e) {
			System.out.println("Exception: Question Manager, getQuestionID, while(rs.next())");
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			System.out.println("Exception: Question Manager, getQuestionID, close()");
			e1.printStackTrace();
		}
		
		return result;
	}
	
}
