<%@page import="model.AccountManager"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.NotificationManager"%>
<%@page import="model.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
String email = CookiesManager.getCookie(request, WebVariables.COOKIE_USER).getValue();
int ID = AccountManager.getIDByEmail(con, email);

ArrayList<Notification> list = NotificationManager.getNotifications(con, ID);

if (list.size() != 0){
	for (int i=0; i<list.size(); i++) {
		Notification e = list.get(i);
%>
<li>
	<div class="notif-main">
		<label class="img-label">
			<a href="/QuizWebsite/view?p=<%=e.getAuthorID() %>">
				<img alt="" src="/QuizWebsite/Images/<%=e.getImage() %>" width="25px" height="25px">
			</a>
		</label>
		<a href="/QuizWebsite/view?p=<%=e.getAuthorID() %>" class="notif-author"><%=e.getName() %></a>
	</div>
	<div class="notif-main">
		<p class="notif-text"><%=e.getText() %></p>
		<span class="timestamp">21 June.</span>
	</div>
	<div class="notif-decision" id="not_<%=i %>">
		<button type="button" class="accept" onclick="accept(<%=e.getID() %>, <%=e.isChallenge() %>, not_<%=i %>)">Accept</button>
		<button type="button" class="decline" onclick="decline(<%=e.getID() %>, <%=e.isChallenge() %>, not_<%=i %>)">Decline</button>
	</div>
</li>
<%
	}
} else {
%>
<p class="no-result">No Result<p>
<%
}
%>
