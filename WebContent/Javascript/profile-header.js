/**
 * 
 */
$(document).ready(function() {

});


$('#home').mouseover(function() {
	mopen('nav-home', 'home');
});

$('#home').mouseout(function() {
	mclosetime();
});

$('#nav-home').mouseover(function() {
	mcancelclosetime();
});

$('#nav-home').mouseout(function() {
	mclosetime();
});



var timeout	= 500;
var closetimer	= 0;
var ddmenuitem	= 0;
var button = 0;

// open hidden layer
function mopen(id, buttonId)
{	
	// cancel close timer
	mcancelclosetime();
	
	button = document.getElementById(buttonId);
	
	// close old layer
	if(ddmenuitem){
		ddmenuitem.style.visibility = 'hidden';
		button.style.backgroundColor = '#ACACAC';
		button.style.color = 'white';
	}

	// get new layer and show it
	ddmenuitem = document.getElementById(id);
	button = document.getElementById(buttonId);
	ddmenuitem.style.visibility = 'visible';
	button.style.backgroundColor = '#ACACAC';
	button.style.color = 'white';

}
// close showed layer
function mclose()
{
	if(ddmenuitem){
		ddmenuitem.style.visibility = 'hidden';
		
		var home = document.getElementById('home');
		
		home.style.backgroundColor = '#eaeaea';
		home.style.color = '#333';
		
		var profile = document.getElementById('prof');
		
		profile.style.backgroundColor = '#eaeaea';
		profile.style.color = '#333';
	}
}

// go close timer
function mclosetime()
{
	closetimer = window.setTimeout(mclose, timeout);
	
	var home = document.getElementById('home');
	
	home.style.backgroundColor = '#eaeaea';
	home.style.color = '#333';
	
	var profile = document.getElementById('prof');
	
	profile.style.backgroundColor = '#eaeaea';
	profile.style.color = '#333';
}

// cancel close timer
function mcancelclosetime()
{
	if(closetimer)
	{
		window.clearTimeout(closetimer);
		closetimer = null;
	}
}

// close layer when click-out
document.onclick = mclose; 
