package model;

import java.util.ArrayList;
import java.util.Random;
import java.sql.Connection;

public class PlayQuiz extends Manager {
	static String tableName = "quizzes";

	public int getRandomQuizIDForCategoryID(Connection con, int categoryID) {
		ArrayList<ArrayList<Object>> ar = getMultipleRows(con, tableName,
				"categoryID", categoryID, 9);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < ar.size(); i++) {
			res.add((Integer) ar.get(i).get(8));
		}
		Random rd = new Random();
		return res.get(rd.nextInt(res.size() - 1));
	}

	public int getRandomQuizID(Connection con) {
		ArrayList<ArrayList<Object>> ar = getAllRows(con, tableName, 9);
		ArrayList<Integer> res = new ArrayList<Integer>();
		for (int i = 0; i < ar.size(); i++) {
			res.add((Integer) ar.get(i).get(8));
		}
		Random rd = new Random();
		return res.get(rd.nextInt(res.size() - 1));
	}
}
