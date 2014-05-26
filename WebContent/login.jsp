<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Log In</title>
	<link rel="stylesheet" type="text/css" href="css/design.css">
</head>
<body>
	<h1>Sign in to continue to QuizWebsite</h1>

	<div class=full>
		<div class=registr>
			<div class=image>
				<img alt="unknown" class="image"
					src="https://ssl.gstatic.com/accounts/ui/avatar_2x.png">
				<div class=sign>
					<form action="login" method="post">
						UserName: <input name=user /> <br> Password: <input
							name=pass /> <input type="submit" value="Sign In" /> <br>
					</form>
					<a href="registration">Create new Account</a>
				</div>
			</div>
		</div>
	</div>
</body>
</html>