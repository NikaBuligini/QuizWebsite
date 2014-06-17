package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.CookiesManager;
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
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		if (CookiesManager.cookieRedirect(request, response, con))
			return;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_LOGIN);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String email = request.getParameter("email");
		String password = request.getParameter("passwd");
		
		boolean contains = AccountManager.contains(con, email, password);
		if (contains){
			String persistent = request.getParameter(PERSISTENT);
			if (persistent != null) {
				Cookie c = CookiesManager.createRememberMe(con, email);
				response.addCookie(c);
			}
			response.addCookie(CookiesManager.createUsernameCookie(con, email));
			response.addCookie(CookiesManager.createLoggedIn());
			
			response.sendRedirect("profile");
		} else {
			request.setAttribute(WebVariables.SIGNIN_INFO, "Username or password is incorrect.");
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_LOGIN);
			dispatcher.forward(request, response);
		}
	}
	
}
