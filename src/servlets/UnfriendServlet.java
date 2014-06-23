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

import model.AccountManager;
import model.CookiesManager;
import model.FriendManager;
import model.WebVariables;

/**
 * Servlet implementation class UnfriendServlet
 */
@WebServlet("/unfriend")
public class UnfriendServlet extends HttpServlet implements WebVariables{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String friendID = request.getParameter("fr");
		int friend = Integer.parseInt(friendID);
		
		Cookie user = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
		int userID = AccountManager.getIDByEmail(con, user.getValue());
		
		FriendManager.unfriend(con, userID, friend);
	}

}
