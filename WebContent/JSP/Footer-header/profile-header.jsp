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
					Cookie userCookie = CookiesManager.getCookie(request, WebVariables.COOKIE_USERNAME);
					String username = userCookie.getValue();
				%>
				<li class="hover">
					<a id="home" href="#" class="nav-item" class="nav-item" onmouseover="mopen('nav-home', 'home')" onmouseout="mclosetime()">
						<strong>Home</strong>
					</a>
					<div id="nav-home" class="nav-h" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<div class="content">
							<ul class="list">
								<li>
									<a href="#">Notifications</a>
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
					<a id="prof" href="#" class="nav-item" onmouseover="mopen('nav-profile', 'prof')" onmouseout="mclosetime()">
						<strong><%=username %></strong>
					</a>
					<div id="nav-profile" class="nav-p" onmouseover="mcancelclosetime()" onmouseout="mclosetime()">
						<div class="content">
							<ul class="list">
								<li>
									<a href="#">Your content</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="#">Profile</a>
								</li>
								<li>
									<a href="#">Stats</a>
								</li>
								<li>
									<a href="#">Settings</a>
								</li>
								<li class="space"></li>
								<li>
									<a href="http://localhost:8080/QuizWebsite/logout">Logout</a>
								</li>
							</ul>
						</div>
					</div>
				</li>
			</ul>
			<div class="search-bar">
				<form id="search-form" action="<%=request.getContextPath() %>/search" onsubmit="">
					<span class="search-logo"></span>
					<input type="text" value="" name=<%=WebVariables.SEARCH %> autocomplete="off" placeholder="Search for quizes and users">
				</form>
			</div>
		</div>
		<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
	</div>
</body>
</html>