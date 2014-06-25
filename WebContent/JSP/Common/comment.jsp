<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Comment"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<% ArrayList<Comment> comments = (ArrayList<Comment>) request.getAttribute("comments");%>

<% for(int i = 0; i < comments.size(); i++){
	%>
	<br>
	<br>
	<div id="user_name_tag">User: </div>
	<div id="user_name"><%= comments.get(i).getUser().getFullName() %></div>
	<div id="comment_old_tag">Comment: </div>
	<div id="comment_old"><%= comments.get(i).getText()%></div>
	<div id="comment_date_tag">Date: </div>
	<div id="comment_date"><%= comments.get(i).getDate()%></div>
<%} %>
<br>
<br>
<form action="CommentServlet" method="post">
<label id="user_name">kire</label>
<input type="hidden" name="quiz_id" value="<%=1%>" />
<input type="hidden" name="user_id" value="<%=2%>" />
<textarea id="comment_text" rows="5" cols="60"></textarea>
<input type="submit" value="Comment">
</form>
</body>
</html>