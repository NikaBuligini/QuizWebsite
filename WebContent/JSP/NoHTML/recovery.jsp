<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
	ServletContext context = getServletConfig().getServletContext();
	Connection con = (Connection) context.getAttribute("connection");
	
	String mail = request.getParameter("email");
	String[] list = AccountManager.getRecovery(con, mail);
	if(list == null){
	%>
		<div> 
			<label> wrong email, go back and try again.. </label>
			<div>
				<a href = "http://localhost:8080/QuizWebsite/login">go back</a>
			</div>		
		</div>
	<%
	}else{
	%>
		<div>
			<label> Please, answer the question below</label>
			<p><%=list[0] %></p>
			<input id="question-input" type="text" placeholder="Answer" class="email-input">
			<button id="question-button" class="submit-button">Submit</button>
			
		</div>
	<%
	}
	%>
 	<div>
 	
 	</div>
</html>
