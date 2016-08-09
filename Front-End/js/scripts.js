window.addEventListener('load', function(){
	document.getElementById('btnsubmit').addEventListener('click',function(){
		var email = document.getElementById('email');
		var remail = document.getElementById('remail');

		var password = document.getElementById('password');
		var rpassword = document.getElementById('rpassword');

		var flag=false;
		
		
		
		if (validar()) {
			document.getElementById('formulario').submit();
		}else{
			if(validarEmail()){
				validarPassword();
			}else
				validarEmail();
		}

		
	});

})


function validarEmail(){
	if ((email.length > 0  && remail > 0 ) && email==remail) {
		return true;
	}else{
		if (email != remail) {
			//alert('Los E-Mails no coinciden');
			$("#errors").text("Los E-Mails o los Passwords no coinciden").fadeIn( "slow" );
		}
	}
}

function validarPassword(){
	if ((password.length > 0 && rpassword > 0) && password==rpassword) {
		return true;
	}else{
		if (password != rpassword) {
			//alert('Los Passwords no coinciden');
			$("#errors").text("Los E-Mails o los Passwords no coinciden").fadeIn( "slow" );
		}
	}

}

function validar(){
	if(validarEmail != validarPassword){
		return false
	}
	return(validarEmail == validarPassword);
	
	

	
}

function valida(e){
    tecla = (document.all) ? e.keyCode : e.which;

    //Tecla de retroceso para borrar, siempre la permite
    if (tecla==8){
        return true;
    }
        
    // Patron de entrada, en este caso solo acepta numeros
    patron =/[0-6]/;
    tecla_final = String.fromCharCode(tecla);
    return patron.test(tecla_final);
}







