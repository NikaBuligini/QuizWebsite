/**
 * 
 */
var gender = false;

$(document).ready(function() {
	$('#fname').keyup(function() {
		makeBlack('fname-title');
	});

	$('#lname').keyup(function() {
		makeBlack('lname-title');
	});
	
	$('#email').keyup(function() {
		makeBlack('email-title');
		var email = $('#email').val();
		$.post('/QuizWebsite/JSP/NoHTML/check-email.jsp', { email: email }, function(data) {
			$('#email-alert').html(data);
		});
	});
	
	$('#passwd').keyup(function() {
		makeBlack('passwd-title');
	});
	
	$('#conpasswd').keyup(function() {
		makeBlack('conpasswd-title');
	});
	
	$('#submit-button').click(function(form) {
		var allow = true;
		if ($('#fname').val().length == 0) {
			makeRed('fname-title');
			allow = allow && false;
		}
		if ($('#lname').val().length == 0) {
			makeRed('lname-title');
			allow = allow && false;
		}
		if ($('#email').val().length == 0) {
			makeRed('email-title');
			allow = allow && false;
		}
		if ($('#passwd').val().length == 0) {
			makeRed('passwd-title');
			allow = allow && false;
		}
		if (!gender) {
			makeRed('gender-title');
			allow = allow && false;
		}
		if ($('#passwd').val() != $('#conpasswd').val()){
			makeRed('conpasswd-title');
			$("#passwd-alert").css({
				visibility: 'visible'
			});
			$("#passwd-alert").text('Passwords don\'t match');
			allow = allow && false;
		}
		
		if (allow){
			$('#signup').submit();
		}
	});
	
	$('#Email').keypress(function(e) {
		if (e.which == 13) {
			login();
		}
	});
	
	$('#Password').keypress(function(e) {
		if (e.which == 13) {
			login();
		}
	});
	
	$('#SignIn').click(function() {
		login();
	});
});


function makeRed(id){
	$('#' + id).addClass('red-label');
}

function makeBlack(id){
	$('#' + id).removeClass('red-label');
}

function checkRadio(){
	gender = true;
	makeBlack('gender-title');
}

function checkPass(){
	if ($("#passwd").val() == $("#conpasswd").val()){
		$('#passwd-alert').css({
			visibility: 'hidden'
		});
	}
}

function login(){
	if ($('#Email').val().length == 0) {
		$('#alert').text('Enter your username.');
	} else if ($('#Password').val().length == 0) {
		$('#alert').text('Enter your password.');
	} else {
		document.signin.submit();
	}
}
