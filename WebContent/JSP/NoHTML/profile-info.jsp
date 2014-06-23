<%@page import="model.FriendManager"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
	
	String userID = request.getParameter("id");
	if (userID != null){
		int ID = Integer.parseInt(userID);
		
		User c = AccountManager.getUser(con, ID);
		%>
			<ul class="profile-tabs">
				<li>
					<a href="#">About</a>
				</li>
				<li>
					<a href="#">Friends</a>
					<span class="count"><%=FriendManager.getFriends(con, ID).size() %></span>
				</li>
				<li>
					<a href="#">Quizzes</a>
					<span class="count">0</span>
				</li>
				<li>
					<a href="#">Achievements</a>
					<span class="count">0</span>
				</li>
			</ul>
		<%
	}
	%>
</body>
</html>