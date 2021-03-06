<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
	<div class="header">
		<div class="inner-header">
			<div class="logo">
				<a href="profile">
					<span>Quizz</span>
				</a>
			</div>
			<ul class="nav-list">
				<%
				Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
				Cookie userCookie = CookiesManager.getCookie(request, WebVariables.COOKIE_USER);
				String username = userCookie.getValue();
				
				User e = AccountManager.getUser(con, username);
				%>
				<li class="hover" id="home-li">
					<div id="counts" style="display: none;"></div>
					<a id="home" href="/QuizWebsite/notifications" class="nav-item" class="nav-item">
						<strong id="h-t">Home</strong>
					</a>
					<div id="nav-home" class="nav-h">
						<div class="content">
							<ul class="list">
								<li id="notif">
									<a href="/QuizWebsite/notifications" id="f-t">Friend Request</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="/QuizWebsite/notifications">Challenges</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="#">Messages</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<li class="hover">
					<a id="prof" href="/QuizWebsite/view?p=<%=e.getID() %>" class="nav-item" onmouseover="mopen('nav-profile', 'prof')" onmouseout="mclosetime()">
						<strong><%=e.getFirstName() %></strong>
					</a>
					<div id="nav-profile" class="nav-p" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<div class="content">
							<ul class="list">
								<li>
									<a href="#">Your content</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="/QuizWebsite/view?p=<%=e.getID() %>">Profile</a>
								</li>
								<li>
									<a href="#">Stats</a>
								</li>
								<li>
									<a href="/QuizWebsite/settings">Settings</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="/QuizWebsite/logout">Logout</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
				<a id="addQuiz" href="/QuizWebsite/create" class="add-quiz">Add Quiz</a>
			</ul>
			<div class="search-bar">
				<span class="search-logo"></span>
				<input id="search-input" type="text" value="" name=<%=WebVariables.SEARCH %> autocomplete="off" placeholder="Search for quizes and users">
				<div id="results" class="search-result search-hidden"></div>
			</div>
		</div>
	</div>
</body>
</html>