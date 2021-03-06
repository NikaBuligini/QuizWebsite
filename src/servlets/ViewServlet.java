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
import model.User;
import model.WebVariables;

/**
 * Servlet implementation class ViewServlet
 */
@WebServlet("/view")
public class ViewServlet extends HttpServlet implements WebVariables{
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String userID = request.getParameter(VIEW);
		if (userID != null){
			int ID = 0;
			try {
				ID = Integer.parseInt(userID);
			} catch (NumberFormatException e) {
				
			}
			if (ID != 0) {
				User e = AccountManager.getUser(con, ID);
				request.setAttribute("user", e);
			}
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_VIEW);
		dispatcher.forward(request, response);
	}

}
