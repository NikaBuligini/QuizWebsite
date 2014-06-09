package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;

public class SearchManager extends Manager {
	
	static final String TABLE = AccountManager.INFO_TABLE;
	static final String ID = AccountManager.INFO_USER_ID_C;
	static final String FIRST_NAME = AccountManager.INFO_FIRSTNAME_C;
	static final String LAST_NAME = AccountManager.INFO_LASTNAME_C;
	
	
	public static Object[] search(Connection con, String text){
		String[] list = text.split(" ");
		
		if (list.length == 0 || list == null)
			return null;
		
		HashSet<Integer> set = getAllID(con, list);
		
		if (set == null)
			return null;
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (Integer i : set)
			result.add(i);
		
		return result.toArray();
	}
	
	
	private static HashSet<Integer> getAllID(Connection con, String[] list) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		if (list.length == 1) {
			ArrayList<Integer> first = getIDsFor(con, FIRST_NAME, list[0]);
			ArrayList<Integer> last = getIDsFor(con, LAST_NAME, list[0]);
			
			if (first == null && last == null)
				return null;
			
			set.addAll(first);
			set.addAll(last);
			return set;
		} else {
			
		}
		
		
		
		for (int i=0; i<list.length; i++){
			if (list[i].length() > 0){
				ArrayList<Integer> first = getIDsFor(con, FIRST_NAME, list[i]);
				ArrayList<Integer> last = getIDsFor(con, LAST_NAME, list[i]);
				
				if (first == null && last == null)
					return null;
				
				set.addAll(first);
				set.addAll(last);
			}
		}
		
		return set;
	}
	
	
	private static ArrayList<Integer> getIDsFor(Connection con, String column, String value){
		String SQLQuery = "SELECT " + ID + " FROM " + TABLE + " WHERE " 
				+ column + " Like '%" + (String)value + "%'";
		return getInts(con, SQLQuery, column);
	}
	
	
	private static ArrayList<Integer> getInts(Connection con, String SQLQuery, String needed_Col){
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		try {
			while (rs.next())
				result.add(rs.getInt(1));
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
