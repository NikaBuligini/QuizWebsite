<%@page import="servlets.CreateQuizServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
String index = request.getParameter("index");
String quizType = request.getParameter("type");

%>
<li class="li">
	<div class="question-header">
		<span><%=index %>.</span>
	</div>
	<div class="row-bar">
		<div class="text">
			<span class="text-span">Hint</span>
		</div>
		<div class="hint-input">
			<input type="text" class="input" name="hint<%=index %>">
		</div>
	</div>
	<div class="row-bar">
		<div class="text">
			<span class="tet-span">Answer</span>
		</div>
		<div class="hint-input">
			<input type="text" class="answer-input" name="answer<%=index %>">
		</div>
	</div>
</li>
<%
%>
</body>
</html>