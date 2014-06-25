<%@page import="model.AccountManager"%>
<%@page import="model.WebVariables"%>
<%@page import="model.FriendManager"%>
<%@page import="model.AchievementManager"%>
<%@page import="model.Manager"%>
<%@page import="java.util.ArrayList" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.sql.Connection"%>
    <%@page import="model.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
Connection con = (Connection) config.getServletContext().getAttribute(WebVariables.CONNECTION);
String s = request.getParameter(WebVariables.VIEW);
int ID = Integer.parseInt(s);
ArrayList<ArrayList<Object>> arrAchiev = AchievementManager.totalAchievements(con);
int achievementsDone = AchievementManager.numOfAchievements(con,ID);
int friends = FriendManager.getFriends(con,ID).size();
int tmp =0;
int progress = 0;
ArrayList<Object> arrQuizes = AccountManager.getSingleColumn(con, "playedQuizes", ID, 2);

%>


<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" type="text/css" href="/QuizWebsite/css/design.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
</head>
<body>
	<h1>Achievements - You've earned <%= achievementsDone+ "/" + arrAchiev.size()%> achievements.</h1>
	<div id="achievements">
		<% for(int i=0; i<arrAchiev.size();i++){
			if(i < 6 && i > 2){
				tmp = i - 3;	
			}else if(i < 9 && i > 5){
				tmp = i - 6;
			}else{
				tmp = i;
			}
			if(i%3 == 0){
		%>
			<br></br>
		<%
			} 
		%>
		<div class="achievement">
			<div class="achievementImage">
		<%
			if(((achievementsDone>=(tmp*5+1))&&(i < 3)) || 
					(i==arrAchiev.size()-1) || 
					((friends>=(tmp*5+1))&&(i < 6)&&(i > 2)) ||
					(arrQuizes.size()>=(tmp*5+1)&&(i<9)&&(i>5))){
				progress = 100;
		%>
			<img src = "<%= arrAchiev.get(i).get(3)%>">
		<%
			
			}else{
				if(i < 3)
					progress = achievementsDone*100/(tmp*5+1);
				if(i<6 && i >3)
					progress = friends*100/(tmp*5+1);
		%>
				<img src ="http://www.clipartbest.com/cliparts/4i9/aEB/4i9aEBEiE.jpeg">
		<% 
			}
		%>
				
			</div>
			<div class="achievementInfo">
				<div><%= arrAchiev.get(i).get(2) %></div>
				<div class= "progressContainer">
					<div class="progressBar" style="width:<%=progress%>%;"></div>
				</div>
				<div> <%=progress%>%</div>
				<div><%=arrAchiev.get(i).get(1)%></div>
			</div>
		</div>
		
		<% } %>
	</div>
</body>
</html>