/**
 * 
 */
$(document).ready(function() {
	$('#edit-email').click(function() {
		$('#edit-email').addClass('none');
		$('#email-res').removeClass('none');
		$('#email-res').addClass('block');
	});
	
	$('#change-passwd').click(function() {
		$('#change-passwd').addClass('none');
		$('#passwd-res').removeClass('none');
		$('#passwd-res').addClass('block');
	});
	
	$('#change-fname').click(function() {
		$('#change-fname').addClass('none');
		$('#fname-res').removeClass('none');
		$('#fname-res').addClass('block');
	});
	
	$('#change-lname').click(function() {
		$('#change-lname').addClass('none');
		$('#lname-res').removeClass('none');
		$('#lname-res').addClass('block');
	});
	
	
	$('#change-email-button').click(function() {
		var newEmail = $('#new-email').val();
		if (newEmail.length > 0){
			
		}
	});
	
});