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
	
	
	static final String DEFAULT_IMAGE = "default.png";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public settings() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		User currUser = (User) (request.getSession().getAttribute("user"));
		
		
		String Name = request.getParameter("Name");
		if(request.getParameter("Name")==(null))
		{
			Name=currUser.getFirstName();
		}
		String lastname = request.getParameter("lastname");
		if(request.getParameter("lastname")==(null))
		{
			lastname=currUser.getLastName();
		}
		
		String email = request.getParameter("email");
		if(request.getParameter("email")==(null))
		{
			email=AccountManager.getEmail(con, currUser.getID());
		}
		
		String password = request.getParameter("password");
		if(password==null){
					password=AccountManager.getpassword(con, currUser.getID());
		}
		
		int gender=currUser.getGenderID();
		Manager man = new Manager ();
		
		//CookiesManager.update(con, USERS_TABLE, USERS_EMAIL_C, USERS_PASSWORD_C, currUser.getID());
			RequestDispatcher dispatcher = request.getRequestDispatcher("setting.jsp");
			dispatcher.forward(request, response);
		
		
	}

}
