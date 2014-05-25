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
		
		String username = request.getParameter(USERNAME);
		String password = request.getParameter(PASSWORD);
		
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
