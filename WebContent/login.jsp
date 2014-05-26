<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log In</title>
	<link rel="stylesheet" type="text/css" href="css/design.css">
	<link rel="stylesheet" type="text/css" href="css/header-footer.css">
	
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
				<img alt="Default Image" src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
				<p></p>
				<form name="signin" action="login" method="post">
					<input id="Username" type="text" name=<%=WebVariables.USERNAME %> placeholder="Username">
					<input id="Password" type="password" name=<%=WebVariables.PASSWORD %> placeholder="Password">
					<span id="alert" class="alert"><%=info %></span>
					<input id="SignIn" type="button" onclick="check(this.form)" value="Sign In">
					<label>
						<input name="persistent" type="checkbox" value="no">
						<span>Stay signed in</span>
					</label>
					<a href="/">Need help?</a>
				</form>
			</div>
			<div class="signin-footer">
				<a href="registration">Create an account</a>
			</div>
		</div>
		<jsp:include page="JSP-admin/unlogged-footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript">
		function check(form){
			if (form.<%=WebVariables.USERNAME %>.value.length == 0) {
				document.getElementById("alert").innerHTML = "Enter your username.";
				ok = ok && false;
			} else if (form.<%=WebVariables.PASSWORD %>.value.length == 0){
				document.getElementById("alert").innerHTML = "Enter your password.";
			} else {
				document.signin.submit();
			}
		}
	</script>
	<script type="text/javascript">
		
	</script>
</body>
</html>