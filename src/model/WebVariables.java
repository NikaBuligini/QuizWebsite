package model;

public interface WebVariables {
	
	// Tables
	static final String USERS_TABLE = "users";
	static final String USERNAME_COL = "userName";
	static final String PASSWORD_COL = "pass";
	
	static final String USER_INFO_TABLE = "additional_info";
	static final String INFO_USER_ID_COL = "userID";
	static final String INFO_EMAIL_COL = "email";
	static final String INFO_FIRSTNAME_COL = "firstName";
	static final String INFO_LASTNAME_COL = "lastName";
	static final String INFO_BIRTHDAY_COL = "birthday";
	static final String INFO_GENDER_COL = "gender";
	static final String INFO_QUESTION_COL = "questionID";
	static final String INFO_ANSWER_COL = "answer";
	
	static final String SEQ_QUESTIONS_TABLE = "security_questions";
	static final String SEQ_QUESTION_COL = "question";
	
	static final String COOKIES_TABLE = "cookies";
	static final String COOKIES_VALUE_COL = "cookie_value";
	static final String COOKIES_USER_COL = "userID";
	
	
	// Context Attributes
	static final String CONNECTION = "connection";
	
	
	
	// Column Names
	
	
	// SQL Select Variables
	static final String USERS_COLUMNS = "(" + USERNAME_COL + ", " + PASSWORD_COL + ")";
	static final String SEQ_QUESTIONS_COLUMNS = "(" + SEQ_QUESTION_COL + ")";
	static final String INFO_COLUMNS = "(" + INFO_USER_ID_COL + ", " + INFO_EMAIL_COL + ", " 
			+ INFO_FIRSTNAME_COL + ", " + INFO_LASTNAME_COL + ", " + INFO_BIRTHDAY_COL + ", "
			+ INFO_GENDER_COL + ", " + INFO_QUESTION_COL + ", " + INFO_ANSWER_COL + ")";
	static final String COOKIES_COLUMNS = "(" + COOKIES_VALUE_COL + ", " + COOKIES_USER_COL + ")";
	
	
	
	// Request Parameters
	static final String USERNAME = "user";
	static final String PASSWORD = "pass";
	static final String FIRSTNAME = "fname";
	static final String LASTNAME = "lname";
	static final String BIRTHDAY = "bday";
	static final String EMAIL = "email";
	static final String GENDER = "gender";
	static final String QUESTION = "question";
	static final String ANSWER = "answer";
	
	static final String PASS1 = "pass1";
	static final String PASS2 = "pass2";
	
	static final String PERSISTENT = "persistent";
	
	static final String REGISTRATION_INFO = "reg_info";
	static final String SIGNIN_INFO = "sign_info";
	
	
	// Session Attributes
	static final String CURR_USER = "currUser";
	static final String IS_LOGGED = "logged";
	
	static final String COOKIE_NAME = "QuizWebsite";
}
