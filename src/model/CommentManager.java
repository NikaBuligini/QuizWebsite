package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class CommentManager extends Manager {
	
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	
	static final String COMMENTS_TABLE = "comments";
	static final String COMMENTS_ID = "id";
	static final String COMMENTS_TEXT = "text";
	static final String QUIZ_ID = "quiz_id";
	static final String USER_ID = "user_id";
	static final String DATE = "date";
	static final String COMMENTS_COLUMNS = "(" + COMMENTS_TEXT + ", " + QUIZ_ID + ", " + USER_ID + ", " + DATE + ")";
	static final int COMMENTS_N_COL = 5;
	
	
	public static int add(Connection con, String text, int userId, int quizId){
		int check1 = getSingleInt(con, COMMENTS_TABLE, COMMENTS_TEXT, text, COMMENTS_ID);
		if (check1 != 0)
			return FAILED;
		
		Object[] comment = new Object[COMMENTS_N_COL - 1];
		comment[0] = text;
		comment[1] = userId;
		comment[2] = quizId;
		insert(con, COMMENTS_TABLE, COMMENTS_COLUMNS, comment);		
		return SUCCESS;
	}


	public static ArrayList<Comment> getAll(Connection con) {
		ArrayList<ArrayList<Object>> list = getAllRows(con, COMMENTS_TABLE, COMMENTS_N_COL);
		ArrayList<Comment> result = new ArrayList<Comment>();
		for (ArrayList<Object> arrayList : list) {
			int id = (int) arrayList.get((0));
			String text = (String) arrayList.get((1));
			int quiz_id = (int) arrayList.get((2));
			int user_id = (int) arrayList.get((3));
			Timestamp date = (Timestamp) arrayList.get((4));
			User user = AccountManager.getUser(con, user_id);
			result.add(new Comment(id, text, user, quiz_id, date));
		}
		return result;
	}

}
