<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<%@page import="model.DBConnection"%>
<%@page import="model.SQLTest"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>QuizWebsite.com - პარამეტრების შეცვლა</title>
<h2>QuizWebsire--Security</h2>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/design.css">


<%
	User currUser = (User) (request.getSession().getAttribute("user"));
%>
</head>
<body style="background-color: #C2CFDF;">
<body>
	<div class="topbar">
		<li class=><a href="#">Mail</a></li>
		<button onclick="showForm(event)">edit</button>
		<form action="demo_form.asp" style="display: none" id="myForm"
			onsubmit="return validateForm(event)">
			current email: <input type="text" name="oldemail" value=""><br>
			New email: <input type="text" name="email" value=""><br>
			New email: <input type="text" name="email1" value=""><br>
			<input type="submit" value="Submit">
		</form>
		<br> <br>


		<li><a href="#">password</a></li>
		<button onclick="showForm(event)">edit</button>
		<form action="demo_form.asp" style="display: none" id="myForm"
			onsubmit="return validateForm(event)">
			old password: <input type="text" name="oldpassword" value=""><br>
			New password: <input type="text" name="password" value=""><br>
			Re-Type password: <input type="text" name="password1" value=""><br>
			<input type="submit" value="Submit">
		</form>
		<br> <br>


		<li><a href="#">Name</a></li>
		<button onclick="showForm(event)">edit</button>
		<form action="demo_form.asp" style="display: none" id="myForm"
			onsubmit="return validateForm(event)">
			old Name: <input type="text" name="oldName" value=""> <br>
			Name: <input type="text" name="Name" value=""><br>
			Re-Type name: <input type="text" name="name1" value=""><br>
			<input type="submit" value="Submit">
		</form>
		<br> <br>


		<li><a href="#">Lastname</a></li>
		<button onclick="showForm(event)">edit</button>
		<form action="demo_form.asp" style="display: none" id="myForm"
			onsubmit="return validateForm(event)">
			old Lastname: <input type="text" name="oldLastname" value=""><br>
			old Lastname: <input type="text" name="lastname" value=""><br>
			New Lastname: <input type="text" name="lastname1" value=""><br>
			<input type="submit" value="Submit">
		</form>
		<br> <br>


	</div>
	<br>
	<br>
	<br>
	<br>
	<h5>
		<a href="http://localhost:8080/QuizWebsite" target="_blank"> Visit
			Quiz Web Site!</a>
	</h5>

	<script type="text/javascript">
		function showForm(e) {
			e.target.style.display = "none";
			hideAll();
			e.target.nextSibling.nextSibling.style.display = "block";

		}
		function hideAll() {
			var forms = document.getElementsByTagName("form");
			for (var i = 0; i < forms.length; i++) {
				forms[i].style.display = "none";
			}
		}
		function validateForm(e) {
			//alert(e.target.childNodes[7]);
			//alert(e.target.childNodes.length);
			var inputs = e.target.getElementsByTagName("input");
			var count = inputs.length;
			var email = inputs[count - 3].value;
			var email1 = inputs[count - 2].value;
			if (email != email1 || email == "") {
				alert("ველები ან ცარიელია ან ერთამენთს არ ემთხვევა");
				return false;
			}
		}
	</script>
	<div></div>
</body>
</html>