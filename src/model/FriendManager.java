package model;

import java.sql.Connection;
import java.util.ArrayList;

public class FriendManager extends Manager{
	
	// friends table
	static final String FRIENDS_TABLE = "friends";
	static final String FRIENDS_USER_C = "userID";
	static final String FRIENDS_FRIEND_C = "friendID";
	static final String FRIENDS_COLUMNS = "(" + FRIENDS_USER_C + ", " + FRIENDS_FRIEND_C + ")";
	static final int FRIENDS_N_COL = 2;
	
	
	// request table
	static final String REQUEST_TABLE = "friendRequest";
	static final String REQUEST_ID = "ID";
	static final String REQUEST_FROM = "fromID";
	static final String REQUEST_TO = "toID";
	static final String REQUEST_COLUMNS = "(" + REQUEST_FROM + ", " + REQUEST_TO + ")";
	static final int REQUEST_N_COL = 3;
	
	
	public static int sendRequest(Connection con, int from, int to) {
		Object[] values = new Object[REQUEST_N_COL-1];
		values[0] = from;
		values[1] = to;
		
		if (insert(con, REQUEST_TABLE, REQUEST_COLUMNS, values) == SUCCESS)
			return SUCCESS;
		else 
			return FAILED;
	}
	
	public static int getRequestID(Connection con, int from, int to) {
		ArrayList<ArrayList<Object>> list = getMultipleRows(con, REQUEST_TABLE, REQUEST_FROM, from, REQUEST_N_COL);
		
		for (int i=0; i<list.size(); i++){
			if ((int)list.get(i).get(2) == to)
				return (int)list.get(i).get(0);
		}
		
		return 0;
	}
	
	private static void deleteRequest(Connection con, int id){
		delete(con, REQUEST_TABLE, REQUEST_ID, id);
	}
	
	public static void makeFriends(Connection con, int from, int to) {
		int id = getRequestID(con, from, to);
		if (id == 0)
			return;
		
		Object[] values = new Object[FRIENDS_N_COL];
		values[0] = from;
		values[1] = to;
		
		insert(con, FRIENDS_TABLE, FRIENDS_COLUMNS, values);
		deleteRequest(con, id);
	}
	
	public static ArrayList<Integer> getFriends(Connection con, int userID) {
		ArrayList<ArrayList<Object>> list = getMultipleRows(con, FRIENDS_TABLE, FRIENDS_USER_C, userID, FRIENDS_N_COL);
		
		ArrayList<Integer> result = new ArrayList<Integer>();
		for (int i=0; i<list.size(); i++){
			result.add((Integer)list.get(i).get(1));
		}
		
		return result;
	}
	
	public static boolean areFriends(Connection con, int from, int to) {
		ArrayList<Integer> friends = getFriends(con, from);
		
		for(int i=0; i<friends.size(); i++){
			if (friends.get(i) == to)
				return true;
		}
		
		return false;
	}
	
	
	public static ArrayList<Object[]> getRequests(Connection con, int userID) {
		ArrayList<ArrayList<Object>> list = getMultipleRows(con, REQUEST_TABLE, REQUEST_TO, userID, REQUEST_N_COL);
		
		ArrayList<Object[]> result = new ArrayList<Object[]>();
		for (int i=0; i<list.size(); i++) {
			Object[] request = new Object[2];
			request[0] = list.get(i).get(1);
			request[1] = list.get(i).get(2);
			
			result.add(request);
		}
		return result;
	}
	
	
	public static int getRequestCount(Connection con, int userID) {
		return getRequests(con, userID).size();
	}
}
