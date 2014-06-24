<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="model.Comment"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<label id="user_name">kire</label>
<textarea id="comment_box" rows="5" cols="60"></textarea>
<button id="submit">Submit</button>

</body>
</html>