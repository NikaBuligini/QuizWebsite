package servlets;

import java.io.IOException;
import java.sql.Connection;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.CookiesManager;
import model.User;
import model.WebVariables;
import model.Manager;
/**
 * Servlet implementation class settings
 */
@WebServlet("/settings")
public class settings extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
	
	static final int DEFAULT_QUESTION = 1;
	static final String USERS_TABLE = "users";
	static final String USERS_ID_C = "ID";
	static final String USERS_EMAIL_C = "email";
	static final String USERS_PASSWORD_C = "pass";
	static final String INFO_TABLE = "additional_info";
	static final String INFO_USER_ID_C = "userID";
	static final String INFO_FIRSTNAME_C = "firstName";
	static final String INFO_LASTNAME_C = "lastName";
	
	static final String DEFAULT_IMAGE = "default.png";
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_SETTINGS);
		dispatcher.forward(request, response);
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		User currUser = (User) (request.getSession().getAttribute("user"));
		int ID = currUser.getID();
		
		
		String Name = request.getParameter("Name");
		if(request.getParameter("Name")==(null))
		{
			Name=currUser.getFirstName();
			AccountManager.updates(con, INFO_TABLE, INFO_FIRSTNAME_C, Name, INFO_USER_ID_C, ID);
		}
		String lastname = request.getParameter("lastname");
		if(request.getParameter("lastname")==(null))
		{
			lastname=currUser.getLastName();
			AccountManager.updates(con, INFO_TABLE, INFO_LASTNAME_C, lastname, INFO_USER_ID_C, ID);
		}
		
		String email = request.getParameter("email");
		if(request.getParameter("email")==(null))
		{
			email=AccountManager.getEmail(con, currUser.getID());
			AccountManager.updates(con, USERS_TABLE, USERS_EMAIL_C, email, USERS_ID_C, ID);
		}
		
		String password = request.getParameter("password");
		if(password==null){
					password=AccountManager.getpassword(con, currUser.getID());
					AccountManager.updates(con, USERS_TABLE, USERS_PASSWORD_C, password, USERS_ID_C, ID);
		
		}
		
		int gender=currUser.getGenderID();
		Manager man = new Manager ();
		
		
			RequestDispatcher dispatcher = request.getRequestDispatcher("setting.jsp");
			dispatcher.forward(request, response);
		
		
	}

}
