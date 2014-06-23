<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
String text = request.getParameter("text");

if (text == null || text.equals("")){
	
} else {
	ArrayList<User> users = AccountManager.search(con, text);
	if (users.size() == 0) {
		%>
		<div class="no-result">
			<strong>No result for "<%=text %>"</strong>
		</div>
		<%
		return;
	}
	%>
	<ul>
	<%
	for (int i=0; i<users.size(); i++){
		User curr = users.get(i);
		if (i < 8) {
		%>
		<li>
			<a href="/QuizWebsite/view?p=<%=curr.getID() %>">
				<img src="">
				<label>
					<strong class="result-name"><%=curr.getFirstName()+" "+curr.getLastName() %></strong>
				</label>
			</a>
		</li>
		<%
		}
	}
	%>
	</ul>
	<%
}
%>
</body>
</html>