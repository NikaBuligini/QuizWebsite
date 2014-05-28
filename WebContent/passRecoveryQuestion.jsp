<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Recovery Question</title>
</head>
<body>
	<form action="PassRecoveryQuestion" method="post">
		<h1>Please, Answer the Question below: </h1>
		<br>
		<p>  <%= request.getAttribute("recoveryQuestion")%> </p>
		<p> Answer: <input type = text name = "answer" size = 25> </p>
		<p> <input type="submit" value="Submit"></p>
	
	</form>
</body>
</html>