package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.CookiesManager;
import model.WebVariables;

/**
 * Servlet implementation class LogOutServlet
 */
@WebServlet("/logout")
public class LogOutServlet extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		Cookie remember = CookiesManager.getCookie(request, COOKIE_REMEMBER_ME);
		if (remember != null){
			CookiesManager.deleteRememberMe(con, remember.getValue());
			remember.setValue(null);
			remember.setMaxAge(0);
			response.addCookie(remember);
		}
		
		Cookie logged = CookiesManager.getCookie(request, COOKIE_LOGGED_IN);
		if (logged != null){
			logged.setValue(null);
			logged.setMaxAge(0);
			response.addCookie(logged);
		}
		
		Cookie user = CookiesManager.getCookie(request, COOKIE_USERNAME);
		if (user != null){
			user.setValue(null);
			user.setMaxAge(0);
			response.addCookie(user);
		}
		
		response.sendRedirect("/QuizWebsite/login");
	}

}
