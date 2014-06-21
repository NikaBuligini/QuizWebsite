package model;

public interface WebVariables {
	
	// Context Attributes
	static final String CONNECTION = "connection";
	
	
	// Request Parameters
	static final String PERSISTENT = "persistent";
	
	static final String REGISTRATION_INFO = "reg_info";
	static final String SIGNIN_INFO = "sign_info";
	
	static final int MALE = 1;
	static final int FEMALE = 2;
	
	static final String SEARCH = "search";
	static final String SEARCH_RESULTS = "s_res";
	
	static final String VIEW = "p";
	
	
	// Session Attributes
	static final String COOKIE_REMEMBER_ME = "_hash";
	static final String COOKIE_USER = "_user";
	static final String COOKIE_LOGGED_IN = "logged_in";
	
	// JSP
	static final String JSP_LOGIN = "/JSP/Start/login.jsp";
	static final String JSP_SIGN_UP = "/JSP/Start/sign-up.jsp";
	static final String JSP_PROFILE = "/JSP/Profile/profile.jsp";
	static final String JSP_SEARCH = "/JSP/Profile/search.jsp";
	static final String JSP_VIEW = "/JSP/Profile/view.jsp";
	static final String JSP_NOTIFICATIONS = "/JSP/Profile/notifications.jsp";
	
}
