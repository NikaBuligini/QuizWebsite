/**
 * 
 */

$(document).ready(function() {
	
	$('#question-button').click(function() {
		var value = $('#question-input').val();
		if (value.length > 0) {
			$.post('/QuizWebsite/JSP/NoHTML/recoveryQuestion.jsp', { answer: value }, function(data) {
				$('#recovery-result').html(data);
			});
		} else {
			alert("Empty answer field");
		}
	});
	
	
});