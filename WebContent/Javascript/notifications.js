/**
 * 
 */
$(document).ready(function() {
	$.get('/QuizWebsite/JSP/NoHTML/show-notifications.jsp', { }, function(data) {
		$('#notif-list').html(data);
	});
});

function accept(id, bool, elem) {
	var type = 'fr';
	if (bool)
		type = 'ch';
	
	$.post('/QuizWebsite/notifications', { id:id, type:type, com:'accept' }, function(data) {
		$(elem).html("<p>removed</p>");
	});
}

function decline(id, bool, elem) {
	var type = 'fr';
	if (bool)
		type = 'ch';
	
	$.post('/QuizWebsite/notifications', { id:id, type:type, com:'decline' }, function(data) {
		$(elem).html("<p>removed</p>");
	});
}