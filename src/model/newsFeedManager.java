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
			Object quizName) {
		String personName = AccountManager.getUser(con, (Integer) userID)
				.getFirstName()
				+ " "
				+ AccountManager.getUser(con, (Integer) userID).getLastName();
		String text = personName + " created Quiz named " + (String) quizName;
		Object[] ar = new Object[] { userID, text };
		insert(con, tableName, "(userID, text)", ar);
		for (int i = 0; i < FriendManager.getFriends(con, (Integer) userID)
				.size(); i++) {
			ar[0] = FriendManager.getFriends(con, (Integer) userID).get(i);
			insert(con, tableName, "(userID,  text)", ar);
		}
	}

	public static void postPlayedQuizNews(Connection con, Object userID,
			Object quizName) {
		String personName = AccountManager.getUser(con, (Integer) userID)
				.getFirstName()
				+ " "
				+ AccountManager.getUser(con, (Integer) userID).getLastName();
		String text = personName + " played Quiz named " + (String) quizName;
		Object[] ar = new Object[] { userID, text };
		insert(con, tableName, "(userID, text)", ar);
		for (int i = 0; i < FriendManager.getFriends(con, (Integer) userID)
				.size(); i++) {
			ar[0] = FriendManager.getFriends(con, (Integer) userID).get(i);
			insert(con, tableName, "(userID,  text)", ar);
		}
	}

	public static void postAchievementNews(Connection con, Object userID,
			Object quizName) {
		String personName = AccountManager.getUser(con, (Integer) userID)
				.getFirstName()
				+ " "
				+ AccountManager.getUser(con, (Integer) userID).getLastName();
		String text = personName + " played Quiz named " + (String) quizName;
		Object[] ar = new Object[] { userID, text };
		insert(con, tableName, "(userID, text)", ar);
		for (int i = 0; i < FriendManager.getFriends(con, (Integer) userID)
				.size(); i++) {
			ar[0] = FriendManager.getFriends(con, (Integer) userID).get(i);
			insert(con, tableName, "(userID,  text)", ar);
		}
	}

}
