<%@page import="model.User"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
User c = (User)request.getAttribute("user");
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><%=request.getParameter(WebVariables.VIEW) %></title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="view-content">
			<div class="profile">
				<div class="header-cont">
					<div class="username">
						<h1><%=c.getFirstName() + " " + c.getLastName() %></h1>
					</div>
					<div class="friends-info">
						<span>
							<a id="friends" class="friends-button" href="#">
								Friends
								<span class="count">0</span>
							</a>
							<input type="button" id="add" value="Add Friend" class="add-friend">
						</span>
					</div>
				</div>
				<div class="profile-feed">
					<div class="left-prof">
						<div class="photo">
							<img src="">
						</div>
						<div class="row section">
							<ul class="profile-tabs">
								<li>
									<a href="#">About</a>
								</li>
								<li>
									<a href="#">Friends</a>
									<span class="count">0</span>
								</li>
								<li>
									<a href="#">Quizzes</a>
									<span class="count">0</span>
								</li>
								<li>
									<a href="#">Achievements</a>
									<span class="count">0</span>
								</li>
							</ul>
						</div>
						<div id="profile-nav" class="row section">
							<ul class="profile-nav">
								<li>
									<a href="#">Message</a>
								</li>
								<li>
									<a href="#">Block <%=c.getFirstName() %></a>
								</li>
								<li>
									<a href="#">Unfriend <%=c.getFirstName() %></a>
								</li>
								<li>
									<a href="#">Report</a>
								</li>
							</ul>
						</div>
					</div>
					<div class="right-prof">
						<div class="profile-feed-header">
							<div class="line"></div>
						</div>
						<div class="feed-content">
							<div>
								<div class="feed-row">
									<div class="feed-item">
										Test
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		if(true) {
			$('#profile-nav').css({
				"display": "none"
			});
			$('#friends').css({
				"display": "none"
			});
		}
	</script>
</body>
</html>