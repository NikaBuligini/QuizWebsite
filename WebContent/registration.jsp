<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Insert title here</title>
	<link rel="stylesheet" type="text/css" href="css/design.css">
</head>
<body>
	<div class="wrapper">
		<div class="header-bar">
			<div class="registration-header-content">
				<img alt="" src="">
				<span class="signin-button">
					<a class="signin-submit signin-submit-button" href="login">Sign In</a>
				</span>
			</div>
		</div>
		<div class="signuppage">
			<h1>Create your Account</h1>
			<div class="sign-up">
				<div class="sign-up-box">
					<form name="createaccount" action="registration" method="post">
						<div class="form-element">
							<fieldset>
								<div>
									<table>
										<tbody>
											<tr class="signup-height">
												<td>
													<strong>Name</strong>
												</td>
											</tr>
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
													<input type="text" name="firstname">
												</td>
												<td>
													<input type="text" name="lastname">
												</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="signup-input">
									<strong>Your email address</strong><br>
									<input type="text" name="email">
								</div>
								<div class="signup-input">
									<strong>Create a password</strong><br>
									<input type="text" name="pass1">
								</div>
								<div class="signup-input">
									<strong>Confirm your password</strong><br>
									<input type="text" name="pass2">
								</div>
								<div>
									<strong>Birthday</strong><br>
									<input type="text" name="month">
									<input type="text" name="day">
									<input type="text" name="year">
								</div>
								<div>
									<strong>Gender</strong><br>
									<input type="radio" name="sex" value="female">Female
									<input type="radio" name="sex" value="male">Male
								</div>
								<div>
									<input name="submitbutton" type="submit" value="Sign Up">
								</div>
							</fieldset>
						</div>
					</form>
				</div>
			</div>
		</div>
		<div></div>
	</div>
</body>
</html>