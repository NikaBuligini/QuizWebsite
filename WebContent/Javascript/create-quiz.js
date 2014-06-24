/**
 * 
 */
$(document).ready(function() {
	var limit = 5;
	var questionLimit = 15;
	var index = 1;
	
	$('#quiz-info-title').click(function() {
		clearMarks();
		$('#quiz-info-title').addClass('nav-marked');
		clearContent();
		$('#quiz-info').removeClass('none');
	});
	
	$('#data-title').click(function() {
		clearMarks();
		$('#data-title').addClass('nav-marked');
		clearContent();
		$('#data').removeClass('none');
	});
	
	function clearMarks() {
		$('#quiz-info-title').removeClass('nav-marked');
		$('#data-title').removeClass('nav-marked');
	}
	
	function clearContent() {
		$('#quiz-info').addClass('none');
		$('#data').addClass('none');
	}
	
	$('#next').click(function() {
		clearMarks();
		$('#data-title').addClass('nav-marked');
		clearContent();
		$('#data').removeClass('none');
	});
	
	$('#count1').val(1);
	$('#add1').val(1);
	$('#image1').val(1);
	
	$('#add1').click(function() {
		var currIndex = $(this).val();
		var count = $('#count' + currIndex).val();
		if (count != limit) {
			if (count == 1) {
				$('#radio' + currIndex).removeClass('none');
			}
			count++;
			$('#count' + currIndex).val(count);
			$.get('/QuizWebsite/JSP/NoHTML/create-answer.jsp', { index: currIndex, count: count }, function(data) {
				$('#answer-row' + currIndex).append(data);
			});
		}
	});
	
	$('#image1').click(function() {
		var currIndex = $(this).val();
		$('#image' + currIndex).addClass('none');
		$('#image-input' + currIndex).removeClass('none');
	});
	
	$('#add').click(function() {
		if (index != questionLimit) {
			index++;
			$.get('/QuizWebsite/JSP/NoHTML/create-question.jsp', { index: index }, function(data) {
				$('#data-res').append(data);
				
				$('#count' + index).val(1);
				$('#add' + index).val(index);
				$('#image' + index).val(index);
				$('#data-res').find('a').unbind();
				
				$('#data-res').find('span').find('a').click(function() {
					var currIndex = $(this).val();
					$('#image' + currIndex).addClass('none');
					$('#image-input' + currIndex).removeClass('none');
				});
				
				$('#data-res').find('label').find('a').click(function() {
					var currIndex = $(this).val();
					var count = $('#count' + currIndex).val();
					if (count != limit) {
						if (count == 1) {
							$('#radio' + currIndex).removeClass('none');
						}
						count++;
						$('#count' + currIndex).val(count);
						$.get('/QuizWebsite/JSP/NoHTML/create-answer.jsp', { index: currIndex, count: count }, function(data) {
							$('#answer-row' + currIndex).append(data);
						});
					}
				});
			});
		}
	});
	
	$('button').unbind();
	$('#create-quiz').click(function() {
		if ($('#title').val().length > 0 && $('#description').val().length > 0) {
			$('#n-question').val(index);
			alert($('#n-question').val());
			$('#newQuiz').submit();
		}
	});
	
});

