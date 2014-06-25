<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.CipherPass"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<%
	ServletContext context = getServletConfig().getServletContext();
	Connection con = (Connection) context.getAttribute("connection");
	String mail = request.getParameter("email");
	String[] list = AccountManager.getRecovery(con, mail);
	String answer = request.getParameter("answer");
	
	CipherPass random = new CipherPass();
	String newPass = random.Cipher(list[1]);
	
	if(answer.equals(list[1])){
	%>
		<div>
		<label> your mail is : <%=list[0] %></label> 
		</div>
		<div>
		<label> your new password is : <%= newPass %> </label>
		</div>
		<div>
				<a href = "http://localhost:8080/QuizWebsite/login">go back</a>
		</div>

	<%
	}else{
	%>
		<div> 
			<label> wrong answer, sorry, we cant help you.. </label>
			<div>
				<a href = "http://localhost:8080/QuizWebsite/login">go back</a>
			</div>
		</div>
	<%
	}
	%>
	
</html>