<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Create Quiz</title>
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/header-footer.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/profile-style.css">
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/createQuiz.css">
</head>
<body>
	<div class="wrapper">
		<jsp:include page="/JSP/Footer-header/profile-header.jsp"></jsp:include>
		<div class="create-quiz">
			<div class="form-background create-content">
				<form action="" method="post">
					<ul>
						<li>
							<div class="input-title">
								<strong>Title:</strong>
							</div>
							<div class="input-content">
								bz
							</div>
						</li>
						<li>
						
						</li>
						<li>
							<input type="submit" value="Next">
						</li>
					</ul>
				</form>
				
			</div>
			<table class="create-content" cellspacing=5 cellpadding=5>
					<tr>
						<td>
							<Strong>Title:</Strong>
						</td>
						<td>
							<input type=text name=titel size=50 value="">
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Description:</Strong>
						</td>
						<td>
							<textarea name=einleitung cols=50 rows=4></textarea>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Category:</Strong>
						</td>
						<td>
							<select>
								<option value="sport">Sport</option>
								<option value="iq">IQ</option>
								<option value="movies">Movies</option>
								<option value="books">Books</option>
								<option value="knowledge">Knowledge</option>
								<option value="other">Other</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Order:</Strong>
						</td>
						<td>
							<select>
								<option value="random">Random</option>
								<option value="same">Always Same</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Immediate Correction:</Strong>
						</td>
						<td>
							<select>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Appearance:</Strong>
						</td>
						<td>
							<select>
								<option value="onePage">One Page</option>
								<option value="multiplePages">Multiple Pages</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Practice Mode:</Strong>
						</td>
						<td>
							<select>
								<option value="yes">Yes</option>
								<option value="no">No</option>
							</select>
						</td>
					</tr>
					<tr>
						<td>
							<Strong>Type:</Strong>
						</td>
						<td>
							<select>
								<option value="multiple">Multiple Choice</option>
								<option value="questionResponse">Question-Response</option>
								<option value="fillInTheblank">Fill in the blank</option>
								<option value="pictureResponse">Picture Response</option>
							</select>
						</td>
					</tr>
				</table>
				<input type=submit class=button id="createQuiz" value=Next
					onclick="window.location = 'questionInputs.jsp'"
					style="position: absolute; left: 300px; top: 400px;">
				<P>
		</div>
		<jsp:include page="/JSP/Footer-header/footer.jsp"></jsp:include>
	</div>
	<script type="text/javascript" src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
	<script type="text/javascript" src="<%=request.getContextPath() %>/Javascript/profile-header.js"></script>
</body>
</html>