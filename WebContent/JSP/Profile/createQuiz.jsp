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
		<div class="create-quiz">
			<%
			if (c == null){
			%>
			<div class="form-background create-content">
				<form id="create" action="/QuizWebsite/create" method="post">
					<ul>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<strong>Title:</strong>
								</div>
								<div class="input-content">
									<input id="title" type="text" name="<%=CreateQuizServlet.TITLE %>" class="title" autocomplete="off">
								</div>
							</div>
						</li class="start-li">
						<li>
							<div class="descrip-div">
								<div class="input-title">
									<Strong>Description:</Strong>
								</div>
								<div class="input-content">
									<textarea id="description" name="<%=CreateQuizServlet.DESCRIPTION %>" class="description"></textarea>
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Category:</Strong>
								</div>
								<div class="input-content">
									<select name="<%=CreateQuizServlet.CATEGORY %>">
										<option value="<%=CreateQuizServlet.CATEGORY_SPORT %>">Sport</option>
										<option value="<%=CreateQuizServlet.CATEGORY_IQ %>">IQ</option>
										<option value="<%=CreateQuizServlet.CATEGORY_MOVIES %>">Movies</option>
										<option value="<%=CreateQuizServlet.CATEGORY_BOOKS %>">Books</option>
										<option value="<%=CreateQuizServlet.CATEGORY_KNOWLEDGE %>">Knowledge</option>
										<option value="<%=CreateQuizServlet.CATEGORY_OTHER %>">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Order:</Strong>
								</div>
								<div class="input-content">
									<input type="checkbox" name="<%=CreateQuizServlet.RANDOM %>" value="y">
									<label>Random</label>
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Immediate Correction:</Strong>
								</div>
								<div class="input-content">
									<input type="checkbox" name="<%=CreateQuizServlet.CORRECTION %>" value="y">
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Appearance:</Strong>
								</div>
								<div class="input-content">
									<input type="checkbox" name="<%=CreateQuizServlet.ONE_PAGE %>" value="y">
									<label>One page</label>
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Practice Mode:</Strong>
								</div>
								<div class="input-content">
									<input type="checkbox" name="<%=CreateQuizServlet.PRACTICE %>" value="y">
									<label>Allow practice mode</label>
								</div>
							</div>
						</li>
						<li class="start-li">
							<div class="li-content">
								<div class="input-title">
									<Strong>Type:</Strong>
								</div>
								<div class="input-content">
									<select name="<%=CreateQuizServlet.TYPE %>">
										<option value="<%=CreateQuizServlet.TYPE_MULTIPLE_CHOICE %>">Multiple Choice</option>
										<option value="<%=CreateQuizServlet.TYPE_QUESTION_RESPONCE %>">Question-Response</option>
										<option value="<%=CreateQuizServlet.TYPE_FILL %>">Fill in the blank</option>
										<option value="<%=CreateQuizServlet.TYPE_PICTURE %>">Picture Response</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
					<input id="createButton" type="button" value="Next" class="next-button">
				</form>
			</div>
			<%
			} else {
			%>
			<div class="create-questions form-background">
				<form id="createQuestions" action="/QuizWebsite/newQuiz" method="post">
					<div class="create-head">
						<strong>Data</strong>
					</div>
					<ul class="data-ul" id="questions">
						<li class="li">
							<div class="question-header">
								<span>1.</span>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="text-span">Hint</span>
								</div>
								<div class="hint-input">
									<input type="text" class="input" name="hint1">
								</div>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="tet-span">Answer</span>
								</div>
								<div class="hint-input">
									<input type="text" class="answer-input" name="answer1">
								</div>
							</div>
						</li>
						<li class="li">
							<div class="question-header">
								<span>2.</span>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="text-span">Hint</span>
								</div>
								<div class="hint-input">
									<input type="text" class="input" name="hint2">
								</div>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="tet-span">Answer</span>
								</div>
								<div class="hint-input">
									<input type="text" class="answer-input" name="answer2">
								</div>
							</div>
						</li>
						<li class="li">
							<div class="question-header">
								<span>3.</span>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="text-span">Hint</span>
								</div>
								<div class="hint-input">
									<input type="text" class="input" name="hint3">
								</div>
							</div>
							<div class="row-bar">
								<div class="text">
									<span class="tet-span">Answer</span>
								</div>
								<div class="hint-input">
									<input type="text" class="answer-input" name="answer3">
								</div>
							</div>
						</li>
					</ul>
					<div class="create-footer">
						<input type="button" value="Add" id="add" class="add-button">
						<input type="text" value="3" id="index" class="count" name="count">
						<input type="button" value="Finish" id="finish" class="finish-button">
					</div>
				</form>
			</div>
			<%
			}
			%>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
	<%
	if (c != null){
	%>
	<script type="text/javascript">
		var type = '<%=c.getType() %>';
	</script>
	<%
	}
	%>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/create-quiz.js"></script>
</body>
</html>