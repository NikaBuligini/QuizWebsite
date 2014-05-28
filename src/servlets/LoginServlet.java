package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountManager;
import model.SQLManager;
import model.WebVariables;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		String logged = (String) session.getAttribute(IS_LOGGED);
		if (logged != null)
			response.sendRedirect("profile");
		
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			for (Cookie c : cookies) {
				if (c.getName().equals(COOKIE_NAME)) {
					if (SQLManager.containsCookie(con, c.getValue())){
						session.setAttribute(IS_LOGGED, c.getValue());
						response.sendRedirect("profile");
					}
				}
			}
		}
		
		logged = (String) session.getAttribute(IS_LOGGED);
		if (logged == null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		
		AccountManager manager = new AccountManager();
		boolean contains = manager.contains(con, username, password);
		if (contains){
			String persistent = request.getParameter(PERSISTENT);
			if (persistent != null) {
				Cookie c = createCookie(con, username);
				c.setMaxAge(60*60);
				response.addCookie(c);
			}
			HttpSession session = request.getSession();
			session.setAttribute(IS_LOGGED, "yes");
			
			response.sendRedirect("profile");
		} else {
			// info rom ragac arasworia
			request.setAttribute(WebVariables.SIGNIN_INFO, "Username or password is incorrect.");
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}
	
	
	//shesadzlebloba iqneba ori kompiuteridan ert usernamestvis gaketdes cookie
	private Cookie createCookie(Connection con, String username){
		Cookie c = null;
		int userID = SQLManager.getUserIDByUsername(con, username);
		String value = SQLManager.getCookieByUserID(con, userID);
		if (value == null) {
			// insert
			UUID cookieCode = UUID.randomUUID();
			value = String.valueOf(cookieCode);
			SQLManager.addCookie(con, value, userID);
		} else {
			// update
			SQLManager.updateCookie(con, value, userID);
		}
		c = new Cookie(COOKIE_NAME, value);
		return c;
	}
	
}
