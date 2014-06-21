<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div id="writeQuestions">
		<table style="border: 1px solid #000000; BACKGROUND-COLOR: #33FF99;"
			cellspacing=5 cellpadding=5>
			<tr>
				<td>Question:</td>
				<td><input type=text name=question size=50 value=""></td>
			</tr>
			<tr>
				<td>Image Link:</td>
				<td><input type=text name=image size=50 value=""></td>
			</tr>
			<tr>
				<td>Answer:</td>
				<td><input type=text name=answer size=50 value=""></td>
			</tr>
		</table>
		<input type=submit class=button id="createQuiz" value=Add
			onclick="window.location = 'questionInputs.jsp'"
			style="position: absolute; left: 250px; top: 150px;">

	</div>
</body>
</html>