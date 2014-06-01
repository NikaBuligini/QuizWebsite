package model;

import java.sql.Connection;
import java.util.ArrayList;

public class QuestionManager extends Manager {
	
	static final String TABLE = "security_questions";
	static final String ID_C = "ID";
	static final String QUESTIONS_C = "question";
	static final String COLUMNS = "(" + QUESTIONS_C + ")";
	static final int N_COL = 2;
	
	public static ArrayList<String> getAll(Connection con){
		ArrayList<ArrayList<Object>> list = getAllRows(con, TABLE, N_COL);
		
		ArrayList<String> result = new ArrayList<String>();
		for (int i=0; i<list.size(); i++)
			result.add((String)list.get(i).get(1));
		
		return result;
	}
	
	
	public static int getID(Connection con, String question){
		return getSingleInt(con, TABLE, QUESTIONS_C, question, ID_C);
	}
	
	
	public static String getQuestion(Connection con, int ID){
		return getSingleString(con, TABLE, ID_C, ID, QUESTIONS_C);
	}
	
}
