<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/createQuiz.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="background">
		<div id="createQuizDiv">
			<table style="border: 1px solid #000000; BACKGROUND-COLOR: #33FF99;"
				cellspacing=5 cellpadding=5>
				<tr>
					<td>Title:</td>
					<td><input type=text name=titel size=50 value=""></td>
				</tr>
				<tr>
				<tr>
					<td>Description: &#160; &#160; &#160; &#160;</td>
					<td><textarea name=einleitung cols=50 rows=4></textarea></td>
				</tr>
				<tr>
					<td>Category:</td>
					<td><select>
							<option value="sport">Sport</option>
							<option value="iq">IQ</option>
							<option value="movies">Movies</option>
							<option value="books">Books</option>
							<option value="knowledge">Knowledge</option>
							<option value="other">Other</option>
					</select></td>
				</tr>
				<tr>
					<td>Order:</td>
					<td><select>
							<option value="random">Random</option>
							<option value="same">Always Same</option>
					</select></td>
				</tr>
				<tr>
					<td>Immediate Correction:</td>
					<td><select>
							<option value="yes">Yes</option>
							<option value="no">No</option>
					</select></td>
				</tr>
				<tr>
					<td>Appearance:</td>
					<td><select>
							<option value="onePage">One Page</option>
							<option value="multiplePages">Multiple Pages</option>
					</select></td>
				</tr>
				<tr>
					<td>Practice Mode:</td>
					<td><select>
							<option value="yes">Yes</option>
							<option value="no">No</option>
					</select></td>
				</tr>
				<tr>
					<td>Type:</td>
					<td><select>
							<option value="multiple">Multiple Choice</option>
							<option value="questionResponse">Question-Response</option>
							<option value="fillInTheblank">Fill in the blank</option>
							<option value="pictureResponse">Picture Response</option>
					</select></td>
				</tr>
			</table>
			<script>
			alert("e");
			var id = document.getElementById("Type");
			var e = id.options[id.selectedIndex].value;
			alert("e");
			</script>
			<input type=submit class=button id="createQuiz" value=Next
				onclick="window.location = 'questionInputs.jsp'"
				style="position: absolute; left: 300px; top: 400px;">
			<P>
		</div>
	</div>
	<script type="text/javascript"
		src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript">
		/*	$(document).ready(function() {
				$('#createQuiz').click(function() {
					$('#createQuizDiv').html("<h1>hi</h1>");
				});
			});
		
		 */
	</script>
</body>
</html>