package servlets;

import java.io.IOException;
import java.net.CookieManager;
import java.sql.Connection;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.CookiesManager;
import model.User;
import model.WebVariables;

/**
 * Servlet implementation class RemoveAccountServlet
 */
@WebServlet("/removeAccount")
public class RemoveAccountServlet extends HttpServlet implements WebVariables  {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		User currUser = (User) (request.getSession().getAttribute("user"));
		
		
		
		Cookie User = CookiesManager.getCookie(request, COOKIE_USER);
		User.setMaxAge(0);
		Cookie logged = CookiesManager.getCookie(request, COOKIE_LOGGED_IN);
		logged.setMaxAge(0);
		
		
		String email=AccountManager.getEmail(con, currUser.getID());
		String password=AccountManager.getpassword(con, currUser.getID());
		AccountManager.remove(con, email, password, currUser);
		
	}

}
