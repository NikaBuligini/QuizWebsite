<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
Cookie log = CookiesManager.getCookie(request, WebVariables.COOKIE_LOGGED_IN);
if (log == null){
	response.sendRedirect("login");
	return;
}
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=uts-8">
	<title>QuizWebsite</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
	<div class="content">
		<h1>Welcome to Profile page</h1>
	</div>
</body>
</html>