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
		<div class="recovery-content">
			<div class="recovery">
				<div id="recovery-result" class="recovery-result">
					<label class="recovery-header">Forgot Your Password?</label>
					<label class="recovery-sub-header">
						Enter the email address that you usually sign in with and we'll help you recover your account
					</label>
					<div class="recovery-inputs">
						<input id="email-input" type="text" placeholder="Email" class="email-input">
						<button id="email-button" class="submit-button">Submit</button>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/recovery.js"></script>
</body>
</html>