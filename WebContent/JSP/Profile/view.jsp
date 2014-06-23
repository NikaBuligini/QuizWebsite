<%@page import="model.User"%>
<%@page import="model.WebVariables"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
User c = (User)request.getAttribute("user");

String name = "No result";
if (c != null)
	name = c.getFirstName() + " " + c.getLastName();
%>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title><%=name %></title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<%
		if(c != null){
		%>
		<div class="view-content">
			<div class="profile">
				<div class="header-cont">
					<div class="username">
						<h1><%=c.getFirstName() + " " + c.getLastName() %></h1>
					</div>
					<div class="friends-info">
						<span id="fr">
							
						</span>
					</div>
				</div>
				<div class="profile-feed">
					<div class="left-prof">
						<div class="photo">
							<img src="">
						</div>
						<div id="profile-info" class="row section"></div>
						<div id="profile-nav" class="row section"></div>
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
		<%
		} else {
		%>
		<div class="view-content">
			<h1 class="view-no-result">No Such User</h1>
		</div>
		<%
		}
		%>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<%
		if (c != null){
		%>
	<script type="text/javascript">
		var id = '<%=c.getID() %>';
	</script>		
		<%
		}
	%>
	<script type="text/javascript" src="/QuizWebsite/Javascript/view.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
</body>
</html>