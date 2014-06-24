<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	String count = request.getParameter("count");
	String index = request.getParameter("index");
	%>
	<div class="answer-full-row">
		<label class="answer-empty-label"> </label>
		<div class="answer-input">
			<input type="text" name="answer<%=index %>" placeholder="Answer <%=count %>" autocomplete="off">
			<input type="radio" name="radio<%=index %>">
		</div>
	</div>

</body>
</html>