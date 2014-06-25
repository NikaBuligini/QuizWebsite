<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<%@page import="model.QuizManager" %>
<!DOCTYPE html>
<%
User currUser = (User) (request.getSession().getAttribute("user"));

Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
Cookie userCookie = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
User c = new User("tamta", "kirtadze",1,1,"ki", null);
ArrayList<String> QuizName = new ArrayList<String>();
QuizName = QuizManager.getQuizesNameByCreatorID(con, c.getID());
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Delete your quizes</title>
	<h6>your Quizes:</h6>
	 <% for(int i=0; i<QuizName.size(); i++){
		%>
		<label id=""><%=QuizName.get(i) %></label>
		<button onclick='javascript:confirm("Are you sure?");'>Delete</button>
		
	<% }
		%>
	%>
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/design.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/profile-style.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/header-footer.css">
</head>
<body style="background-color:#C2CFDF;">


</body>
</html>