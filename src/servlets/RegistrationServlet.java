package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.DBConnection;
import model.User;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/Registration")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final String USERNAME = "user";
	private static final String PASSWORD = "pass";
	private static final String FIRSTNAME = "fname";
	private static final String LASTNAME = "lname";
	private static final String BIRTHDAY = "bday";
	private static final String EMAIL = "email";
	private static final String QUESTION = "question";
	private static final String ANSWER = "answer";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		DBConnection db = (DBConnection) context.getAttribute(ServletListener.CONNECTION);
		
		String username = request.getParameter(USERNAME);
		String firstname = request.getParameter(FIRSTNAME);
		String lastname = request.getParameter(LASTNAME);
		String birthday = request.getParameter(BIRTHDAY);
		String eMail = request.getParameter(EMAIL);
		String question = request.getParameter(QUESTION);
		String answer = request.getParameter(ANSWER);
		
		String password = request.getParameter(PASSWORD);
		
		User e = new User(username, firstname, lastname, birthday,
				eMail, question, answer);
		
		AccountManager manager = new AccountManager();
		int result = manager.addUser(db.getConnection(), e, password);
		switch (result) {
		case AccountManager.WRONG_PARAMS:
			
			response.sendRedirect("failed.html");
			break;
			
		case AccountManager.FAILED:
			
			response.sendRedirect("failed.html");
			break;
		
		case AccountManager.ADDED:
			
			response.sendRedirect("/login");
			break;
			
		default:
			break;
		}
	}
	
}
