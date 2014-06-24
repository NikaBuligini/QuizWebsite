package servlets;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.DebugGraphics;

import model.CommentManager;
import model.Comment;
import model.WebVariables;

/**
 * Servlet implementation class CommentServlet
 */
@WebServlet("/CommentServlet")
public class CommentServlet extends HttpServlet  implements WebVariables{
	private static final long serialVersionUID = 1L;
	private static final String TEXT = "comment_text";
	private static final String QUIZ_ID = "quiz_id";
	private static final String USER_ID = "user_id";
	private static final String CONTEXT_DATA = "comments";
	private Connection con = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher(JSP_COMMENT);
		ServletContext context = getServletConfig().getServletContext();
		if(con == null)
		con = (Connection) context.getAttribute(CONNECTION);
		ArrayList<Comment> comments = CommentManager.getAll(con);
		request.setAttribute(CONTEXT_DATA, comments);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext context = getServletConfig().getServletContext();
		if(con == null)
		con = (Connection) context.getAttribute(CONNECTION);
		
		String text = request.getParameter(TEXT);
		int quiz_id = Integer.parseInt(request.getParameter(QUIZ_ID));
		int user_id = Integer.parseInt(request.getParameter(USER_ID));
		
		HttpSession session = request.getSession();
		
		CommentManager.add(con, text, user_id, quiz_id);
		doGet(request,response);
	}

}
