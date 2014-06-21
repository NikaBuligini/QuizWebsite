/**
 * 
 */
var id = $('#id').text();
$.get('/QuizWebsite/JSP/NoHTML/check-friendship.jsp', { id: id}, function(data) {
	$('#fr').html(data);
});
	
function sendRequest() {
	$.get('/QuizWebsite/JSP/NoHTML/add-friend.jsp', { id: id }, function() {
		$('#add').attr({
			value: 'Request Sent',
			disabled: 'disabled'
		});
		$('#add').removeClass('add-friend');
		$('#add').addClass('is-friend');
	});
}



$(document).ready(function() {
	
	
	$('#add').click(function() {
		sendRequest();
	});
});
