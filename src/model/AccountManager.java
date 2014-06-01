package model;

import java.sql.Connection;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class AccountManager extends Manager {
	
	public static final int FAILED = 0;
	public static final int USED_EMAIL = 1;
	public static final int SUCCESS = 2;
	
	static final String USERS_TABLE = "users";
	static final String USERS_ID_C = "ID";
	static final String USERS_USERNAME_C = "userName";
	static final String USERS_PASSWORD_C = "pass";
	static final String USERS_COLUMNS = "(" + USERS_USERNAME_C + ", " + USERS_PASSWORD_C + ")";
	static final int USERS_N_COL = 3;
	
	static final String INFO_TABLE = "additional_info";
	static final String INFO_USER_ID_C = "userID";
	static final String INFO_EMAIL_C = "email";
	static final String INFO_FIRSTNAME_C = "firstName";
	static final String INFO_LASTNAME_C = "lastName";
	static final String INFO_BIRTHDAY_C = "birthday";
	static final String INFO_GENDER_C = "gender";
	static final String INFO_QUESTION_C = "questionID";
	static final String INFO_ANSWER_C = "answer";
	static final String INFO_COLUMNS = "(" + INFO_USER_ID_C + ", " + INFO_EMAIL_C + ", " 
			+ INFO_FIRSTNAME_C + ", " + INFO_LASTNAME_C + ", " + INFO_BIRTHDAY_C + ", "
			+ INFO_GENDER_C + ", " + INFO_QUESTION_C + ", " + INFO_ANSWER_C + ")";
	static final int INFO_N_COL = 8;
	
	static final String DATE_FORMAT = "yyyy/MM/dd";
	
	
	public static int add(Connection con, String username, String password, User e){
		int check1 = getSingleInt(con, USERS_TABLE, USERS_USERNAME_C, username, USERS_ID_C);
		if (check1 != 0)
			return FAILED;
		
		Object[] user = new Object[USERS_N_COL - 1];
		user[0] = username;
		user[1] = password;
		insert(con, USERS_TABLE, USERS_COLUMNS, user);
		
		int check2 = getSingleInt(con, INFO_TABLE, INFO_EMAIL_C, e.getEMail(), INFO_USER_ID_C);
		if (check2 != 0)
			return USED_EMAIL;
		
		int ID = getSingleInt(con, USERS_TABLE, USERS_USERNAME_C, username, USERS_ID_C);
		
		Object[] userInfo = new Object[INFO_N_COL];
		userInfo[0] = ID;
		userInfo[1] = e.getEMail();
		userInfo[2] = e.getFirstName();
		userInfo[3] = e.getLastName();
		userInfo[4] = e.getBirthday();
		userInfo[5] = e.getGenderID();
		userInfo[6] = e.getQuestionID();
		userInfo[7] = e.getAnswer();
		insert(con, INFO_TABLE, INFO_COLUMNS, userInfo);
		
		return SUCCESS;
	}
	
	
	public static boolean contains(Connection con, String username, String password){
		String pass = getSingleString(con, USERS_TABLE, USERS_USERNAME_C, username, USERS_PASSWORD_C);
		
		if (pass == null)
			return false;
		
		if (password.equals(pass))
			return true;
		return false;
	}
	
	
	public static int getIDByUsername(Connection con, String username){
		return getSingleInt(con, USERS_TABLE, USERS_USERNAME_C, username, USERS_ID_C);
	}
	
	
	public static int getIDByEmail(Connection con, String email){
		return getSingleInt(con, USERS_TABLE, USERS_USERNAME_C, email, USERS_ID_C);
	}
	
	
	public static User getUser(Connection con, String username){
		int id = getIDByUsername(con, username);
		if (id == 0)
			return null;
		
		ArrayList<Object> row = getSingleRow(con, INFO_TABLE, INFO_USER_ID_C, id, INFO_N_COL);
		if (row == null)
			return null;
		
		DateFormat df = new SimpleDateFormat(DATE_FORMAT);
		
		String email = (String)row.get(1);
		String firstname = (String)row.get(2);
		String lastname = (String)row.get(3);
		String birthday = df.format((Date)row.get(4));
		int genderID = (int)row.get(5);
		int questionID = (int)row.get(6);
		String answer = (String)row.get(7);
		
		User e = new User(email, firstname, lastname, birthday, genderID, questionID, answer);
		return e;
	}
	
	
	public static String getUsername(Connection con, int ID){
		return getSingleString(con, USERS_TABLE, USERS_ID_C, ID, USERS_USERNAME_C);
	}
	
	
	public static String[] getRecovery(Connection con, String emailOrUsername){
		int id = getIDByUsername(con, emailOrUsername);
		if (id == 0)
			id = getIDByEmail(con, emailOrUsername);
		
		if (id == 0)
			return null;
		
		ArrayList<Object> infoRow = getSingleRow(con, INFO_TABLE, INFO_USER_ID_C,
				id, INFO_N_COL);
		ArrayList<Object> userRow = getSingleRow(con, USERS_TABLE, USERS_ID_C, id, USERS_N_COL);
		
		String[] list = new String[4];
		
		list[0] = QuestionManager.getQuestion(con, (int)infoRow.get(6));
		list[1] = (String)infoRow.get(7);
		list[2] = (String)userRow.get(1);
		list[3] = (String)userRow.get(2);
		
		return list;
	}
	
}
