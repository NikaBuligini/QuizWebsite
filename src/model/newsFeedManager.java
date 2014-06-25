package model;

import java.util.ArrayList;
import java.sql.Connection;

public class newsFeedManager extends Manager {
	static String tableName = "newsFeed";

	public ArrayList<String> getFriendsPlayings(Connection con, int userID) {
		ArrayList<Integer> friends = FriendManager.getFriends(con, userID);
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0; i < friends.size(); i++) {
			PlayedQuizzes.getPlayedQuizzesByUserID(friends.get(i), con);
		}
		return str;
	}

	public static void postCreatedQuizNews(Connection con, Object userID,
			Object quiz) {
		
		int ID = (Integer)userID;
		String quizName = (String)quiz;
		int quizID = getSingleInt(con, "quizzes", "name", quizName, "ID");
		String text = " created Quiz named ";
		Object[] ar = new Object[] { userID, text,userID, quizID };
		insert(con, tableName, "(userID, text,subjectID,objectID)", ar);
		for(int i = 0; i < FriendManager.getFriends(con, ID).size(); i++) {
			ar[0] = FriendManager.getFriends(con, (Integer) userID).get(i);
			insert(con, tableName, "(userID,  text)", ar);
		}
	}

	public static void postPlayedQuizNews(Connection con, Object userID,
			Object quiz) {
		int ID = (Integer)userID;
		String quizName = (String)quiz;
		int quizID = getSingleInt(con, "quizzes", "name", quizName, "ID");
		String text = " played Quiz named ";
		Object[] ar = new Object[] { userID, text,userID, quizID };
		insert(con, tableName, "(userID, text,subjectID,objectID)", ar);
		for(int i = 0; i < FriendManager.getFriends(con, ID).size(); i++) {
			ar[0] = FriendManager.getFriends(con, (Integer) userID).get(i);
			insert(con, tableName, "(userID,  text)", ar);
		}
	}
	
	
	public static ArrayList<ArrayList<Object>> getNews (Connection con, int userID){
		ArrayList<ArrayList<Object>> temp = getAllRows(con, tableName, 5);
		ArrayList<ArrayList<Object>> arr = new ArrayList<ArrayList<Object>>();
		for(int i=0;i<temp.size();i++){
			int tempID = (Integer)temp.get(i).get(1);
			if(tempID == userID)
				arr.add(temp.get(i));
		}
		
		
		temp.clear();
		if(arr.size() > 10){
			for(int i=0; i<10; i++)
				temp.add(arr.get(arr.size()-(i+1)));
			
		}else{
			for(int i=0; i< arr.size(); i++)
				temp.add(arr.get(arr.size()-(i+1)));
		}
		
		return temp;
		
	}
	
	public static String getString(Connection con,String table,
			String column, Object value, String needed_Col){
		String st= getSingleString(con, table, column, value, needed_Col);
			
		return st;
	}


}
