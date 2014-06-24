<%@page import="model.Quiz"%>
<%@page import="servlets.CreateQuizServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Quiz c = (Quiz)request.getAttribute("quiz");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Create Quiz</title>
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/design.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/profile-style.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/createQuiz.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="quiz-content">
			<div class="quiz-nav">
				<span class="start-nav"></span>
				<span id="quiz-info-title" class="nav-item nav-marked">Quiz Info</span>
				<span id="data-title" class="nav-item">Data</span>
				<span class="rest-nav"></span>
			</div>
			<div class="quiz-bar">
				<form id="newQuiz" action="/QuizWebsite/create" method="post">
					<div id="quiz-info" class="">
						<div class="row">
							<label class="label">Title</label>
							<input id="title" name="title" type="text" class="input" placeholder="Quiz Name" autocomplet="off">
						</div>
						<div class="row">
							<label class="label">Description</label>
							<textarea id="description" rows="5" cols="50" name="description" class="textarea" placeholder="Enter Quiz Description"></textarea>
						</div>
						<div class="row">
							<label class="label">Category</label>
							<select name="<%=CreateQuizServlet.CATEGORY %>" class="select">
								<option value="<%=CreateQuizServlet.CATEGORY_SPORT %>">Sport</option>
								<option value="<%=CreateQuizServlet.CATEGORY_IQ %>">IQ</option>
								<option value="<%=CreateQuizServlet.CATEGORY_MOVIES %>">Movies</option>
								<option value="<%=CreateQuizServlet.CATEGORY_BOOKS %>">Books</option>
								<option value="<%=CreateQuizServlet.CATEGORY_KNOWLEDGE %>">Knowledge</option>
								<option value="<%=CreateQuizServlet.CATEGORY_OTHER %>">Other</option>
							</select>
						</div>
						<div class="row">
							<label class="label"> </label>
							<label class="checkbox-label">Random Order</label>
							<input type="checkbox" name="random" value="y" class="checkbox">
						</div>
						<div class="row">
							<label class="label"> </label>
							<label class="checkbox-label">Immediate Correction</label>
							<input type="checkbox" name="correction" value="y" class="checkbox">
						</div>
						<div class="row">
							<label class="label"> </label>
							<label class="checkbox-label">Show all Quiz on Single Page</label>
							<input type="checkbox" name="onePage" value="y" class="checkbox">
						</div>
						<div class="footer">
							<span id="next" class="next-span">Next</span>
						</div>
					</div>
					<div id="data" class="none">
						<div id="data-res">
							<div class="row">
								<label class="label">1.</label>
								<input name="question1" type="text" class="question-input" placeholder="Question" autocomplete="off">
								<div class="upload">
									<div class="button-div">
										<span>
											<a id="image1" href="#" class="img-button">Image</a>
											<input id="image-input1" type="text" name="image1" class="none" placeholder="Image URL" autocomplete="off">
										</span>
									</div>
								</div>
								<div id="answer-row1" class="answers-row">
									<span id="count1" class="none">1</span>
									<div class="answer-full-row">
										<label class="answer-label">Answers</label>
										<div class="answer-input">
											<label>
												<input type="text" name="answer1" placeholder="Answer 1" autocomplete="off">
												<input id="radio1" type="radio" name="radio1" class="none" checked="checked">
												<a id="add1" href="#" class="answer-add">Add answer</a>
											</label>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="questions-footer">
							<input id="n-question" type="hidden">
							<label id="add" class="add-span">Add </label>
							<a id="create-quiz" class="quiz-create-button">Create</a>
						</div>
					</div>
				</form>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/create-quiz.js"></script>
</body>
</html>