package servicesImplements;

import java.util.List;

import daoImplements.ProductoDaoImpl;
import daoInterfaces.ProductoDao;
import model.products.*;
import servicesInterfaces.*;

public class ShopCartService implements ShopCartServiceInterface  {
	
	public String printprocesador(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Procesador procesador= (Procesador) sv.buscarProducto(prod);
		
		htmlcode += "<div class=\"col-xs-6 col-md-3 \" >\n" +
				"<div class=\"thumbnail \" id=\"prod"+procesador.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+procesador.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Procesador "+ procesador.getMarca()+"</h4>\n"+
						"<p>Precio: $ "+procesador.getPrecio()+"0</p>\n"+
						"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
				
						"<input type=\"hidden\" value=\""+procesador.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
					
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+procesador.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+	
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


htmlmodal +=		

	"<div class=\"modal fade\" id=\"ventana"+procesador.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Procesador "+ procesador.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+procesador.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+procesador.getDescripcion() +"</p>"+
							"<p>Precio $ "+procesador.getPrecio() +"0</p>"+
							"<input type=\"hidden\" value=\""+procesador.getId_producto() +"\" name=\"idProducto\">\n"+
												
							"<p>Marca: "+procesador.getMarca() +"</p>"+
							"<p>Memoria Cache: "+procesador.getMem_cache()+" Mb</p>"+
							"<p>Nucleos: "+procesador.getCant_nucleos()+"</p>"+
						
					"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+procesador.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

	return htmlcode+htmlmodal;
	}
	
	public String printmemoria(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Memoria mem= (Memoria) sv.buscarProducto(prod);
		
		htmlcode += "<div class=\"col-xs-6 col-md-3 \" >\n" +
				"<div class=\"thumbnail \" id=\"prod"+mem.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+mem.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Memoria Ram "+ mem.getMarca()+"</h4>\n"+
						"<p>Precio: $ "+mem.getPrecio()+"0</p>\n"+
						"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
				
						"<input type=\"hidden\" value=\""+mem.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
					
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+mem.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+	
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


htmlmodal +=		

	"<div class=\"modal fade\" id=\"ventana"+mem.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Memoria Ram "+ mem.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+mem.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+mem.getDescripcion() +"</p>"+
							"<p>Precio $ "+mem.getPrecio() +"0</p>"+
							"<input type=\"hidden\" value=\""+mem.getId_producto() +"\" name=\"idProducto\">\n"+
												
							"<p>Marca: "+mem.getMarca() +"</p>"+
							"<p>Capacidad: "+mem.getCapacidad()+" Gb</p>"+
							"<p>Velocidad: "+mem.getVelocidad()+" Mhz</p>"+
						
					"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+mem.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

	return htmlcode+htmlmodal;
	}
	
	public String printdiscos(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Almacenamiento disco= (Almacenamiento) sv.buscarProducto(prod);
		
		htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
				"<div class=\"thumbnail\" id=\"prod"+disco.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+disco.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h3>Disco "+ disco.getMarca()+"</h3>\n"+
						"<p>Precio $ "+disco.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
						
						"<input type=\"hidden\" value=\""+disco.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
						//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+disco.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


htmlmodal +=		"<div class=\"modal fade\" id=\"ventana"+disco.getId_producto() +"\">"+ 
		"<div class=\"modal-dialog\">"+
			"<div class=\"modal-content\">"+
				
				"<!-- Header de la ventana -->"+
				"<div class=\"modal-header\">"+
					"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
						"<h4 class=\"modal-title\"> Disco "+ disco.getMarca() +"</h4>"+
				"</div>"+

				"<!-- Contenido -->"+
				"<div class=\"modal-body\">"+
				"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+disco.getImg_producto()+"\"  alt=\"\"></p>"+
					"<p>"+disco.getDescripcion() +"</p>"+
					"<p>Precio $ "+disco.getPrecio() +"0</p>"+
					"<p>Marca: "+disco.getMarca() +"</p>"+
					"<p>Capacidad: "+disco.getCapacidad()+" Gb</p>"+
					"<p>Tipo: "+disco.getTipo()+"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+disco.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

return htmlcode+htmlmodal;
		
	}
	
	public String printmother(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Motherboard mother= (Motherboard) sv.buscarProducto(prod);	
		htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
				"<div class=\"thumbnail\" id=\"prod"+mother.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\" ><img src=\""+mother.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Motherboard "+ mother.getMarca()+"</h4>\n"+
						"<p>Precio $ "+mother.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
						
						"<input type=\"hidden\" value=\""+mother.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
						//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+mother.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


	 htmlmodal +=	"<div class=\"modal fade\" id=\"ventana"+mother.getId_producto() +"\">"+ 
		"<div class=\"modal-dialog\">"+
			"<div class=\"modal-content\">"+
				
				"<!-- Header de la ventana -->"+
				"<div class=\"modal-header\">"+
					"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
						"<h4 class=\"modal-title\"> Motherboard "+ mother.getMarca() +"</h4>"+
				"</div>"+

				"<!-- Contenido -->"+
				"<div class=\"modal-body\">"+
				"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+mother.getImg_producto()+"\"  alt=\"\"></p>"+
					"<p>"+mother.getDescripcion() +"</p>"+
					"<p>Precio $ "+mother.getPrecio() +"0</p>"+
					"<p>Marca: "+mother.getMarca() +"</p>"+
					"<p>"+mother.getSocket()+"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+mother.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

return htmlcode+htmlmodal;
		
	}
	
	public String printfuente(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Fuente fuente= (Fuente) sv.buscarProducto(prod);	
		
		htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
				"<div class=\"thumbnail\" id=\"prod"+fuente.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+fuente.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Fuente "+ fuente.getMarca()+"</h4>\n"+
						"<p>Precio $ "+fuente.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
						
						"<input type=\"hidden\" value=\""+fuente.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
						//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+fuente.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+
					"</div>\n" +
				"</div>\n" +
			"</div>";

	htmlmodal +=	
	"<div class=\"modal fade\" id=\"ventana"+fuente.getId_producto() +"\">"+ 
		"<div class=\"modal-dialog\">"+
			"<div class=\"modal-content\">"+
				
				"<!-- Header de la ventana -->"+
				"<div class=\"modal-header\">"+
					"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
						"<h4 class=\"modal-title\"> Fuente "+ fuente.getMarca() +"</h4>"+
				"</div>"+

				"<!-- Contenido -->"+
				"<div class=\"modal-body\">"+
				"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+fuente.getImg_producto()+"\"  alt=\"\"></p>"+
					"<p>"+fuente.getDescripcion() +"</p>"+
					"<p>Precio $ "+fuente.getPrecio() +"0</p>"+
					"<p>Marca: "+fuente.getMarca() +"</p>"+
					"<p>Potencia: "+fuente.getPotencia()+" Watts</p>"+
					"<p>Certificacion: "+fuente.getCertificacion()+"</p>"+							
"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+fuente.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

return htmlcode+htmlmodal;
	}
	
	public String printgabo(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		Gabinete gabo= (Gabinete) sv.buscarProducto(prod);
		
		htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
				"<div class=\"thumbnail\" id=\"prod"+gabo.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+gabo.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Gabinete "+ gabo.getMarca()+"</h4>\n"+
						"<p>Precio $ "+gabo.getPrecio()+"0</p>\n"+
						"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
						
						"<input type=\"hidden\" value=\""+gabo.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
						//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+gabo.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


	htmlmodal += 
			
			"<div class=\"modal fade\" id=\"ventana" + gabo.getId_producto() + "\">"+
				"<div class=\"modal-dialog\">" + 
					"<div class=\"modal-content\">" +

			"<!-- Header de la ventana -->" + 
						"<div class=\"modal-header\">"+ 
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+ 
							"<h4 class=\"modal-title\"> Gabinete " + gabo.getMarca() + "</h4>" + 
						"</div>" +

			"<!-- Contenido -->" + 
						"<div class=\"modal-body\">"
			+ "<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""
			+ gabo.getImg_producto() + "\"  alt=\"\"></p>" + "<p>" + gabo.getDescripcion() + "</p>"
			+ "<p>Precio $ " + gabo.getPrecio() + "0</p>" + "<p>Marca: " + gabo.getMarca() + "</p>"
			+ "<p>Dimensiones: " + gabo.getDimension() + "</p>"+
			
			"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+gabo.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

return htmlcode+htmlmodal;
		
	}
	
	public String printperi(int id)throws Exception{
		Producto prod= new Producto();
		prod.setId_Producto(id);
		ServicesCrud sv= new ServicesCrud();
		String htmlcode="";
		String htmlmodal="";
		prod= sv.buscarProducto(prod);
		htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
				"<div class=\"thumbnail\" id=\"prod"+prod.getId_producto()+"\">\n" +
					"<a href=\"#\" class=\"thumbnail\"><img src=\""+prod.getImg_producto()+"\"  alt=\"\"></a>\n" +
					"<div class=\"caption\">\n" +
						"<h4>Periferico "+ prod.getMarca()+"</h4>\n"+
						"<p>Precio $ "+prod.getPrecio()+"0</p>\n"+
						"<form action=\"Cart\" method=\"post\" class=\"\">"+
						
						
						"<input type=\"hidden\" value=\""+prod.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"+
						"<div class=\"btn-group\">\n" +
						//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
						"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
							"<a href=\"#ventana"+prod.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
						"</div>\n" +
						
						"</form>"+
					"</div>\n" +
				"</div>\n" +
			"</div>"; 


htmlmodal += "<div class=\"modal fade\" id=\"ventana"+prod.getId_producto() +"\">"+ 
		"<div class=\"modal-dialog\">"+
			"<div class=\"modal-content\">"+
				
				"<!-- Header de la ventana -->"+
				"<div class=\"modal-header\">"+
					"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
						"<h4 class=\"modal-title\"> Periferico "+ prod.getMarca() +"</h4>"+
				"</div>"+

				"<!-- Contenido -->"+
				"<div class=\"modal-body\">"+
				"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+prod.getImg_producto()+"\"  alt=\"\"></p>"+
					"<p>"+prod.getDescripcion() +"</p>"+
					"<p>Precio $ "+prod.getPrecio() +"0</p>"+
					"<p>Marca: "+prod.getMarca() +"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
													
						
						"<input type=\"hidden\" value=\""+prod.getId_producto() +"\" name=\"idProducto\">\n"+
						
						"<label class=\" \"	for=\"\">Cant:</label>\n"+
						
						"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
						
						"<br>\n"+
						"<br>\n"	
			

			+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
			 "</div>" + "</div>" + "</div>";

return htmlcode+htmlmodal;
	}
	
	
	
	
	
	@Override
	public String procesadores() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(0);
				
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
			Procesador procesador = (Procesador)producto;	
				htmlcode += "<div class=\"col-xs-6 col-md-3 \" >\n" +
						"<div class=\"thumbnail \" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+procesador.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Procesador "+ procesador.getMarca()+"</h4>\n"+
								"<p>Precio: $ "+procesador.getPrecio()+"0</p>\n"+
								"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
						
								"<input type=\"hidden\" value=\""+procesador.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+	
							"</div>\n" +
						"</div>\n" +
					"</div>"; 
		
		
	htmlmodal +=				"<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
						"<div class=\"modal-dialog\">"+
							"<div class=\"modal-content\">"+
								
								"<!-- Header de la ventana -->"+
								"<div class=\"modal-header\">"+
									"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
										"<h4 class=\"modal-title\"> Procesador "+ procesador.getMarca() +"</h4>"+
								"</div>"+

								"<!-- Contenido -->"+
								"<div class=\"modal-body\">"+
								"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+procesador.getImg_producto()+"\"  alt=\"\"></p>"+
									"<p>"+procesador.getDescripcion() +"</p>"+
									"<p>Precio $ "+procesador.getPrecio() +"0</p>"+
									"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
														
									"<p>Marca: "+procesador.getMarca() +"</p>"+
									"<p>Memoria Cache: "+procesador.getMem_cache()+" Mb</p>"+
									"<p>Nucleos: "+procesador.getCant_nucleos()+"</p>"+
								
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
	}

	@Override
	public String memorias_ram() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(1);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				Memoria memoria= (Memoria)producto;
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+memoria.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Memoria Ram "+ memoria.getMarca()+"</h4>\n"+
								"<p>Precio $ "+memoria.getPrecio()+"0</p>\n"+
								"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
								"</div>\n" +
							"</div>\n" +
						"</div>";
	
		htmlmodal+=		"<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
					"<div class=\"modal-dialog\">"+
						"<div class=\"modal-content\">"+
							
							"<!-- Header de la ventana -->"+
							"<div class=\"modal-header\">"+
								"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
									"<h4 class=\"modal-title\"> Memoria Ram "+ memoria.getMarca() +"</h4>"+
							"</div>"+

							"<!-- Contenido -->"+
							"<div class=\"modal-body\">"+
							"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+memoria.getImg_producto()+"\"  alt=\"\"></p>"+
								"<p>"+memoria.getDescripcion() +"</p>"+
								"<p>Precio $ "+memoria.getPrecio() +"0</p>"+
								"<p>Marca: "+memoria.getMarca() +"</p>"+
								"<p>Capacidad: "+memoria.getCapacidad()+" Gb</p>"+
								"<p>Velocidad: "+memoria.getVelocidad()+" Mhz</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
	return htmlcode+htmlmodal;
}

	@Override
	public String motherboards() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(3);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				Motherboard mother= (Motherboard)producto;
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\" ><img src=\""+mother.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Motherboard "+ mother.getMarca()+"</h4>\n"+
								"<p>Precio $ "+mother.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
							"</div>\n" +
						"</div>\n" +
					"</div>"; 


			 htmlmodal +=	"<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Motherboard "+ mother.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+mother.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+mother.getDescripcion() +"</p>"+
							"<p>Precio $ "+mother.getPrecio() +"0</p>"+
							"<p>Marca: "+mother.getMarca() +"</p>"+
							"<p>"+mother.getSocket()+"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
}

	@Override
	public String discos() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(2);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				Almacenamiento disco= (Almacenamiento)producto;
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+disco.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h3>Disco "+ disco.getMarca()+"</h3>\n"+
								"<p>Precio $ "+disco.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
							"</div>\n" +
						"</div>\n" +
					"</div>"; 


	htmlmodal +=		"<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Disco "+ disco.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+disco.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+disco.getDescripcion() +"</p>"+
							"<p>Precio $ "+disco.getPrecio() +"0</p>"+
							"<p>Marca: "+disco.getMarca() +"</p>"+
							"<p>Capacidad: "+disco.getCapacidad()+" Gb</p>"+
							"<p>Tipo: "+disco.getTipo()+"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
}

	@Override
	public String fuentes() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(4);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				Fuente fuente= (Fuente)producto;
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+fuente.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Fuente "+ fuente.getMarca()+"</h4>\n"+
								"<p>Precio $ "+fuente.getPrecio()+"0</p>\n"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
							"</div>\n" +
						"</div>\n" +
					"</div>";

			htmlmodal +=	
			"<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Fuente "+ fuente.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+fuente.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+fuente.getDescripcion() +"</p>"+
							"<p>Precio $ "+fuente.getPrecio() +"0</p>"+
							"<p>Marca: "+fuente.getMarca() +"</p>"+
							"<p>Potencia: "+fuente.getPotencia()+" Watts</p>"+
							"<p>Certificacion: "+fuente.getCertificacion()+"</p>"+							
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
}

	@Override
	public String perifericos() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(6);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+producto.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Periferico "+ producto.getMarca()+"</h4>\n"+
								"<p>Precio $ "+producto.getPrecio()+"0</p>\n"+
								"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
							"</div>\n" +
						"</div>\n" +
					"</div>"; 


		htmlmodal += "<div class=\"modal fade\" id=\"ventana"+producto.getId_producto() +"\">"+ 
				"<div class=\"modal-dialog\">"+
					"<div class=\"modal-content\">"+
						
						"<!-- Header de la ventana -->"+
						"<div class=\"modal-header\">"+
							"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+
								"<h4 class=\"modal-title\"> Periferico "+ producto.getMarca() +"</h4>"+
						"</div>"+

						"<!-- Contenido -->"+
						"<div class=\"modal-body\">"+
						"<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""+producto.getImg_producto()+"\"  alt=\"\"></p>"+
							"<p>"+producto.getDescripcion() +"</p>"+
							"<p>Precio $ "+producto.getPrecio() +"0</p>"+
							"<p>Marca: "+producto.getMarca() +"</p>"+
"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
}

	@Override
	public String gabinetes() throws Exception {
		ProductoDao dao= new ProductoDaoImpl();
		String htmlcode="";
		String htmlmodal="";
		Producto prod= new Producto();
		prod.setCategoria(5);
		for(Producto producto :dao.buscarProductoByCategoria(prod)){
				Gabinete gabo= (Gabinete)producto;
				htmlcode += "<div class=\"col-xs-6 col-md-3\">\n" +
						"<div class=\"thumbnail\" id=\"prod"+producto.getId_producto()+"\">\n" +
							"<a href=\"#\" class=\"thumbnail\"><img src=\""+producto.getImg_producto()+"\"  alt=\"\"></a>\n" +
							"<div class=\"caption\">\n" +
								"<h4>Gabinete "+ producto.getMarca()+"</h4>\n"+
								"<p>Precio $ "+producto.getPrecio()+"0</p>\n"+
								"<form action=\"Cart\" method=\"post\" class=\"\">"+
								
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"+
								"<div class=\"btn-group\">\n" +
								//	"<a href=\"submit\" class=\"btn btn-danger\">Agregar al Carrito</a>"+
								"<input type=\"submit\" value=\"Agregar al Carrito\" class=\"btn btn-danger\">\n"+
									"<a href=\"#ventana"+producto.getId_producto() +"\" class=\"btn btn-default\"data-toggle=\"modal\">Mas Info</a>\n"+
								"</div>\n" +
								
								"</form>"+
							"</div>\n" +
						"</div>\n" +
					"</div>"; 


			htmlmodal += 
					
					"<div class=\"modal fade\" id=\"ventana" + producto.getId_producto() + "\">"+
						"<div class=\"modal-dialog\">" + 
							"<div class=\"modal-content\">" +

					"<!-- Header de la ventana -->" + 
								"<div class=\"modal-header\">"+ 
									"<button tyle=\"button\" class=\"close\" data-dismiss=\"modal\" aria-hidden=\"true\">&times;</button>"+ 
									"<h4 class=\"modal-title\"> Gabinete " + gabo.getMarca() + "</h4>" + 
								"</div>" +

					"<!-- Contenido -->" + 
								"<div class=\"modal-body\">"
					+ "<p><img class=\"img-responsive \" width=\"300\" height=\"300\"    alt=\"Responsive image\"     src=\""
					+ gabo.getImg_producto() + "\"  alt=\"\"></p>" + "<p>" + gabo.getDescripcion() + "</p>"
					+ "<p>Precio $ " + gabo.getPrecio() + "0</p>" + "<p>Marca: " + gabo.getMarca() + "</p>"
					+ "<p>Dimensiones: " + gabo.getDimension() + "</p>"+
					
					"<form action=\"Cart\" method=\"post\" class=\"\">"+
															
								
								"<input type=\"hidden\" value=\""+producto.getId_producto() +"\" name=\"idProducto\">\n"+
								
								"<label class=\" \"	for=\"\">Cant:</label>\n"+
								
								"<input type=\"text\" value=\"1\" size=\"1\" id=\"cantProductos\" name=\"cantProductos\"\">\n"+
								
								"<br>\n"+
								"<br>\n"	
					

					+"<br>\n" + "</div>" +

"<!-- Footer de la ventana -->"+

"<div class=\"modal-footer\">"+
	"<button type=\"button\" class=\"btn btn-danger\" data-dismiss=\"modal\">Cerrar</button>"+
	"<button type=\"submit\" class=\"btn btn-default\">Agregar al Carrito</button>"+
"</div>"+
"</form>"+	
					 "</div>" + "</div>" + "</div>";
		}
		return htmlcode+htmlmodal;
}

	@Override
	public Producto getProducto(int id) throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		Producto prod= new Producto();
		prod.setId_Producto(id);
			prod=proDao.buscarProductoById(prod);
			switch (prod.getCategoria()) {
			case 0:
				Procesador proce = ((ProductoDaoImpl) proDao).selectProcesador(prod);
				prod = proce;
				break;
			case 1:
				Memoria mem = ((ProductoDaoImpl) proDao).selectMemoria(prod);
				prod = mem;
				break;
			case 2:
				Almacenamiento disco = ((ProductoDaoImpl) proDao).selectDisco(prod);
				prod = disco;
				break;
			case 3:
				Motherboard mother = ((ProductoDaoImpl) proDao).selectMother(prod);
				prod = mother;
				break;
			case 4:
				Fuente fuente = ((ProductoDaoImpl) proDao).selectFuente(prod);
				prod = fuente;
				break;
			case 5:
				Gabinete gabo = ((ProductoDaoImpl) proDao).selectGabo(prod);
				prod = gabo;
				break;
			}
			return prod;
		 
	}

	
	
}
