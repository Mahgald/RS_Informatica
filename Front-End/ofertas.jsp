<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="servicesImplements.*"%>
<%@ page import="model.record.*"%>
<%@ page import="model.products.*"%>


<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">

<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/estilos.css">
<title>RS Informatica</title>
</head>
<body class="indexbody">



	<header>
		<nav class="navbar navbar-fixed-top navbar-default " role="navigation">
			<div class="container">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion">
						<span class="sr-only">Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>

					</button>
					<a href="#" class="navbar-brand">RS INFORMATICA</a>
				</div>

				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse" id="navegacion">
					<ul class="nav navbar-nav">
						<li class="btn-danger active"><a href="index.jsp">INICIO</a></li>



						<li class="dropdown "><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button">PRODUCTOS <span
								class="caret"></span></a>


							<ul class="dropdown-menu" role="menu" role="tablist">
								<li class=""><a href="products.jsp#procesadores"
									name="procesadores" role="button">Procesadores</a></li>
								<li class="divider"></li>
								<li class=""><a href="products.jsp#memorias"
									name="memorias" role="button">Memorias</a></li>
								<li class="divider"></li>
								<li><a href="products.jsp#mothers">Motherboards</a></li>
								<li class="divider"></li>
								<li class=""><a href="products.jsp#discos" role="button">Almacenamiento</a></li>
								<li class="divider"></li>
								<li><a href="products.jsp#fuentes">Fuentes</a></li>
								<li class="divider"></li>
								<li><a href="products.jsp#gabinetes">Gabitenes</a></li>
								<li class="divider"></li>
								<li class=""><a href="products.jsp#peri" role="button">Perifericos</a></li>
							</ul></li>
						<li><a href="#">OFERTAS</a></li>
						<li><a href="novedades.jsp">NOVEDADES</a></li>
						<li><a href="#" data-toggle="modal" data-target="#nosotros">LA EMPRESA</a></li>
						<li><a href="#" data-toggle="modal" data-target="#formcontacto">CONTACTO</a></li>

					</ul>


					<%session = request.getSession(false);
				
				
						
				%>

					<% if((session.getAttribute("adminLogin") == null) && (session.getAttribute("userLogin") == null)){  %>
					<form action="">
						<div class="login-signup-shoppingcart">

							<a href="cart.jsp" class="btn btn-md btn-danger "><span class="glyphicon glyphicon-shopping-cart"></span></a>
							<a href="login.jsp" class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-log-in"></span> Login </a> <a
								href="signup.jsp" class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-user"></span> Signup</a>

							<!-- <div class="btn-group">
								<a href="signup.jsp" class="btn btn-md btn-danger visible-md visible-sm visible-xs"><span class="glyphicon glyphicon-log-in"></span></a>
						
								<a href="login.jsp" class="btn btn-md btn-danger visible-md visible-sm visible-xs"><span class="glyphicon glyphicon-user"></span></a>
							</div> -->
						</div>
					</form>

					<%}else{
					if((session.getAttribute("adminLogin") != null)/* && (session.getAttribute("userLogin") == null)*/) {%>
					<form name="logout" action="CloseSessionController" method="post">
						<div class="login-signup-shoppingcart">

							<!--	<a href="Shoppingcart" class="btn btn-md btn-danger hidden-md hidden-sm hidden-xs"><span class="glyphicon glyphicon-shopping-cart"></span></a> -->

							<a href="admin.jsp" class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-log-in"></span> Admin </a> <a
								href="javascript:document.logout.submit()"
								class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-log-in"></span> Logout </a>


						</div>
					</form>

					<%}else{
					if((session.getAttribute("userLogin")!= null)/* && (session.getAttribute("adminLogin") == null)*/){%>
					<form name="logout" action="CloseSessionController" method="post">
						<div class="login-signup-shoppingcart">

							<a href="cart.jsp" class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-shopping-cart"></span></a> <a href="#"
								class="btn btn-md btn-danger idden-xs"><span
								class="glyphicon glyphicon-log-in"></span> Perfil </a> <a
								href="javascript:document.logout.submit()"
								class="btn btn-md btn-danger "><span
								class="glyphicon glyphicon-log-in"></span> Logout </a>

						</div>
					</form>
					<%}%>

					<% }}%>

				</div>

			</div>




			</div>
		</nav>



	<div class="container">

		<!-- Modal -->
		<div class="modal fade" id="formcontacto" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Contacto</h4>
					</div>
					<div class="modal-body ">

						<form action="#" method="post" class=" form-inline" role="form" id="formcontacto">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="nombre">Nombre</label> 
									<input type="text" class="form-control" name="nombre" id="nombre" value="" placeholder="Nombre" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="mail">E-Mail</label> 
									<input class="form-control" name="mail" id="mail" type="email" placeholder="E-Mail" value="" required>
									
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="consulta">Consulta</label> 
									<textarea class="form-control comentarios" id="output" rows="4" cols="20" name="consulta" form="formcontacto" required="required"></textarea>
								</div>
							</div>
							
							<div class="modal-footer">
								<input type="reset" id="enviar" value="Enviar" class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
								
							
						</form>
						</div>
					</div>

				

			</div>
		</div>

</div>	
<div class="container">

		<!-- Modal -->
		<div class="modal fade" id="nosotros" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">RS INFORMATICA</h4>
					</div>
					<div class="modal-body ">

						<form action="#" method="" class=" form-inline" role="form" onsubmit="enviocomentario()">

							<div class="row">
								<div class="form-group col-md-10 col-md-offset-1" >
									<p>Somos una empresa dedicada a la venta online de productos informáticos y tecnológicos orientados principalmente al publico Gamer, Entusiastas, Profesionales Multimediales y para todo aquel que busque productos de excelente calidad que solo las mejores marcas pueden brindar.</p>
									<p>Nuestro objetivo es convertirnos en una empresa líder en el mercado de la tecnología, atendiendo las necesidades de nuestros clientes con la mejor atención y precios convenientes. Y entregarles a nuestros clientes las mejores soluciones tecnológicas creando valor diferenciado.</p>
								</div>
							</div>
							
							<div class="modal-footer">
								<input type="button" id="" value="Cerrar" data-dismiss="modal" class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
								
							</div>
								
							
						</form>
						</div>
					</div>

				

			</div>
		</div>

</div>	
<div id="exito" class="alert alert-danger col-md-8 col-md-offset-2 " hidden>
		 
	
	</div>


	</header>
<% ShopCartService var= new ShopCartService(); 
   											
	

%>
	
	<section class="main container">
	
	<h1>Ofertas</h1>
	
	<br>
	<br>
	
			
		<div class="row">			
			
			<%= var.printprocesador(32) %>
			<%= var.printgabo(60) %>
			<%= var.printdiscos(39) %>
			<%= var.printfuente(47) %>
			
		</div>	
		
		<div class="row">
			<%= var.printperi(52) %>
			<%= var.printperi(54) %>
			<%= var.printperi(53) %>
			<%= var.printperi(55) %>
		</div>
		
		
	</section>	

	
	
	
	
	
	
	
	
	
	
	
<br>
<br>
<br>
	<footer>
		<div class="footer navbar-fixed-bottom">
			<div class="container-fluid panel-footer">
				<div class="row">

						<div class="col-xs-6 col-md-5 col-md-offset-5 col-sm-offset-4">
							<p class="footer-text ">Ricardo Surribas <span class="footer-text hidden-sm hidden-xs inline">- Proyecto Final Comunidad IT</span></p>
						</div>
					
					<div class="col-xd-1 col-md-2">
						<ul class="list-inline text-right">
							<li><a href="https://www.linkedin.com/in/ricardo-surribas-76191a100">Linkedin</a></li>
							<li><a href="https://github.com/Mahgald?tab=repositories">Github</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>		
	</footer>

	<script src="https://code.jquery.com/jquery-latest.js"></script>
	
 	<script src="js/bootstrap.min.js"></script>
 	<script src="js/index.js"></script>
</body>
</html>