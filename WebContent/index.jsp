<%@page import="model.WebVariables"%>
<%@page import="model.CookiesManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
if (CookiesManager.cookieRedirect(request, response, con))
	return;
%>
<html>
<head>
	<title>Welcome to QuizWebsite - Log In, Sign Up or Learn More</title>
	<link rel="stylesheet" type="text/css" href="css/design.css">
	<link rel="stylesheet" type="text/css" href="css/header-footer.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="JSP-admin/sign-in-header.jsp"></jsp:include>
		<div>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
			<br>
		</div>
		<jsp:include page="JSP-admin/unlogged-footer.jsp"></jsp:include>
	</div>
</body>
</html>