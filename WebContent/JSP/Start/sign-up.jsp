<%@page import="model.WebVariables"%>
<%@page import="model.QuestionManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
String alert = (String)request.getAttribute(WebVariables.REGISTRATION_INFO);
if (alert == null)
	alert = "";
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Create new account</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/design.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
</head>
<body>
	<div class="container">
		<div class="well">
			<form id="signup" class="form-horizontal" method="post" action="<%=request.getContextPath() %>/registration" autocomplete="off">
				<legend>Sign Up</legend>
				<div class="control-group">
					<label class="control-label">First Name</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on">
								<i class="icon-user"></i>
							</span>
							<input type="text" class="input-xlarge" id="fname" name="fname" placeholder="First Name" onkeyup="checkfname()">
							<span id="fname-alert" class="check-alert">You can't leave this empty</span>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Last Name</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on">
								<i class="icon-user"></i>
							</span>
							<input type="text" class="input-xlarge" id="lname" name="lname" placeholder="Last Name" onkeyup="checklname()">
							<span id="lname-alert" class="check-alert">You can't leave this empty</span>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Email</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on">
								<i class="icon-user"></i>
							</span>
							<input type="text" class="input-xlarge" id="email" name="email" placeholder="Email" onkeyup="checkemail()">
							<span id="email-alert" class="check-alert">You can't leave this empty</span>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Gender</label>
					<div class="controls">
						<div class="input-prepend">
							<div id="gender" name="gender" class="radio-group" data-toggle="buttons-radid">
								<input type="radio" name="gender" value="male" onclick="checkRadio()">Male
								<input type="radio" name="gender" value="female" onclick="checkRadio()">Female
							</div>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Password</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on">
								<i class="icon-user"></i>
							</span>
							<input type="password" class="input-xlarge" id="passwd" name="passwd" placeholder="Password" onkeyup="checkPass()">
							<span id="passwd-alert" class="check-alert"></span>
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label">Confirm Password</label>
					<div class="controls">
						<div class="input-prepend">
							<span class="add-on">
								<i class="icon-user"></i>
							</span>
							<input type="password" class="input-xlarge" id="conpasswd" name="conpasswd" placeholder="Re-enter Password" onkeyup="checkPass()" onclick="encrypt()">
						</div>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="input01"></label>
					<div class="controls">
						<button type="button" class="btn btn-success" onclick="fullCheck(this.form)">Create My Account</button>
					</div>
				</div>
				<span class="registration-alert"><%=alert %></span>
			</form>
		</div>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/check.js"></script>
</body>
</html>