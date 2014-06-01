package model;

public interface WebVariables {
	
	// Context Attributes
	static final String CONNECTION = "connection";
	
	
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
	
	static final int MALE = 1;
	static final int FEMALE = 2;
	
	
	// Session Attributes
	static final String COOKIE_REMEMBER_ME = "_hash";
	static final String COOKIE_USERNAME = "_user";
	static final String COOKIE_LOGGED_IN = "logged_in";
	
	// JSP
	static final String JSP_LOGIN = "/JSP/Start/login.jsp";
	static final String JSP_SIGN_UP = "/JSP/Start/sign-up.jsp";
	static final String JSP_PROFILE = "/JSP/Profile/profile.jsp";
	
	// Servlet
	static final String SERVLET_PROFILE = "/QuizWebsite/profile";
}
