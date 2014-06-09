<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><%=request.getParameter(WebVariables.VIEW) %></title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="view-content">
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
</body>
</html>