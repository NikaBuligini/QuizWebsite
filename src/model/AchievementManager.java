package model;

import java.sql.Connection;
import java.util.ArrayList;

public class AchievementManager extends Manager{
	ArrayList<Object> arr;
	String tablename = "achievementsAndUsers";
	String ACHIEVEMENTS = "achievements";
	
	private void fillArray(Connection con, int userID){
		arr = new ArrayList<>();
		
		ArrayList<ArrayList<Object>> allRaws = getAllRows(con, tablename, 2);
		for(int i=0; i<allRaws.size();i++){
			int stringID = (int) allRaws.get(i).get(0);
			if(stringID==userID)
				arr.add(allRaws.get(i).get(1));
		}
		
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