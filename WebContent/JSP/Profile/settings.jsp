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
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/design.css">


<%
	User currUser = (User) (request.getSession().getAttribute("user"));
%>
</head>
<body>
	<div class="topbar">
		<div class="fill">
			<div class="container">
				<h3>
					<a href="#">QuizWebSite.com--setting</a>
				</h3>
				<ul>


					<li class=><a href="#">Mail</a></li>
					<button onclick="showForm(event)">edit</button>
					<form action="demo_form.asp" style="display: none" id="myForm"
						onsubmit="return validateForm()">
						current email: <input type="text" name="oldemail" value=""><br>
						New email: <input type="text" name="email" value=""><br>
						New email: <input type="text" name="email1" value=""><br>
						<input type="submit" value="Submit">
					</form>

					
					<li><a href="#">password</a></li>
					<button onclick="showForm(event)">edit</button>
					<form action="demo_form.asp" style="display: none" id="myForm"
						onsubmit="return validateForm()">
						old Lastname: <input type="text" name="oldlastname" value=""><br>
						New Lastname: <input type="text" name="lastname" value=""><br>
						<input type="submit" value="Submit">
					</form>


					<li><a href="#">Name</a></li>
					<button onclick="bla(event)">edit</button>
					<form action="demo_form.asp" style="display: none" id="myForm"
						onsubmit="return validateForm()">
						old Name: <input type="text" name="oldname" value=""><br>
						New name: <input type="text" name="name" value=""><br>
						<input type="submit" value="Submit">
					</form>



					<li><a href="#">Lastname</a></li>
					<button onclick="showForm(event)">edit</button>
					<form action="demo_form.asp" style="display: none" id="myForm"
						onsubmit="return validateForm()">
						old Lastname: <input type="text" name="oldlastname" value=""><br>
						New Lastname: <input type="text" name="lastname" value=""><br>
						<input type="submit" value="Submit">
					</form>


					<li><a href="#">date</a></li>
					<button onclick="showForm(event)">edit</button>
					<form action="demo_form.asp" style="display: none" id="myForm1"
						onsubmit="return validateForm()">
						old Lastname: <input type="text"   name="date" value=""><br>
						New Lastname: <input type="text" name="newdate" value=""><br>
						<input type="submit" value="Submit">
					</form>
				</ul>
			</div>
		</div>
	</div>


	<script type="text/javascript">
		function showForm(e) {
			e.target.style.display = "none";
			document.getElementById("myForm").style.display = "block";
		}
		function validateForm() {
			var email = document.forms["myForm"]["email"].value;
			var email1 = document.forms["myForm"]["email1"].value;
			if (email != email1 || email == "") {
				alert("ველები ან ცარიელია ან ერთამენთს არ ემთხვევა");
				return false;
			}
		}
		
		function showForm2(e) {
			e.target.style.display = "none";
			document.getElementById("myForm2").style.display = "block";
		}
		function validateForm() {
			var pass = document.forms["myForm2"]["email"].value;
			var pass1 = document.forms["myForm2"]["email1"].value;
			if (pass != pass1 || pass == "") {
				alert("ველები ან ცარიელია ან ერთამენთს არ ემთხვევა");
				return false;
			}
		}
		
	</script>
	<div></div>
</body>
</html>