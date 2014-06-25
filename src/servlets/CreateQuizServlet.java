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

import model.AccountManager;
import model.Answer;
import model.CookiesManager;
import model.Question;
import model.Quiz;
import model.QuizManager;
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
	
	private static final int DEFAULT_SCORE = 1;
	

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
		
		Quiz c = createQuiz(request, con);
		
		String sizeStr = request.getParameter("n-question");
		int size = Integer.parseInt(sizeStr);
		
		for (int i=1; i<size+1; i++) {
			String text = request.getParameter("question" + i);
			if (text == null)
				text = "";
			
			String image = request.getParameter("image" + i);
			if (image == null)
				image = "";
			
			Question e = new Question(text, image);
			
			String answerStr = request.getParameter("radio" + 1);
			int answer = Integer.parseInt(answerStr);
			
			for (int j=1; j<6; j++){
				String temp = request.getParameter("answer" + i + "_" + j);
				if (temp == null)
					temp = "";
				
				int score = 0;
				if (j == answer)
					score = DEFAULT_SCORE;
				Answer curr = new Answer(temp, score);
				e.addAnswer(curr);
			}
			c.addQuestion(e);
		}
		
		QuizManager.insert(c, con);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/QuizWebsite/profile");
		dispatcher.forward(request, response);
	}
	
	
	private Quiz createQuiz(HttpServletRequest request, Connection con) {
		String title = request.getParameter(TITLE);
		String description = request.getParameter(DESCRIPTION);
		String category = request.getParameter(CATEGORY);
		int categoryID = Integer.parseInt(category);
		boolean random = request.getParameter(RANDOM) != null;
		boolean correction = request.getParameter(CORRECTION) != null;
		boolean onePage = request.getParameter(ONE_PAGE) != null;
		
		Cookie userEmail = CookiesManager.getCookie(request, COOKIE_USER);
		int ID = AccountManager.getIDByEmail(con, userEmail.getValue());
		
		return new Quiz(title, description, random, correction, onePage, ID, categoryID);
	}
}
