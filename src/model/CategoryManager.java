package model;

import java.util.ArrayList;
import java.sql.Connection;

public class CategoryManager extends Manager {
	static String tableName = "categories";

	public static ArrayList<String> getAllCategories(Connection con) {
		ArrayList<ArrayList<Object>> ar = getAllRows(con, tableName, 2);
		ArrayList<String> res = new ArrayList<String>();
		for (int i = 0; i < ar.size(); i++) {
			res.add((String) ar.get(i).get(1));
		}
		return res;
	}
	
	public static ArrayList<Integer> getCategoryIDs(Connection con){
		ArrayList<ArrayList<Object>> ar = getAllRows(con, tableName, 2);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < ar.size(); i++) {
			res.add((Integer) ar.get(i).get(0));
		}
		return res;
	}
	
	public static String getCategoryByID(Connection con, int ID){
		return (String)getSingleString(con, tableName, "ID", ID, "type");
	}
}
