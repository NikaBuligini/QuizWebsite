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
		<div class="header-bar">
			<div class="registration-header-content"></div>
		</div>
		<br>
		<h1>Forgot Your Password ?</h1>
		<div style="height: 1px; text-align:left; margin: 20px;">
    			Enter the email address that you usually sign in with and we'll help you recover your account.
    			<form action="PassRecovery" method="post">
				<p><input type="text" name = "text" size = "30"/></p>
				
				<p><input type = "submit" value= "Submit" style="height: 30px"></p>
				</form>
		</div>
		
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		
			
		
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	
</body>
</html>