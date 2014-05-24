<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="login_menu">
		<div class="menubar_container">
			<div class="topPanel">
				<a class="lfloat" href="/" title="Go to main page"> <i> </i>
				</a>
				<div class="rfloat">
					<form action="login" method="post">
						<table>
							<tbody>
								<tr>
									<td><label>User</label></td>
									<td><label>Password</label></td>
								</tr>
								<tr>
									<td><input type="text" name="user"></td>
									<td><input type="password" name="pass"></td>
									<td><input type="submit" value="Log In"></td>
								</tr>
								<tr>
									<td><input type="checkbox" name="persistent"> <label>Keep
											me logged in</label></td>
									<td><a href="">Forgot your password?</a></td>
								</tr>
							</tbody>
						</table>
					</form>
				</div>
			</div>
			<div></div>
		</div>
	</div>
</body>
</html>