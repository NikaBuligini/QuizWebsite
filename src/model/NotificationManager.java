package model;

import java.sql.Connection;
import java.util.ArrayList;

public class NotificationManager {
	
	
	public static ArrayList<Notification> getNotifications(Connection con, int userID) {
		ArrayList<Notification> result = new ArrayList<Notification>();
		
		result.addAll(FriendManager.getNotifications(con, userID));
		// challenges
		
		return result;
	}
	
	
	public static void accept(Connection con, int ID, boolean isChallenge) {
		Notification e = null;
		if (isChallenge) {
			
		} else
			e = FriendManager.getRequest(con, ID);
		
		if (isChallenge) {
			
		} else {
			FriendManager.makeFriends(con, e);
		}
	}
	
	
	public static void decline(Connection con, int ID, boolean isChallenge) {
		Notification e = null;
		if (isChallenge) {
			
		} else
			e = FriendManager.getRequest(con, ID);
		
		if (isChallenge) {
			
		} else {
			FriendManager.deleteRequest(con, e);;
		}
	}
	
	
}
