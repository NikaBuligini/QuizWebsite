<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@page import="java.sql.Connection"%>
<%@page import="model.AccountManager"%>
<%@page import="model.User"%>
<%@page import="model.CookiesManager"%>
<%@page import="model.WebVariables"%>
<%@page import="model.DBConnection"%>
<%@page import="model.SQLTest" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>QuizWebsite.com - პარამეტრების შეცვლა</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/design.css">
	<style>
#changeButton {
	background: #66CCFF;
	padding: 3px 17px;
	color: black;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 15px;
	border-radius: 2px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 0px solid rgb(213, 150, 17);
	cursor: pointer;
}

#changeButton:hover{
	background-color: #3399FF;
	color: black;
}

#backButton {
	background: #A8A8A8;
	padding: 3px 17px;
	color: black;
	font-family: 'Helvetica Neue', sans-serif;
	font-size: 15px;
	border-radius: 2px;
	-moz-border-radius: 4px;
	-webkit-border-radius: 4px;
	border: 0px solid rgb(213, 150, 17);
	cursor: pointer;
}

#backButton:hover{
	background-color: #888888;
	color: black;
}
.fieldSet {
	background-repeat: no-repeat;
	background-image: url(bg.png);
	box-shadow: 0 0 12px #AAAAAA;
	width: 770px;
	margin: auto;
	border-radius: 7px;
}
.field {
	border-radius: 3px;
}
.field:HOVER {
	border-color: #99CCFF;
}
</style>
	
	<%
	
	User currUser = (User)(request.getSession().getAttribute("user"));
	
	
	%>
</head>
<body>

<button onclick="showForm(event)">რედაქტირება</button>
<form action="demo_form.asp" style="display:none" id="myForm" onsubmit="return validateForm()">
ძველი პაროლი:     <input type="text" name="pass" value=""><br>
ახალი პაროლი: 		<input type="text" name="pass" value=""><br>
 გაიმეორეთ პაროლი:  <input type="text" name="pass1" value=""><br>
<br>
User:            <input type="text" name="pass" value=""><br>
New User:        <input type="text" name="pass1" value=""><br>
<br>
old mail:         <input type="text" name="pass" value=""><br>
New mail:         <input type="text" name="pass1" value=""><br>
<br>
<input type="submit" value="Submit">
</form>



<script type="text/javascript">

function showForm(e){
    e.target.style.display = "none";
    document.getElementById("myForm").style.display="block";
}
function validateForm() {
    var pass = document.forms["myForm"]["pass"].value;
    var pass1 = document.forms["myForm"]["pass1"].value;
    if (pass != pass1 || pass == "") {
        alert("ველები ან ცარიელია ან ერთამენთს არ ემთხვევა");
        return false;
    }
}

/*function Passwords() {
	if (document.getElementById("password").value == document.getElementById("pass").value &&
			document.getElementById("password").value.length >= 6) return true;
	return false;
}

function checkOldMail() {
	document.getElementById("mailErrorLabel").innerHTML="";
	var oldmail = document.getElementById("oldmail").value;
	if (oldmail.length == 0) {
		document.getElementById("changeButton").disabled = true;
		return;
	}
	if (checkStarFieldsMatch()) {
		if (checkAllFields()) document.getElementById("changeButton").disabled = false;
		return;
	}
	if (oldMail == '<%=request.getParameter("email")%>') return;
	document.getElementById("mailErrorLabel").innerHTML="შეიყვანეთ სწორი  მეილი!";
	document.getElementById("changeButton").disabled = true;
}*/

</script>
	<div>
	
	</div>
</body>
</html>