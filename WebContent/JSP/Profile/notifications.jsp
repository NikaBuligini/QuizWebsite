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
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Notifications</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="notifications">
			<div class="notif-content">
				<h1>Notifications</h1>
				<ul>
					<li>
						<div class="notif-main">
							<label class="img-label">
								<a href="#">
									<img alt="" src="" width="25px" height="25px">
								</a>
							</label>
							<a href="#" class="notif-author">Saxeli Gvari</a>
						</div>
						<div class="notif-main">
							<p class="notif-text">teqsti</p>
							<span class="timestamp">21 June.</span>
						</div>
						<div class="notif-decision">
							<button type="button" class="accept">Accept</button>
							<button type="button" class="decline">Decline</button>
						</div>
					</li>
					<li>
						b
					</li>
				</ul>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
</body>
</html>