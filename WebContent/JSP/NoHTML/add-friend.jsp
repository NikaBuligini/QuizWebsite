<%@page import="model.AccountManager"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.FriendManager"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
String toID = request.getParameter("id");
if (toID != null){
	int to = Integer.parseInt(toID);
	Cookie user = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
	int from = AccountManager.getIDByEmail(con, user.getValue());
	
	FriendManager.sendRequest(con, from, to);
}
%>
