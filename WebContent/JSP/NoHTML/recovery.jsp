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
	System.out.println(mail);
	String[] list = AccountManager.getRecovery(con, mail);
	if(list == null){
		System.out.println("araa");
	%>
		<div> 
			<label> wrong email, go back and try again </label>
			<div>
				<a href = "">go back</a>
			</div>
					
		</div>
	<%
	}else{
		for(int i=0; i<4;i++)
			System.out.println("val = " + list[i]);
	}
	%>
 	<div>
 	
 	</div>
</html>
