package model;

import java.sql.Connection;
import java.util.ArrayList;

public class AchievementManager extends Manager {
	static ArrayList<Object> arr;
	static String tablename = "achievementsAndUsers";
	static String ACHIEVEMENTS = "achievements";
	static int[] friendsAchievementStages = new int[] { 1, 5, 10 };
	static int[] friendsAchievementStagesIDs = new int[] { 4, 5, 6 };

	private static void fillArray(Connection con, int userID) {
		arr = new ArrayList<>();

		ArrayList<ArrayList<Object>> allRaws = getAllRows(con, tablename, 2);
		for (int i = 0; i < allRaws.size(); i++) {
			int stringID = (int) allRaws.get(i).get(0);
			if (stringID == userID)
				arr.add(allRaws.get(i).get(1));
		}

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
		for (int i = 0; i < friendsAchievementStages.length; i++) {
			if (FriendManager.getFriends(con, userID).size() >= friendsAchievementStages[i]) {
				if (!hasAchievement(con, userID, friendsAchievementStagesIDs[i])) {
					return friendsAchievementStagesIDs[i];
				}
			}
		}
		return -1;
	}
	
	public static int deservesCreatedQuizesAchievement(Connection con, int userID) {
		for (int i = 0; i < friendsAchievementStages.length; i++) {
			if (FriendManager.getFriends(con, userID).size() >= friendsAchievementStages[i]) {
				if (!hasAchievement(con, userID, friendsAchievementStagesIDs[i])) {
					return friendsAchievementStagesIDs[i];
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
		}

	}

	public static ArrayList<ArrayList<Object>> totalAchievements(Connection con) {
		ArrayList<ArrayList<Object>> raws = getAllRows(con, ACHIEVEMENTS, 4);
		return raws;
	}
}