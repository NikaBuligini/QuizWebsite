<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Log In</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/design.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	
	<%
	String info = (String) request.getAttribute(WebVariables.SIGNIN_INFO);
	if (info == null)
		info = "";
	%>
</head>
<body>
	<div class="wrapper">
		<div class="login-header"></div>
		<div class="main-content">
			<div class="banner">
				<h1>Sign in</h1>
				<h2>Enjoy!</h2>
			</div>
			<div class="signin-content">
				<img alt="Default Image" src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcTMYLsJK5kj3qSti4ndoNejZs-MhLFQZN0tbsd1OuxABI2M1X0Piw">
				<p></p>
				<form name="signin" action="<%=request.getContextPath() %>/login" method="post">
					<input id="Email" type="text" name="email" placeholder="Email">
					<input id="Password" type="password" name="passwd" placeholder="Password">
					<span id="alert" class="alert"><%=info %></span>
					<input id="SignIn" type="button" value="Sign In">
					<label>
						<input name=<%=WebVariables.PERSISTENT %> type="checkbox" value="yes">
						<span>Stay signed in</span>
					</label>
					<a href="<%=request.getContextPath() %>/JSP/Start/passRecovery.jsp">Need help?</a>
				</form>
			</div>
			<div class="signin-footer">
				<a href="<%=request.getContextPath() %>/registration">Create an account</a>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/check.js"></script>
</body>
</html>