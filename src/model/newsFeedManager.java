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


}
