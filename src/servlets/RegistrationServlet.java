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
import model.CipherPass;
import model.CookiesManager;
import model.User;
import model.WebVariables;

/**
 * Servlet implementation class RegistrationServlet
 */
@WebServlet("/registration")
public class RegistrationServlet extends HttpServlet implements WebVariables{
	private static final long serialVersionUID = 1L;
	
	static final int DEFAULT_QUESTION = 1;
	static final String DEFAULT_IMAGE = "default.png";
	
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
		
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		String email = request.getParameter("email");
		
		int gender = MALE;
		if (request.getParameter("gender").equals("female"))
			gender = FEMALE;
		
		String passwd = request.getParameter("passwd");
		CipherPass cfr = new CipherPass();
		User e = new User(fname, lname, gender, DEFAULT_QUESTION, "", DEFAULT_IMAGE);
		int result = AccountManager.add(con, email, cfr.Cipher(passwd), e);
		
		if (result == AccountManager.FAILED){
			request.setAttribute(REGISTRATION_INFO, "Email " + email + " is already used.");
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SIGN_UP);
			dispatcher.forward(request, response);
		} else if (result == AccountManager.SUCCESS){
			RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_LOGIN);
			dispatcher.forward(request, response);
		}
	}

}
