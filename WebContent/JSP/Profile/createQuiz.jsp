<%@page import="servlets.CreateQuizServlet"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Create Quiz</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/header-footer.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/profile-style.css">
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/createQuiz.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="create-quiz">
			<div class="form-background create-content">
				<form action="/QuizWebsite/create" method="post">
					<ul>
						<li>
							<div class="li-content">
								<div class="input-title">
									<strong>Title:</strong>
								</div>
								<div class="input-content">
									<input type="text" name="<%=CreateQuizServlet.TITLE %>" class="title">
								</div>
							</div>
						</li>
						<li>
							<div class="descrip-div">
								<div class="input-title">
									<Strong>Description:</Strong>
								</div>
								<div class="input-content">
									<textarea name="<%=CreateQuizServlet.DESCRIPTION %>" class="description"></textarea>
								</div>
							</div>
						</li>
						<li>
							<div class="li-content">
								<div class="input-title">
									<Strong>Category:</Strong>
								</div>
								<div class="input-content">
									<select name="<%=CreateQuizServlet.CATEGORY %>">
										<option value="sport">Sport</option>
										<option value="iq">IQ</option>
										<option value="movies">Movies</option>
										<option value="books">Books</option>
										<option value="knowledge">Knowledge</option>
										<option value="other">Other</option>
									</select>
								</div>
							</div>
						</li>
						<li>
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
						<li>
							<div class="li-content">
								<div class="input-title">
									<Strong>Immediate Correction:</Strong>
								</div>
								<div class="input-content">
									<input type="checkbox" name="<%=CreateQuizServlet.CORRECTION %>" value="y">
								</div>
							</div>
						</li>
						<li>
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
						<li>
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
						<li>
							<div class="li-content">
								<div class="input-title">
									<Strong>Type:</Strong>
								</div>
								<div class="input-content">
									<select name="<%=CreateQuizServlet.TYPE %>">
										<option value="multiple">Multiple Choice</option>
										<option value="questionResponse">Question-Response</option>
										<option value="fillInTheblank">Fill in the blank</option>
										<option value="pictureResponse">Picture Response</option>
									</select>
								</div>
							</div>
						</li>
					</ul>
					<input type="submit" value="Next" class="next-button">
				</form>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript"
		src="<%=request.getContextPath()%>/Javascript/profile-header.js"></script>
</body>
</html>