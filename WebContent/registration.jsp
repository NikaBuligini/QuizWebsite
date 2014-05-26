<%@page import="model.QuestionManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Registration</title>
	<link rel="stylesheet" type="text/css" href="css/design.css">
	<link rel="stylesheet" type="text/css" href="css/header-footer.css">

	<%
	Connection con = (Connection) getServletContext().getAttribute(WebVariables.CONNECTION);
	ArrayList<String> questions = QuestionManager.getQuestions(con);
	String info = (String) request.getAttribute(WebVariables.REGISTRATION_INFO);
	if (info == null)
		info = "";
	%>
	
</head>
<body>
	<div class="wrapper">
		<jsp:include page="JSP-admin/sign-in-header.jsp"></jsp:include>
		<div class="signuppage">
			<h1>Create your Account</h1>
			<div class="errorMessage">
				<p><%=info %></p>
			</div>
			<div class="sign-up">
				<div class="sign-up-box">
					<form name="signup" action="registration" method="post">
						<div class="form-element">
							<div class="signup-input">
								<strong>Username</strong><br>
								<input type="text" name=<%=WebVariables.USERNAME %> required>
								<span id="useralert"></span>
							</div>
							<div>
								<table>
									<tbody>
										<tr>
											<td>
												<strong>Name</strong>
											</td>
										</tr>
										<tr>
											<td>
												<input id="First" type="text" name=<%=WebVariables.FIRSTNAME %> placeholder="First">
											</td>
											<td>
												<input id="Last" type="text" name=<%=WebVariables.LASTNAME %> placeholder="Last">
											</td>
										</tr>
									</tbody>
								</table>
								<span id="namealert"></span>
							</div>
							<div class="signup-input">
								<strong>Your email address</strong><br>
								<input type="email" name=<%=WebVariables.EMAIL %>>
								<span id="emailalert"></span>
							</div>
							<div class="signup-input">
								<strong>Create a password</strong><br>
								<input type="password" name=<%=WebVariables.PASS1 %>>
								<span id="pass1alert"></span>
							</div>
							<div class="signup-input">
								<strong>Confirm your password</strong><br>
								<input type="password" name=<%=WebVariables.PASS2 %>>
								<span id="pass2alert"></span>
							</div>
							<div>
								<strong>Birthday</strong><br>
								<input type="date" name="bday">
								<span id="birthdayalert"></span>
							</div>
							<div>
								<strong>Gender</strong><br>
								<input type="radio" name=<%=WebVariables.GENDER %> value="female">Female
								<input type="radio" name=<%=WebVariables.GENDER %> value="male">Male
								<span id="genderalert"></span>
							</div>
							<div class="signup-input">
								<strong>Question</strong><br>
								<select name=<%=WebVariables.QUESTION %> form="signup">
									<%
									for (int i=0; i<questions.size(); i++){
									%>
									<option><%=questions.get(i) %></option>
									<%
									}
									%>
								</select>
							</div>
							<div class="signup-input">
								<strong>Answer</strong><br>
								<input type="text" name=<%=WebVariables.ANSWER %>>
								<span id="answeralert"></span>
							</div>
							<div>
								<div class="signup-button">
									<input type="button" onclick="check(this.form)" value="Sign Up">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="JSP-admin/unlogged-footer.jsp"></jsp:include>
	</div>
	<script language="javascript">
		function check(form){
			var ok = true;
			
			if (form.<%=WebVariables.USERNAME %>.value.length == 0) {
				document.getElementById("useralert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("useralert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.FIRSTNAME %>.value.length == 0 || form.<%=WebVariables.LASTNAME %>.value.length == 0){
				document.getElementById("namealert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("namealert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.EMAIL %>.value.length == 0) {
				document.getElementById("emailalert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("emailalert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.PASS1 %>.value.length == 0) {
				document.getElementById("pass1alert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("pass1alert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.PASS2 %>.value.length == 0) {
				document.getElementById("pass2alert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("pass2alert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.BIRTHDAY %>.value.length == 0) {
				document.getElementById("birthdayalert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("birthdayalert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.GENDER %>.value.length == 0) {
				document.getElementById("genderalert").innerHTML = "Are you sure?";
				ok = ok && false;
			} else {
				document.getElementById("genderalert").innerHTML = "";
			}
			
			if (form.<%=WebVariables.ANSWER %>.value.length == 0) {
				document.getElementById("answeralert").innerHTML = "You can't leave this empty.";
				ok = ok && false;
			} else {
				document.getElementById("answeralert").innerHTML = "";
			}
			
			if (ok){
				document.signup.submit();
			}
		}
	</script>
</body>
</html>