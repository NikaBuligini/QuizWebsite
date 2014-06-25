<%@page import="model.Answer"%>
<%@page import="java.util.ArrayList"%>
<%@page import="model.User"%>
<%@page import="model.AccountManager"%>
<%@page import="model.Quiz"%>
<%@page import="model.QuizManager"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);

String quizStr = request.getParameter("id");
int ID = Integer.parseInt(quizStr);

Quiz c = new Quiz("title", "description", false, false, false, 1, 1);

/*
//Quiz c = QuizManager.getQuizByQuizID(con, ID);
if (c == null)
	return;

if (c.getRandom())
	c.randomizer();*/
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title><%=c.getName() %></title>
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/createQuiz.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/design.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/profile-style.css">
</head>
<body>
	<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
	<div class="play">
		<div class="play-header">
			<div class="full-row bot-margin">
				<div class="user-img">
					<a href="/QuizWebsite/view?p=<%=c.getCreatorID() %>">
						<img src="" class="user-quiz-img">
					</a>
				</div>
				<div class="header-row">
					<label class="quiz-title"><%=c.getName() %></label>
				</div>
				<div class="header-row">
					<label class="quiz-description"><%=c.getDescription() %></label>
				</div>
			</div>
			<div class="play-row">
				<div id="cont" class="play-cont">
					<%
					for (int i=0; i<10; i++){
					%>
					<div id="question<%=i %>">
						<div class="float width question">
							<span>Question</span>
						</div>
						<div class="body">
							<div class="float question-img-div">
								<img src="" class="question-img">
							</div>
							<div class="float answer-div">
								<span class="float answer-width answer-padding">
									<input id="answer<%=i %>" type="text" name="answer1_1" class="input-width">
									<input id="correct<%=i %>" type="hidden" value="<%="pasuxi" %>">
								</span>
							</div>
							<div class="float answer-div">
								<a id="next<%=i %>" class="next-quest" href="#">Next</a>
							</div>
						</div>
					</div>
					<%
					}
					%>
					<h1 id="score" class="none">your score is</h1>
				</div>
			</div>
			<div class="full-row top-border">
				<div class="author">
					<label class="float">By</label>
					<a href="/QuizWebsite/view?p=<%=c.getCreatorID() %>" class="float author-link">
						<%
						User creator = AccountManager.getUser(con, c.getCreatorID());
						%>
						<%=creator.getFirstName() + " " + creator.getLastName() %>
					</a>
				</div>
				<div class="n-play">
					<label class="float">Played <%=0 %> Times</label>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/profile-header.js"></script>
	<script type="text/javascript">
		var correction = false;
		var page = false;
		<%
		if (c.getCorrection()){
		%>
		correction = true;
		<%
		}
		if (c.getOnePage()){
		%>
		page = true;
		<%
		}
		%>
	</script>
	<script type="text/javascript" src="/QuizWebsite/Javascript/play-quiz.js"></script>
</body>
</html>