package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.jws.soap.SOAPBinding.Use;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AccountManager;
import model.CookiesManager;
import model.QuizManager;
import model.User;
import model.WebVariables;
import model.Manager;
import model.Quiz;


/**
 * Servlet implementation class DeleteYourQuizesServlet
 */
@WebServlet("/DeleteYourQuizesServlet")
public class DeleteYourQuizesServlet extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteYourQuizesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("deleteyourquizes.jsp");
		dispatcher.forward(request, response);
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 // TODO Auto-generated method stub
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		Cookie userCookie = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
		User c = AccountManager.getUser(con, userCookie.getValue());
		ArrayList<String> QuizName = new ArrayList<String>();
		QuizName = QuizManager.getQuizesNameByCreatorID(con, c.getID());
		
		QuizName.remove(0);
		QuizManager.deleteQuiz(con, c.getID());
		
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("deleteyourquizes.jsp");
		dispatcher.forward(request, response);
	
	}

}
