$(function(){
	var input_pass = document.getElementById("password");
	var input_rpass = document.getElementById("rpassword");
	var input_mail = document.getElementById("email");
	var input_rmail = document.getElementById("remail");

	$("#btnsignup").click(function(){
		
			if ((input_pass.value==input_rpass.value)&&(input_mail.value==input_rmail.value)) {
				$("#registroform").submit();
			}else{
				$("#error").text("El E-Mail o el Password con coinciden").fadeIn("slow");	

			}
		
	});




});







$(function (){
	
	$("#enviar").click(function (){
		//alert("Enviado!!Gracias por comunicarte con nosotros, proximamente nos estaremos comunicando");
		
		    $('#formcontacto').modal('hide');
		    document.getElementById("output").value = "";

		    $("#exito").text("Enviado!! Gracias por comunicarte con nosotros, proximamente nos estaremos comunicando contigo").fadeIn( "slow" );
	});
	

	
});

$(function (){
	
	$("#exito").click(function (){
		$("#exito").hide();
	});
	

	
});


/*$(function (){
	
	$("#compra").click(function (){
				
		      alert("Se esta procesando la compra, proximamente te llegara un mail para completar la compra");
		      window.location.href = "index.jsp"
	});
	

	
});*/


	