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

import model.NotificationManager;
import model.WebVariables;

/**
 * Servlet implementation class NotificationsServlet
 */
@WebServlet("/notifications")
public class NotificationsServlet extends HttpServlet implements WebVariables{
	private static final long serialVersionUID = 1L;
    	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_NOTIFICATIONS);
		dispatcher.forward(request, response);
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		Connection con = (Connection) context.getAttribute(CONNECTION);
		
		String notifID = request.getParameter("id");
		int ID = Integer.parseInt(notifID);
		String type = request.getParameter("type");
		String command = request.getParameter("com");
		
		if (type.equals("fr")) {
			if (command.equals("accept")){
				NotificationManager.accept(con, ID, false);
			} else if (command.equals("decline")){
				NotificationManager.decline(con, ID, false);
			}
		} else {
			if (command.equals("accept")){
				
			} else if (command.equals("decline")){
				
			}
		}
	}

}
