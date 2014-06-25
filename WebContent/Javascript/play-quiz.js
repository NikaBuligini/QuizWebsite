/**
 * 
 */
$(document).ready(function() {
	
	for (var i=0; i<10; i++) {
		$('#next' + i).val(i);
		
		if (page){
			$('#next' + i).click(function() {
				var index = $(this).val();
				if ($('#correct' + index).val() == $('#answer' + index).val()) {
					$('#score').text('swori pasuxli');
				}
				$('#question' + index).addClass('none');
				if (index == 9) {
					$('#score').removeClass('none');
				}
			});
		} else {
			if (i != 1) {
				$('#question' + i).addClass('none');
			}
			
			$('#next' + i).click(function() {
				var index = $(this).val();
				if ($('#correct' + index) == $('#answer' + index)) {
					$('#score').text('swori pasuxli');
				}
				$('#question' + index).addClass('none');
				index++;
				$('#question' + index).removeClass('none');
				if (index == 10) {
					$('#score').removeClass('none');
				}
			});
		}
		
	}
	
});