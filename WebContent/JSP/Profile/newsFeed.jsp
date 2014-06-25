    <%@page import="java.sql.Connection"%>
    <%@page import="model.WebVariables"%>
    <%@page import="model.newsFeedManager"%>
    <%@page import="java.util.ArrayList" %>
    <%@page import="model.User"%>
    <%@page import="model.AccountManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
	
	<%
	Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
	String s = request.getParameter(WebVariables.VIEW);
	int ID = Integer.parseInt(s);
	ArrayList<ArrayList<Object>> arr = newsFeedManager.getNews(con,ID);
	%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<div>
		<%
		for(int i=0; i<arr.size();i++){
			int userID = (Integer)arr.get(i).get(4);
			String name = AccountManager.getUser(con, userID).getFirstName() + " " + AccountManager.getUser(con, userID).getLastName();
			int objectID = (Integer)arr.get(i).get(5);
			String text = (String)arr.get(i).get(3);
			String objectName = "";
			if(text.equals(" became friends with ")){
				objectName = AccountManager.getUser(con, objectID).getFirstName() + " " + AccountManager.getUser(con, objectID).getLastName();
			}else{
				objectName = newsFeedManager.getString(con, "quizzes", "ID", objectID, "name");
			}
		%>
			<h1>
				newsFeed :
				<div>
					<%= name + text + objectName%>
				</div>
			</h1>
		<%
		}
		%>
	
	</div>
</body>
</html>