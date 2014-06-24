/**
 * 
 */
var index = 3;

$('#createButton').click(function() {
	if ($('#title').val().length != 0 && $('#description').val().length != 0){
		$('#create').submit();
	}
});

$('#add').click(function() {
	getQuestion();
});


function getQuestion() {
	index++;
	$.post('/QuizWebsite/JSP/NoHTML/create-question.jsp', { index: index, type: type }, function(data) {
		$('#questions').append(data);
		$('#index').val(index);
	});
}

$('#finish').click(function() {
	$('#createQuestions').submit();
});

