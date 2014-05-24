package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AccountManager;
import model.DBConnection;
import model.User;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String USER_NAME = "user";
	private static final String PASSWORD_NAME = "pass";
	private static final String CURR_USER = "currUser";
	private static final String IS_LOGGED = "logged";
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		boolean isLogged = (boolean) session.getAttribute(IS_LOGGED);
		if (isLogged){
			response.sendRedirect("/profile");
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		DBConnection db = (DBConnection) context.getAttribute(ServletListener.CONNECTION);
		
		String username = request.getParameter(USER_NAME);
		String password = request.getParameter(PASSWORD_NAME);
		
		AccountManager manager = new AccountManager();
		boolean contains = manager.contains(db.getConnection(), username, password);
		if (contains){
			HttpSession session = request.getSession();
			User curr = manager.getUser(username);
			session.setAttribute(CURR_USER, curr);
			session.setAttribute(IS_LOGGED, true);
			
			response.sendRedirect("profile");
		} else {
			// info rom ragac arasworia
			RequestDispatcher dispatcher = request.getRequestDispatcher("failed.html");
			dispatcher.forward(request, response);
		}
	}
}
