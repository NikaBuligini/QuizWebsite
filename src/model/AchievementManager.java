package model;

import java.sql.Connection;
import java.util.ArrayList;

public class AchievementManager extends Manager {
	static ArrayList<Object> arr;
	static String tablename = "achievementsAndUsers";
	static String ACHIEVEMENTS = "achievements";
	static int[] achievementStages = new int[] { 1, 5, 10 };
	static int[] createdQuizesAchievementStagesIDs = new int[] { 1, 2, 3 };
	static int[] friendsAchievementStagesIDs = new int[] { 4, 5, 6 };
	static int[] playedQuizesAchievementStagesIDs = new int[] { 4, 5, 6 };

	private static void fillArray(Connection con, int userID) {
		arr = getAllRowsByID(con, tablename, userID, 2);

	}

	public static int numOfAchievements(Connection con, int userID) {
		fillArray(con, userID);
		return arr.size();
	}

	public static ArrayList<Object> getAchievements(Connection con, int userID) {
		fillArray(con, userID);
		return arr;
	}

	public static boolean hasAchievement(Connection con, int userID,
			int achievementID) {
		fillArray(con, userID);
		for (int i = 0; i < arr.size(); i++) {
			if ((Integer) arr.get(i) == (achievementID))
				return true;
		}
		return false;
	}

	public static int deservesFriendsAchievement(Connection con, int userID) {
		for (int i = 0; i < achievementStages.length; i++) {
			if (FriendManager.getFriends(con, userID).size() >= achievementStages[i]) {
				if (!hasAchievement(con, userID, friendsAchievementStagesIDs[i])) {
					return friendsAchievementStagesIDs[i];
				}
			}
		}
		return -1;
	}

	public static int deservesCreatedQuizesAchievement(Connection con,
			int userID) {
		for (int i = 0; i < achievementStages.length; i++) {
			if (AccountManager.getSingleColumn(con, "quizzesandusers", userID,
					2).size() >= achievementStages[i]) {
				if (!hasAchievement(con, userID,
						createdQuizesAchievementStagesIDs[i])) {
					return createdQuizesAchievementStagesIDs[i];
				}
			}
		}
		return -1;
	}

	public static int deservesPlayedQuizesAchievement(Connection con, int userID) {
		for (int i = 0; i < achievementStages.length; i++) {
			if (AccountManager.getSingleColumn(con, "usersAndMadeQuizes",
					userID, 2).size() >= achievementStages[i]) {
				if (!hasAchievement(con, userID,
						playedQuizesAchievementStagesIDs[i])) {
					return playedQuizesAchievementStagesIDs[i];
				}
			}
		}
		return -1;
	}

	public static void addFriendsAchievement(Connection con, int userID) {
		int achievementID = deservesFriendsAchievement(con, userID);
		if (achievementID != -1) {
			Object[] arr = new Object[] { userID, achievementID };
			insert(con, tablename, "(userID, achievementID)", arr);
			insertIntoNewsFeed(con,userID,achievementID);
		}
	}

	public static void addCreatedQuizesAchievement(Connection con, int userID) {
		int achievementID = deservesCreatedQuizesAchievement(con, userID);
		if (achievementID != -1) {
			Object[] arr = new Object[] { userID, achievementID };
			insert(con, tablename, "(userID, achievementID)", arr);
			insertIntoNewsFeed(con,userID,achievementID);
		}
	}

	public static void addPlayedQuizesAchievement(Connection con, int userID) {
		int achievementID = deservesPlayedQuizesAchievement(con, userID);
		if (achievementID != -1) {
			Object[] arr = new Object[] { userID, achievementID };
			insert(con, tablename, "(userID, achievementID)", arr);
			insertIntoNewsFeed(con,userID,achievementID);
		}
	}

	private static void insertIntoNewsFeed(Connection con, int userID,
			int achievementID) {
		String text = " achieved ";
		String columns = "(userID,text,subjectID,objectID)";
		Object[] values = new Object[4];
		values[3] = achievementID;
		values[2] = userID;
		values[1] = text;
		insert(con, "newsFeed", columns, values);

	}



	public static ArrayList<ArrayList<Object>> totalAchievements(Connection con) {
		ArrayList<ArrayList<Object>> raws = getAllRows(con, ACHIEVEMENTS, 4);
		return raws;
	}
}