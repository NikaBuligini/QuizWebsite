package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Quiz;
import model.WebVariables;

/**
 * Servlet implementation class CreateQuizServlet
 */
@WebServlet("/create")
public class CreateQuizServlet extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
	
	public static final String TITLE = "title";
	public static final String DESCRIPTION = "description";
	public static final String CATEGORY = "category";
	public static final String RANDOM = "random";
	public static final String CORRECTION = "correction";
	public static final String ONE_PAGE = "onePage";
	public static final String TYPE = "type";
	
	public static final String CATEGORY_SPORT = "1";
	public static final String CATEGORY_IQ = "2";
	public static final String CATEGORY_MOVIES = "3";
	public static final String CATEGORY_BOOKS = "4";
	public static final String CATEGORY_KNOWLEDGE = "5";
	public static final String CATEGORY_OTHER = "6";
	
	public static final String TYPE_MULTIPLE_CHOICE = "1";
	public static final String TYPE_QUESTION_RESPONCE = "2";
	public static final String TYPE_FILL = "3";
	public static final String TYPE_PICTURE = "4";
	

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
		String name = request.getParameter(TITLE);
		String description = request.getParameter(DESCRIPTION);
		String category = request.getParameter(CATEGORY);
		boolean random = request.getParameter(RANDOM) != null;
		boolean correction = request.getParameter(CORRECTION) != null;
		boolean onePage = request.getParameter(ONE_PAGE) != null;
		
		
//		Quiz newQuiz = new Quiz(name, description, category, random, correction, onePage, practice, type);
//		request.setAttribute("quiz", newQuiz);
		
//		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_CREATE);
//		dispatcher.forward(request, response);
	}

}
