<%@page import="model.AccountManager"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
	
	String email = request.getParameter("email");
	if (email != null) {
		if (AccountManager.getIDByEmail(con, email) != 0){
		%>
			this email is already used
		<%
		}
	}
	%>
</body>
</html>