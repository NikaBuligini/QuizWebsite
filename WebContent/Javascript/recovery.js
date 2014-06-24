/**
 * 
 */
$(document).ready(function() {
	
	$('#email-button').click(function() {
		var value = $('#email-input').val();
		if (value.length > 0) {
			$.post('/QuizWebsite/JSP/NoHTML/recovery.jsp', { email: value }, function(data) {
				$('#recovery-result').html(data);
			});
		} else {
			alert("Empty email field");
		}
	});
	
	
});