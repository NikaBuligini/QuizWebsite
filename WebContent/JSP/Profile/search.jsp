<%@page import="java.util.ArrayList"%>
<%@page import="model.WebVariables"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<title>Search</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="search-content">
			<%
			Object[] results = (Object[]) request.getAttribute(WebVariables.SEARCH_RESULTS);
			String search = (String) request.getAttribute(WebVariables.SEARCH);
			
			if (results == null){
			%>
			<div class="count">
				<span>
					No results found for '<%=search %>'.
				</span>
			</div>
			<%
			} else {
			%>
			<div class="count">
				<span>
					<b><%=results.length %></b> results for <b><%=search %></b>
				</span>
			</div>
			<div class="results">
				<ul>
					<%
					for (int i=0; i<results.length; i++){
					%>
						<li>
							<a href="#">
								<img width="60" height="60" src="<%=request.getContextPath() %>/Images/ghost-person.png">
							</a>
							<div class="bd">
								<h3>
									<a>
										<%=results[i] %>
									</a>
								</h3>
							</div>
						</li>
					<%
					}
					%>
				</ul>
			</div>
			<%
			}
			%>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
</body>
</html>