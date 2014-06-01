package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.CookiesManager;
import model.QuestionManager;
import model.User;
import model.WebVariables;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet implements WebVariables{
	private static final long serialVersionUID = 1L;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		if (CookiesManager.cookieRedirect(request, response, con))
			return;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SIGN_UP);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String username = request.getParameter(USERNAME);
		String firstname = request.getParameter(FIRSTNAME);
		String lastname = request.getParameter(LASTNAME);
		String email = request.getParameter(EMAIL);
		String birthday = request.getParameter(BIRTHDAY);
		
		String pass1 = request.getParameter(PASS1);
		String pass2 = request.getParameter(PASS2);
		if (!pass1.equals(pass2)){
			request.setAttribute(REGISTRATION_INFO, "Passwords are different.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SIGN_UP);
			dispatcher.forward(request, response);
			return;
		}
		
		int gender = MALE;
		if (request.getParameter(GENDER).equals("female"))
			gender = FEMALE;
		
		String question = request.getParameter(QUESTION);
		int questionID = QuestionManager.getID(con, question);
		
		String answer = request.getParameter(ANSWER);
		
		User e = new User(email, firstname, lastname, birthday, gender, questionID, answer);
		int result = AccountManager.add(con, username, pass1, e);
		
		if (result == AccountManager.FAILED){
			request.setAttribute(REGISTRATION_INFO, "Username " + username + " is already used.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SIGN_UP);
			dispatcher.forward(request, response);
		} else if (result == AccountManager.USED_EMAIL){
			request.setAttribute(REGISTRATION_INFO, "email " + email + " is already used.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SIGN_UP);
			dispatcher.forward(request, response);
		} else if (result == AccountManager.SUCCESS){
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_LOGIN);
			dispatcher.forward(request, response);
		}
	}

}
