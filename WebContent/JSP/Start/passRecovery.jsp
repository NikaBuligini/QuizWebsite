<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/design.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	
</head>
<body>
	<div class="wrapper">
		<div class = "need help">
			<form action="PassRecovery" method="post">
				<h1>Forgot Your Password or Username? </h1>
				<br>
				<p> Enter the email address that you usually sign in with, or your QuizWebsite username, and we'll help you recover your account. </p>
				<p> Username or E-mail:</p>
				<p> <input type="text" name = "text" size = "30" /> </p>
				<span id="alert" class="alert"><%=(String)request.getAttribute("tryAgain")%></span>
				<p> <input type="submit" value="Submit"> </p>
			</form>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
</body>
</html>