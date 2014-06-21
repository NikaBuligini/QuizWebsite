<%@page import="model.Notification"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.AccountManager"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.FriendManager"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
	int id = 0;
	boolean areFriends = false;
	
	String toID = request.getParameter("id");
	if (toID != null){
		int to = Integer.parseInt(toID);
		Cookie user = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
		int from = AccountManager.getIDByEmail(con, user.getValue());
		
		if (from == to){
			return;
		} else {
			ArrayList<Notification> notifications = FriendManager.getNotifications(con, from);
			for (int i=0; i<notifications.size(); i++){
				if (notifications.get(i).getAuthorID() == to){
					%>
					<input type="button" id="add" value="Check Notifications" class="request-sent" disabled="disabled">
					<%
					return;
				}
			}
		}
		
		areFriends = FriendManager.areFriends(con, from, to);
		id = FriendManager.getRequestID(con, from, to);
	}
	
	if(areFriends){
	%>
	<input type="button" id="add" value="Friend" class="request-sent" disabled="disabled">
	<%
	} else if (id == 0){
	%>
	<input type="button" id="add" value="Add Friend" class="add-friend" onclick="sendRequest()">
	<%
	} else {
	%>
	<input type="button" id="add" value="Request Sent" class="request-sent" disabled="disabled">
	<%
	}
	%>
</body>
</html>