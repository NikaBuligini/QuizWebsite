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
import javax.servlet.http.HttpSession;

import model.Quiz;
import model.WebVariables;

/**
 * Servlet implementation class CreateQuizServlet
 */
@WebServlet("/create")
public class CreateQuizServlet extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
	
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "desc";
	public static final String CATEGORY = "category";
	public static final String RANDOM = "random";
	public static final String CORRECTION = "correction";
	public static final String ONE_PAGE = "page";
	public static final String PRACTICE = "practice";
	public static final String TYPE = "type";
	

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_CREATE);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String name = request.getParameter(TITLE);
		String description = request.getParameter(DESCRIPTION);
		String category = request.getParameter(CATEGORY);
		boolean random = request.getParameter(RANDOM).equals("y");
		boolean correction = request.getParameter(CORRECTION).equals("y");
		boolean onePage = request.getParameter(ONE_PAGE).equals("y");
		boolean practice = request.getParameter(PRACTICE).equals("y");
		String type = request.getParameter(TYPE);
		
		HttpSession session = request.getSession();
		
		Quiz newQuiz = new Quiz(name, description, category, random, correction, onePage, practice, type);
	}

}
