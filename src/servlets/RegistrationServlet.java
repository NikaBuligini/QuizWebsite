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
import javax.servlet.http.HttpSession;

import model.AccountManager;
import model.SQLManager;
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
		String firstname = request.getParameter(FIRSTNAME);
		String lastname = request.getParameter(LASTNAME);
		String eMail = request.getParameter(EMAIL);
		String birthday = request.getParameter(BIRTHDAY);
		
		String pass1 = request.getParameter(PASS1);
		String pass2 = request.getParameter(PASS2);
		if (!pass1.equals(pass2)){
			System.out.println("toli araa");
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		}
		
		String gender = request.getParameter(GENDER);
		String question = request.getParameter(QUESTION);
		String answer = request.getParameter(ANSWER);
		
		
		User e = new User(username, firstname, lastname, birthday,
				eMail, gender, question, answer);
		printUser(e, pass1);
		AccountManager manager = new AccountManager();
		int result = manager.addUser(con, e, pass1);
		
		if (result == AccountManager.FAILED) {
			request.setAttribute(REGISTRATION_INFO, "Username " + e.getUsername() + " is already used.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("registration.jsp");
			dispatcher.forward(request, response);
		} else if (result == AccountManager.ADDED) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			dispatcher.forward(request, response);
		}
	}

	
	private void printUser(User e, String password){
		System.out.println("Username: " + e.getUsername());
		System.out.println("Password: " + password);
		System.out.println("Firstname: " + e.getFirstName());
		System.out.println("Lastname: " + e.getLastName());
		System.out.println("email: " + e.getEMail());
		System.out.println("Birthday: " + e.getBirthday());
		System.out.println("Question: " + e.getGender());
		System.out.println("Answer: " + e.getAnswer());
	}
	
}
