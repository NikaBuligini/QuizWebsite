<%@page import="servlets.CreateQuizServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<%
	String index = request.getParameter("index");
	%>
	<div class="row">
		<label class="label"><%=index %>.</label>
		<input name="question<%=index %>" type="text" class="question-input" placeholder="Question" autocomplete="off">
		<div class="upload">
			<div class="button-div">
				<span>
					<a id="image<%=index %>" href="#" class="img-button">Image</a>
					<input id="image-input<%=index %>" type="text" name="image<%=index %>" class="none" placeholder="Image URL" autocomplete="off">
				</span>
			</div>
		</div>
		<div id="answer-row<%=index %>" class="answers-row">
			<span id="count<%=index %>" class="none"></span>
			<div class="answer-full-row">
				<label class="answer-label">Answers</label>
				<div class="answer-input">
					<label>
						<input type="text" name="answer<%=index %>_1" placeholder="Answer 1" autocomplete="off">
						<input id="radio<%=index %>" type="radio" name="radio<%=index %>" value="1" class="none" checked="checked">
						<a id="add<%=index %>" href="#" class="answer-add">Add answer</a>
					</label>
				</div>
			</div>
		</div>
	</div>
</body>
</html>