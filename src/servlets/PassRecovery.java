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
		String tryAgain = "Wrong username, or email, please, try again";
		String[] list = AccountManager.getRecovery(con, text);
		
		RequestDispatcher dispatcher;
		if(list == null){
			dispatcher = request.getRequestDispatcher("passRecoveryTryAgain.html");
		}else{
			tryAgain = "";
			
			String Question = list[0];
			System.out.println("Question : " + Question);
			String Answer = list[1];
			System.out.println("Answer : " + Answer);
			String Username = list[2];
			System.out.println("User : " + Username);
			String Pass = list[3];
			System.out.println("Pass : " + Pass);
			
			HttpSession session = request.getSession();
			session.setAttribute("recoveryQuestion", Question);
			session.setAttribute("recoveryAnswer",Answer);
			session.setAttribute("recoveryUsername",Username);
			session.setAttribute("recoveryPass",Pass);
			
			dispatcher = request.getRequestDispatcher("passRecoveryQuestion.jsp");
		}
		context.setAttribute("tryAgain", tryAgain);
		dispatcher.forward(request, response);
	}
}
