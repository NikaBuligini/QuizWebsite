package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class AccountManager extends Manager {
	
	public static final int FAILED = 0;
	public static final int SUCCESS = 1;
	
	static final String USERS_TABLE = "users";
	static final String USERS_ID_C = "ID";
	static final String USERS_EMAIL_C = "email";
	static final String USERS_PASSWORD_C = "pass";
	static final String USERS_COLUMNS = "(" + USERS_EMAIL_C + ", " + USERS_PASSWORD_C + ")";
	static final int USERS_N_COL = 3;
	
	static final String INFO_TABLE = "additional_info";
	static final String INFO_USER_ID_C = "userID";
	static final String INFO_FIRSTNAME_C = "firstName";
	static final String INFO_LASTNAME_C = "lastName";
	static final String INFO_GENDER_C = "gender";
	static final String INFO_QUESTION_C = "questionID";
	static final String INFO_ANSWER_C = "answer";
	static final String INFO_IMAGE_C = "image";
	static final String INFO_COLUMNS = "(" + INFO_USER_ID_C + ", " + INFO_FIRSTNAME_C + ", " 
			+ INFO_LASTNAME_C + ", " + INFO_GENDER_C + ", " + INFO_QUESTION_C + ", " + INFO_ANSWER_C 
			+ ", " + INFO_IMAGE_C + ")";
	static final int INFO_N_COL = 7;
	
	static final String DEFAULT_IMAGE = "default.png";
	
	
	public static int add(Connection con, String email, String password, User e){
		int check1 = getSingleInt(con, USERS_TABLE, USERS_EMAIL_C, email, USERS_ID_C);
		if (check1 != 0)
			return FAILED;
		
		Object[] user = new Object[USERS_N_COL - 1];
		user[0] = email;
		user[1] = password;
		insert(con, USERS_TABLE, USERS_COLUMNS, user);
		
		int ID = getSingleInt(con, USERS_TABLE, USERS_EMAIL_C, email, USERS_ID_C);
		Object[] userInfo = new Object[INFO_N_COL];
		userInfo[0] = ID;
		userInfo[1] = e.getFirstName();
		userInfo[2] = e.getLastName();
		userInfo[3] = e.getGenderID();
		userInfo[4] = e.getQuestionID();
		userInfo[5] = e.getAnswer();
		userInfo[6] = e.getImage();
		insert(con, INFO_TABLE, INFO_COLUMNS, userInfo);
		
		return SUCCESS;
	}
	
	
	
	public static boolean contains(Connection con, String email, String password){
		String pass = getSingleString(con, USERS_TABLE, USERS_EMAIL_C, email, USERS_PASSWORD_C);
		
		if (pass == null)
			return false;
		
		if (password.equals(pass))
			return true;
		return false;
	}
	
	
	
	public static int getIDByEmail(Connection con, String email){
		return getSingleInt(con, USERS_TABLE, USERS_EMAIL_C, email, USERS_ID_C);
	}
	
	
	public static User getUser(Connection con, String email){
		int id = getIDByEmail(con, email);
		return getUser(con, id);
	}
	
	
	public static User getUser(Connection con, int id){
		ArrayList<Object> row = getSingleRow(con, INFO_TABLE, INFO_USER_ID_C, id, INFO_N_COL);
		if (row == null || row.size() == 0)
			return null;
		
		String firstname = (String)row.get(1);
		String lastname = (String)row.get(2);
		int genderID = (int)row.get(3);
		int questionID = (int)row.get(4);
		String answer = (String)row.get(5);
		String image = (String)row.get(6);
		
		
		User e = new User(firstname, lastname, genderID, questionID, answer, image);
		e.setID(id);
		return e;
	}
	
	
	public static String getEmail(Connection con, int ID){
		return getSingleString(con, USERS_TABLE, USERS_ID_C, ID, USERS_EMAIL_C);
	}
	
	
	public static String getpassword(Connection con, int ID){
		return getSingleString(con, USERS_TABLE, USERS_ID_C, ID, USERS_PASSWORD_C);
	}
	
	
	public static String[] getRecovery(Connection con, String emailOrUsername){
		int id = getIDByEmail(con, emailOrUsername);
		if (id == 0)
			return null;
		
		ArrayList<Object> infoRow = getSingleRow(con, INFO_TABLE, INFO_USER_ID_C,
				id, INFO_N_COL);
		ArrayList<Object> userRow = getSingleRow(con, USERS_TABLE, USERS_ID_C, id, USERS_N_COL);
		
		String[] list = new String[4];
		
		list[0] = QuestionManager.getQuestion(con, (int)infoRow.get(4));
		list[1] = (String)infoRow.get(5);
		list[2] = (String)userRow.get(1);
		list[3] = (String)userRow.get(2);
		
		return list;
	}
	
	
	public static ArrayList<User> search(Connection con, String text) {
		if (text == null || text.equals(""))
			return null;
		
		String SQLQuery = buildSpecialSelect(text);
		
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = con.createStatement();
			rs = stmt.executeQuery(SQLQuery);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		HashSet<Integer> users = new HashSet<Integer>();
		try {
			while (rs.next()){
				users.add((int)rs.getInt(1));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		
		ArrayList<User> result = new ArrayList<User>();
		Iterator<Integer> it = users.iterator();
		while (it.hasNext()) {
			result.add(getUser(con, it.next()));
		}
		
		return result;
	}
	
		
	
	private static String buildSpecialSelect(String text) {
		return "SELECT * FROM " + INFO_TABLE + " WHERE concat(" + INFO_FIRSTNAME_C + ", ' ', " +
				INFO_LASTNAME_C + ") Like '%" + text + "%' OR concat(" + INFO_LASTNAME_C + ", ' ', " +
				INFO_FIRSTNAME_C + ") Like '%" + text + "%'";
	}
	
}
