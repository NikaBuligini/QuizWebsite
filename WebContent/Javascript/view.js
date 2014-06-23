/**
 * 
 */
$.get('/QuizWebsite/JSP/NoHTML/check-friendship.jsp', { id: id}, function(data) {
	$('#fr').html(data);
});
$.get('/QuizWebsite/JSP/NoHTML/profile-info.jsp', { id: id }, function(data) {
	$('#profile-info').html(data);
});
$.get('/QuizWebsite/JSP/NoHTML/profile-nav.jsp', { id: id }, function(data) {
	$('#profile-nav').html(data);
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

function unfriend() {
	$.get('/QuizWebsite/unfriend', { fr: id }, function(data) {
		location.reload();
	});
}

$(document).ready(function() {
	
	$('#add').click(function() {
		sendRequest();
	});
});
