/**
 * 
 */
var match = false;
var gender = false;

function checkfname(){
	checkField("fname", "fname-alert");
}

function checklname(){
	checkField("lname", "lname-alert");
}

function checkemail(){
	checkField("email", "email-alert");
}

function checkRadio(){
	gender = true;
}

function checkPass(){
	document.getElementById("passwd-alert").style.visibility = 'visible';
	if (document.getElementById("passwd").value != document.getElementById("conpasswd").value){
		document.getElementById("passwd-alert").innerHTML = "Passwords don't match.";
		match = false;
	} else {
		document.getElementById("passwd-alert").style.visibility = 'hidden';
		match = true;
	}
}

function checkField(id, alert){
	if (document.getElementById(id).value.length == 0)
		document.getElementById(alert).style.visibility = 'visible';
	else
		document.getElementById(alert).style.visibility = 'hidden';
}

function fullCheck(form){
	var correct = true;
	if (form.fname.value.length == 0 || form.lname.value.length == 0 || form.email.value.length == 0)
		correct = correct && false;
	
	if (correct && match && gender)
		document.getElementById("signup").submit();
}