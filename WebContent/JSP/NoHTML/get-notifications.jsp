<%@page import="model.FriendManager"%>
<%@page import="model.AccountManager"%>
<%@page import="model.CookiesManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
	Cookie user = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
	int ID = AccountManager.getIDByEmail(con, user.getValue());
	
	int f_RequestCount = FriendManager.getRequestCount(con, ID);
	
	int all = f_RequestCount;
	%>
	<span id="h-c"><%=all %></span>
	<span id="f-c"><%=f_RequestCount %></span>
</body>
</html>