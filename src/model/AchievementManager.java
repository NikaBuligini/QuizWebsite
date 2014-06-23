package model;

import java.sql.Connection;
import java.util.ArrayList;

public class AchievementManager extends Manager{
	ArrayList<Object> arr;
	String tablename = "achievementsAndUsers";
	String ACHIEVEMENTS = "achievements";
	
	private void fillArray(Connection con, int userID){
		arr = AccountManager.getSingleColumn(con, tablename, userID, 2);
	}
	
	public int numOfAchievements(Connection con,int userID){
		fillArray(con,userID);
		return arr.size();
	}
	
	public ArrayList<Object> getAchievements(Connection con,int userID){
		fillArray(con,userID);
		return arr;
	}
	
	public ArrayList<ArrayList<Object>> totalAchievements(Connection con){
		ArrayList<ArrayList<Object>> raws= getAllRows(con, ACHIEVEMENTS, 4);
		return raws;
	}
}