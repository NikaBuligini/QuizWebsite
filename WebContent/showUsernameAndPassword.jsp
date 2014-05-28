<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Account Recovery</title>
</head>
<body>
	<h1>Account Successfully Recovered</h1>
	<br>
	<p> Your Username is: <%= request.getAttribute("recoveryUsername")%> </p>
	<p> Your Password is: <%= request.getAttribute("recoveryPass") %></p>
	
	<a href = "index.html">Tap To Go Back To Homepage</a>
</body>
</html>