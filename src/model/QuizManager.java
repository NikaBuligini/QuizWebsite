package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.sql.Connection;

public class QuizManager extends Manager {
	static String columns = "(quizName, description, random, correction, onePage, practice, date, creatorID, categoryID)";
	String tableName = "quizzes";
	String quizName;
	String description;
	boolean random;
	boolean correction;
	boolean onePage;
	boolean practice;
	Date dateTime;
	int creatorID;
	int quizID;
	int categoryID;
	static Object[] arr = new Object[9];

	public QuizManager(Quiz qz) {
		this.quizName = qz.getName();
		this.description = qz.getDescription();
		this.random = qz.getRandom();
		this.correction = qz.getCorrection();
		this.onePage = qz.getOnePage();
		this.practice = qz.getPractice();
		this.dateTime = Calendar.getInstance().getTime();
		this.creatorID = qz.getCreatorID();
		this.categoryID = qz.getCategoryID();
		arr[0] = quizName;
		arr[1] = description;
		if (random)
			arr[2] = new Command("true");
		else
			arr[2] = new Command("false");
		if (correction)
			arr[3] = new Command("true");
		else
			arr[3] = new Command("false");
		if (onePage)
			arr[4] = new Command("true");
		else
			arr[4] = new Command("false");
		if (practice)
			arr[5] = new Command("true");
		else
			arr[5] = new Command("false");
		arr[6] = new Command("now()");
		arr[7] = creatorID;
		arr[8] = categoryID;
	}

	public void insertQuiz(Quiz qz, Connection con) {
		insert(con, tableName, columns, arr);
		newsFeedManager.postCreatedQuizNews(con, arr[7], arr[0]);
	}

	public Quiz getQuizByQuizID(Connection con, int quizID) {
		ArrayList<Object> ar = getSingleRow(con, tableName, "ID", quizID, 10);
		Quiz qz = new Quiz((String) ar.get(0), (String) ar.get(1),
				(boolean) ar.get(2), (boolean) ar.get(3), (boolean) ar.get(4),
				(boolean) ar.get(5), (int) ar.get(7), (int) ar.get(8));
		return qz;
	}

	public ArrayList<Quiz> getQuizesByCreatorID(Connection con, int creatorID) {
		ArrayList<ArrayList<Object>> ar = getMultipleRows(con, tableName,
				"creatorID", creatorID, 10);
		ArrayList<Quiz> quizzes = new ArrayList<Quiz>();
		for (int i = 0; i < ar.size(); i++) {
			Quiz qz = new Quiz((String) ar.get(i).get(0), (String) ar.get(i)
					.get(1), (boolean) ar.get(i).get(2), (boolean) ar.get(i)
					.get(3), (boolean) ar.get(i).get(4), (boolean) ar.get(i)
					.get(5), (int) ar.get(i).get(7), (int) ar.get(i).get(8));
			quizzes.add(qz);
		}
		return quizzes;
	}

}