package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class PassRecoveryQuestion
 */
@WebServlet("/PassRecoveryQuestion")
public class PassRecoveryQuestion extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String ANSWER = "answer";
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PassRecoveryQuestion() {
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
		
		String answer = request.getParameter(ANSWER);
		System.out.println("answer is : " + answer);
		String RealAnswer = (String) request.getAttribute("recoveryAnswer");
		System.out.println("realanswer is : " + RealAnswer);
		RequestDispatcher dispatcher;
		if(RealAnswer.equals(answer)){
			dispatcher = request.getRequestDispatcher("showUsernameAndPassword.jsp");
		}else{
			dispatcher = request.getRequestDispatcher("passRecoveryTryAgain.html");
		}
		dispatcher.forward(request, response);
	}

}
