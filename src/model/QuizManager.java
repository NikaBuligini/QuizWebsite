package model;

import java.util.ArrayList;
import java.sql.Connection;

public class QuizManager extends Manager {
	static String columns = "(quizName, description, random, correction, onePage, date, creatorID, categoryID)";
	static String tableName = "quizzes";

	public static void insert(Quiz qz, Connection con) {
		Object[] arr = new Object[8];
		arr[0] = qz.getName();
		arr[1] = qz.getDescription();
		if (qz.getRandom())
			arr[2] = new Command("true");
		else
			arr[2] = new Command("false");
		if (qz.getCorrection())
			arr[3] = new Command("true");
		else
			arr[3] = new Command("false");
		if (qz.getOnePage())
			arr[4] = new Command("true");
		else
			arr[4] = new Command("false");
		arr[5] = new Command("now()");
		arr[6] = qz.getCreatorID();
		arr[7] = qz.getCategoryID();
		
		insert(con, tableName, columns, arr);
//		newsFeedManager.postCreatedQuizNews(con, arr[6], arr[0]);
	}

	public static Quiz getQuizByQuizID(Connection con, int quizID) {
		ArrayList<Object> ar = getSingleRow(con, tableName, "ID", quizID, 10);
		Quiz qz = new Quiz((String) ar.get(0), (String) ar.get(1),
				(boolean) ar.get(2), (boolean) ar.get(3), (boolean) ar.get(4),
				(int) ar.get(6), (int) ar.get(7));
		return qz;
	}

	public ArrayList<Quiz> getQuizesByCreatorID(Connection con, int creatorID) {
		ArrayList<ArrayList<Object>> ar = getMultipleRows(con, tableName,
				"creatorID", creatorID, 10);
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		for (int i = 0; i < ar.size(); i++) {
			Quiz qz = new Quiz((String) ar.get(i).get(0), (String) ar.get(i)
					.get(1), (boolean) ar.get(i).get(2), (boolean) ar.get(i)
					.get(3), (boolean) ar.get(i).get(4),
					(int) ar.get(i).get(6), (int) ar.get(i).get(7));
			quizzes.add(qz);
		}
		return quizzes;
	}

}