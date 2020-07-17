$('#password, #confirm_password').on('keyup', function() {
	if ($('#password').val() == $('#confirm_password').val()) {
		$('#message').html('Matching').css('color', 'green');
	} else
		$('#message').html('Not Matching').css('color', 'red');
});


$(document).ready(function(){
	$('#userName').change(function(){

     		$.ajax({
       			type:'POST',
                data:{userName: $('#userName').val()},
                url:'UserNameCheck',
                success:function(result){
             	$('#result').html(result);
                }
           });
	});
});