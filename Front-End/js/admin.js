$(function(){
	$('tr #deleteitem').click(function(e){
		e.preventDefault();
		var elemento = $(this);
		var idproducto= elemento.parent().find('#idarticulo').text();
		$.ajax({
			url:'DeleteShopCart',
			type : 'post',
			data : {idproducto : idproducto},
			success: function(r){
				elemento.parent().parent().remove();
			}
		})
	});
}) ;


$(function(){
	$("#lprocesadores").click(function(){
		$("#procesadores").show();
        $("#tprocesadores").show();
        
        $("#tusuarios").hide();
		$("#usuarios").hide();
        
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();	
		$("#lowstock").hide();
		$("#tlowstock").hide();
	});
	$("#lmemorias").click(function(){
		$("#memorias").show();
		$("#tmemorias").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();	
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    $("#ldiscos").click(function(){
		$("#discos").show();
		$("#tdiscos").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    $("#lmothers").click(function(){
		$("#motherboards").show();
		$("#tmotherboards").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
		$("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();
		$("#lowstock").hide();
		$("#tlowstock").hide();
	});
	$("#lfuentes").click(function(){
		$("#fuentes").show();
		$("#tfuentes").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    $("#lgabos").click(function(){
		$("#gabinetes").show();
		$("#tgabinetes").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    $("#lperi").click(function(){
		$("#perifericos").show();
		$("#tperifericos").show();	
		$("#tusuarios").hide();
		$("#usuarios").hide();
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    $("#lows").click(function(){
    	$("#lowstock").show();
		$("#tlowstock").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
		$("#perifericos").hide();
		$("#tperifericos").hide();	
        $("#procesadores").hide();
        $("#tprocesadores").hide();
		$("#memorias").hide();
		$("#tmemorias").hide();
		$("#discos").hide();
		$("#tdiscos").hide();
		$("#motherboards").hide();
		$("#tmotherboards").hide();
		$("#fuentes").hide();
		$("#tfuentes").hide();
		$("#gabinetes").hide();
		$("#tgabinetes").hide();
		
    });
    
    $("#listartodo").click(function(){
    	$("#lowstock").show();
		$("#tlowstock").show();
		$("#tusuarios").hide();
		$("#usuarios").hide();
		$("#perifericos").show();
		$("#tperifericos").show();	
        $("#procesadores").show();
        $("#tprocesadores").show();
		$("#memorias").show();
		$("#tmemorias").show();
		$("#discos").show();
		$("#tdiscos").show();
		$("#motherboards").show();
		$("#tmotherboards").show();
		$("#fuentes").show();
		$("#tfuentes").show();
		$("#gabinetes").show();
		$("#tgabinetes").show();
		$("#lowstock").hide();
		$("#tlowstock").hide();
    });
    
    $("#luser").click(function(){
    	location.reload();
		
    });
   
    
});


