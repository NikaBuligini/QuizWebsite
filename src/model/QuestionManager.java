package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class QuestionManager implements WebVariables{
	
	private static String SELECT = "SELECT * FROM " + QUESTIONS_TABLE;
	
	public static ArrayList<String> getQuestions(Connection con) {
		String SQLQuery = SELECT;
		
		Statement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			System.out.println("Exception: Question Manager, Statment or ResultSet");
			ex.printStackTrace();
		}
		
		ArrayList<String> list = new ArrayList<String>();
		try {
			while(rs.next())
				list.add(rs.getString(QUESTION_COL));
		} catch (SQLException e) {
			System.out.println("Exception: Question Manager, while(rs.next())");
			e.printStackTrace();
		}
		
		try {
			stmt.close();
			rs.close();
		} catch (SQLException e1) {
			System.out.println("Exception: Question Manager, close()");
			e1.printStackTrace();
		}
		
		return list;
	}
	
}
