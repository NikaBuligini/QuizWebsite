package model;

public interface WebVariables {
	
	// Tables
	static final String USERS_TABLE = "users";
	static final String USERNAME_COL = "user";
	static final String PASSWORD_COL = "password";
	
	static final String QUESTIONS_TABLE = "questions";
	static final String QUESTION_COL = "Question";
	
	
	// Context Attributes
	static final String CONNECTION = "connection";
	
	
	
	// Column Names
	
	
	// SQL Select Variables
	static final String USERS_COLUMNS = "(user, password)";
	
	
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
	
	static final String REGISTRATION_INFO = "reg_info";
	
	
	// Session Attributes
	static final String CURR_USER = "currUser";
	static final String IS_LOGGED = "logged";
}
