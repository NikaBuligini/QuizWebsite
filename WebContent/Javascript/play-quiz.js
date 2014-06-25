/**
 * 
 */
$(document).ready(function() {
	
	for (var i=0; i<10; i++) {
		$('#next' + i).val(i);
		
		if (page){
			if (i != 1) {
				$('#question' + i).addClass('none');
			}
			
			$('#next' + i).click(function() {
				var index = $(this).val();
				if ($('#correct' + index) == $('#answer' + index)) {
					$('#score').text('swori pasuxli');
				}
				$('#question' + index).removeClass('none');
				if (index == 9) {
					$('#score').removeClass('none');
				}
			});
		} else {
			$('#next' + i).click(function() {
				var index = $(this).val();
				if ($('#correct' + index) == $('#answer' + index)) {
					$('#score').text('swori pasuxli');
				}
				$('#question' + index+1).addClass('none');
				if (index == 9) {
					$('#score').removeClass('none');
				}
			});
		}
		
	}
	
});