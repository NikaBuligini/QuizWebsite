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

import model.AccountManager;
import model.WebVariables;

/**
 * Servlet implementation class PassRecovery
 */
@WebServlet("/PassRecovery")
public class PassRecovery extends HttpServlet implements WebVariables {
	private static final long serialVersionUID = 1L;
	private static final String TEXT = "text";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassRecovery() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String text = request.getParameter(TEXT);
		AccountManager manager = new AccountManager();
		String QuestionAndAnswer = manager.getRecoveryQuestionAndAnswer(con, text);
		RequestDispatcher dispatcher;
		System.out.println("text is : "+QuestionAndAnswer);
		if(QuestionAndAnswer.equals("")){
			dispatcher = request.getRequestDispatcher("passRecoveryTryAgain.html");
		}else{
			int slash1 = QuestionAndAnswer.indexOf("/");
			String Question = QuestionAndAnswer.substring(0,slash1);
			int slash2 = QuestionAndAnswer.substring(slash1+1).indexOf("/");
			String Answer = QuestionAndAnswer.substring(slash1+1,slash2);
			int slash3 = QuestionAndAnswer.substring(slash2+1).indexOf("/");
			String Username = QuestionAndAnswer.substring(slash2+1,slash3);
			String Pass = QuestionAndAnswer.substring(slash3);
			
			HttpSession session = request.getSession();
			session.setAttribute("recoveryQuestion", Question);
			session.setAttribute("recoveryAnswer",Answer);
			session.setAttribute("recoveryUsername",Username);
			session.setAttribute("recoveryPass",Pass);
			
			dispatcher = request.getRequestDispatcher("passRecoveryQuestion.jsp");
		}
		dispatcher.forward(request, response);
	}

}
