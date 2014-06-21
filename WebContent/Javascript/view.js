/**
 * 
 */
var id = $('#id').text();
$.get('http://localhost:8080/QuizWebsite/JSP/NoHTML/check-friendship.jsp', { id: id}, function(data) {
	$('#fr').html(data);
});

function sendRequest() {
	$.get('http://localhost:8080/QuizWebsite/JSP/NoHTML/add-friend.jsp', { id: id }, function() {
		
	});
	$('#add').attr({
		value: 'Request Sent',
		disabled: 'disabled'
	});
	$('#add').css({
		'background': '#fff',
		'cursor': 'auto'
	});
}


$(document).ready(function() {
	
	
	
	$('#add').click(function() {
		$.get('http://localhost:8080/QuizWebsite/JSP/NoHTML/add-friend.jsp', { id: id }, function() {
			
		});
		$('#add').attr({
			value: 'Request Sent',
			disabled: 'disabled'
		});
		$('#add').css({
			'background': '#fff',
			'cursor': 'auto'
		});
	});
	
	
});
