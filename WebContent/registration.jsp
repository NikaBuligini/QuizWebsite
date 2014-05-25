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
</head>
<body>
	<div class="wrapper">
		<jsp:include page="JSP-admin/sign-in-header.jsp"></jsp:include>
		<div class="signuppage">
			<h1>Create your Account</h1>
			<div class="sign-up">
				<div class="sign-up-box">
					<form name="createaccount" action="registration" method="post">
						<div class="form-element">
							<div class="signup-input">
								<strong>Username</strong><br>
								<input type="text" name=<%=WebVariables.USERNAME %>>
							</div>
							<div>
								<table>
									<tbody>
										<tr class="grey-text">
											<td>
												<label>First Name</label>
											</td>
											<td>
												<label>Last Name</label>
											</td>
										</tr>
										<tr>
											<td>
												<input type="text" name=<%=WebVariables.FIRSTNAME %> class="half-input">
											</td>
											<td>
												<input type="text" name=<%=WebVariables.LASTNAME %> class="half-input">
											</td>
										</tr>
									</tbody>
								</table>
							</div>
							<div class="signup-input">
								<strong>Your email address</strong><br>
								<input type="email" name=<%=WebVariables.EMAIL %>>
							</div>
							<div class="signup-input">
								<strong>Create a password</strong><br>
								<input type="password" name=<%=WebVariables.PASS1 %>>
							</div>
							<div class="signup-input">
								<strong>Confirm your password</strong><br>
								<input type="password" name=<%=WebVariables.PASS2 %>>
							</div>
							<div>
								<strong>Birthday</strong><br>
								<input type="date" name="bday">
							</div>
							<div>
								<strong>Gender</strong><br>
								<input type="radio" name=<%=WebVariables.GENDER %> value="female">Female
								<input type="radio" name=<%=WebVariables.GENDER %> value="male">Male
							</div>
							<div class="signup-input">
								<strong>Question</strong><br>
								<input type="text" name=<%=WebVariables.QUESTION %>>
							</div>
							<div class="signup-input">
								<strong>Answer</strong><br>
								<input type="text" name=<%=WebVariables.ANSWER %>>
							</div>
							<div>
								<div class="signup-button">
									<input name="submitbutton" type="submit" value="Sign Up">
								</div>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<jsp:include page="JSP-admin/unlogged-footer.jsp"></jsp:include>
	</div>
</body>
</html>