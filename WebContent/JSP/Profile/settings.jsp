<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<!DOCTYPE html>
<%
User currUser = (User) (request.getSession().getAttribute("user"));

Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
Cookie userCookie = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
User c = AccountManager.getUser(con, userCookie.getValue());
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Settings</title>
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/design.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/profile-style.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/header-footer.css">
</head>
<body>
	<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
	<div class="settings-content">
		<div class="account-col">
			<div class="account-content">
				<p class="account-title">
					<label style="font-weight: bold;">Account</label>
				</p>
				<div class="email-bar">
					<div class="email-title">Primary Email</div>
					<div class="email-item">
						<label id="currEmail"><%=userCookie.getValue() %></label>
					</div>
					<div class="email-title"></div>
					<div id="email-bar" class="change-email">
						<a id="edit-email" href="#">Change Email Address</a>
						<div id="email-res" class="none">
							<input id="new-email" type="text" class="change-input">
							<span id="email-alert"></span>
							<a id="change-email-button" href="#" class="email-but">Change Email</a>
						</div>
					</div>
				</div>
				<div class="email-bar passwd-bar">
					<div class="email-title">Password</div>
					<div class="passwd-item">
						<a id="change-passwd" href="#">Change Password</a>
						<div id="passwd-res" class="none">
							<div class="pass-bar">
								<label>Old Password</label>
								<input id="old-passwd" type="text" class="pass-input">
							</div>
							<div class="pass-bar">
								<label>New Password</label>
								<input id="new-passwd" type="text" class="pass-input">
							</div>
							<a id="finish-pass-change" href="#" class="finish-pass-change">Change Password</a>
						</div>
					</div>
				</div>
				<div class="email-bar passwd-bar">
					<div class="email-title">First Name</div>
					<div class="email-item">
						<strong><%=c.getFirstName() %></strong>
					</div>
					<div class="email-title"></div>
					<div class="passwd-item">
						<a id="change-fname" href="#">Change first name</a>
						<div id="fname-res" class="none">
							<div class="pass-bar">
								<label>New first name</label>
								<input id="new-name" type="text" class="pass-input">
							</div>
							<a id="finish-fname-change" href="#" class="finish-pass-change">Change</a>
						</div>
					</div>
				</div>
				<div class="email-bar passwd-bar">
					<div class="email-title">Last Name</div>
					<div class="email-item">
						<strong><%=c.getLastName() %></strong>
					</div>
					<div class="email-title"></div>
					<div class="passwd-item">
						<a id="change-lname" href="#">Change last name</a>
						<div id="lname-res" class="none">
							<div class="pass-bar">
								<label>New last name</label>
								<input id="new-name" type="text" class="pass-input">
							</div>
							<a id="finish-lname-change" href="#" class="finish-pass-change">Change</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	<script type="text/javascript">
		function showForm(e) {
			e.target.style.display = "none";
			hideAll();
			e.target.nextSibling.nextSibling.style.display = "block";

		}
		function hideAll() {
			var forms = document.getElementsByTagName("form");
			for (var i = 0; i < forms.length; i++) {
				forms[i].style.display = "none";
			}
		}
		function validateForm(e) {
			//alert(e.target.childNodes[7]);
			//alert(e.target.childNodes.length);
			var inputs = e.target.getElementsByTagName("input");
			var count = inputs.length;
			var email = inputs[count - 3].value;
			var email1 = inputs[count - 2].value;
			if (email != email1 || email == "") {
				alert("ველები ან ცარიელია ან ერთამენთს არ ემთხვევა");
				return false;
			}
		}
	</script>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/settings.js"></script>
</body>
</html>