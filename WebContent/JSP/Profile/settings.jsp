<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Settings</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/design.css">
</head>
<body>
	<div>
		<a href="/QuizWebsite/settings?id=1">Remove account</a><br>
		<a href="/QuizWebsite/settings?id=2">Remove quizzes</a><br>
		<a href="/QuizWebsite/settings?id=3">Clear history for Quiz</a><br>
		<a href="/QuizWebsite/settings?id=4">Account administration</a><br>
		<a href="/QuizWebsite/settings?id=5">See Statistics</a><br>
	</div>
</body>
</html>