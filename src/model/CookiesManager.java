package model;

import java.io.IOException;
import java.rmi.server.UID;
import java.sql.Connection;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookiesManager extends Manager implements WebVariables {
	
	static final String TABLE = "cookies";
	static final String VALUE_C = "cookie_value";
	static final String USER_ID_C = "userID";
	static final int N_COL = 2;
	static final String COLUMNS = "(" + VALUE_C + ", " + USER_ID_C + ")";
	
	static final int REMEMBER_ME_MAX_AGE = 7*24*60*60;	// erti kvira
	static final int USERNAME_MAX_AGE = -1;				// sessiis ganmavlobashi
	
	
	public static int getUserID(Connection con, String value){
		return getSingleInt(con, TABLE, VALUE_C, value, USER_ID_C);
	}
	
	
	public static String getValue(Connection con, int userID){
		return getSingleString(con, TABLE, USER_ID_C, userID, VALUE_C);
	}
	
	
	public static boolean contains(Connection con, String value){
		int result = getSingleInt(con, TABLE, VALUE_C, value, USER_ID_C);
		return result != 0;
	}
	
	
	public static Cookie createRememberMe(Connection con, String email){
		Cookie result = null;
		int userID = AccountManager.getIDByEmail(con, email);
		String value = getValue(con, userID);
		UID cookieCode = new UID();
		
		if (value == null)
			insert(con, cookieCode.toString(), userID);
		else
			update(con, cookieCode.toString(), userID);
		
		result = new Cookie(COOKIE_REMEMBER_ME, cookieCode.toString());
		result.setMaxAge(REMEMBER_ME_MAX_AGE);
		
		return result;
	}
	
	
	public static void deleteRememberMe(Connection con, String value){
		delete(con, TABLE, VALUE_C, value);
	}
	
	
	public static Cookie createUsernameCookie(Connection con, String username){
		Cookie result = new Cookie(COOKIE_USERNAME, username);
		result.setMaxAge(USERNAME_MAX_AGE);
		
		return result;
	}
	
	
	public static Cookie createLoggedIn(){
		Cookie result = new Cookie(COOKIE_LOGGED_IN, "yes");
		result.setMaxAge(USERNAME_MAX_AGE);
		
		return result;
	}
	
	
	public static Cookie getCookie(HttpServletRequest request, String name){
		if (request.getCookies() != null){
			for (Cookie c : request.getCookies()){
				if (c.getName().equals(name)){
					return c;
				}
			}
		}
		return null;
	}
	
	
	public static boolean cookieRedirect(HttpServletRequest request, HttpServletResponse response,
			Connection con) throws IOException{
		Cookie logged = CookiesManager.getCookie(request, COOKIE_LOGGED_IN);
		if (logged != null && logged.getValue().equals("yes")){
			response.sendRedirect("profile");
			return true;
		}
		
		Cookie c = CookiesManager.getCookie(request, COOKIE_REMEMBER_ME);
		if (c != null && CookiesManager.contains(con, c.getValue())){
			int id = CookiesManager.getUserID(con, c.getValue());
			String username = AccountManager.getEmail(con, id);
			
			response.addCookie(CookiesManager.createUsernameCookie(con, username));
			response.addCookie(CookiesManager.createLoggedIn());
			
			response.sendRedirect("profile");
			return true;
		}
		return false;
	}
	
	
	private static void insert(Connection con, String value, int userID){
		Object[] values = new Object[N_COL];
		values[0] = value;
		values[1] = userID;
		
		insert(con, TABLE, COLUMNS, values);
	}
	
	private static void update(Connection con, String value, int userID){
		update(con, TABLE, VALUE_C, value, USER_ID_C, userID);
	}
	
}
