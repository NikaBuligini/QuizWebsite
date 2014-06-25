package model;

import java.sql.Connection;
import java.util.ArrayList;

public class PlayedQuizzes extends Manager {
	static String tableName = "playedQuizzes";
	static String columns = "(quizID, userID, date)";
	static Object[] arr = new Object[3];

	public void insertPlayedQuiz(int quizID, int userID, Connection con) {
		arr[0] = quizID;
		arr[1] = userID;
		arr[3] = new Command("now()");
		insert(con, tableName, columns, arr);
	}

	public static ArrayList<Integer> getPlayedQuizzesByUserID(int userID,
			Connection con) {
		ArrayList<ArrayList<Object>> ar = getMultipleRows(con, tableName,
				"userID", userID, 2);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < ar.size(); i++) {
			res.add((Integer) ar.get(i).get(1));
		}
		return res;
	}
}
