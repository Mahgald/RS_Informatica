<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="daoImplements.ProductoDaoImpl"%>
<%@ page import="daoInterfaces.ProductoDao"%>
<%@ page import="daoImplements.*"%>
<%@ page import="daoInterfaces.*"%>
<%@ page import="java.util.List"%>
<%@ page import="model.products.*"%>
<%@ page import="model.record.*"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.css">
<link rel="stylesheet" href="css/estilos.css">
<title>RS Informatica</title>

</head>
<body>

	<%	
		if(session.getAttribute("adminLogin")!= null){
			
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>

	<header>
		<nav class="navbar navbar-fixed-top navbar-default" role="navigation">
			<div class="container-fluid col-md-offset-2">
				<div class="navbar-header ">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion">
						<span class="sr-only">Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					
					</button>
					<a href="#" class="navbar-brand hidden-lg">ADMINISTRACION - MENU</a>					
					
						
					
					
					
				</div>

				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse " id="navegacion">
					<ul class="nav navbar-nav ">
						<li class="active btn-danger active"><a href="index.jsp">INICIO</a></li> 
						<li class="dropdown"> 
							<a href="#" class="dropdown-toggle"	data-toggle="dropdown" role="button">AGREGAR PRODUCTO <span class="caret"></span></a>
							
							<ul class="dropdown-menu"  role="menu" role="tablist">
								<li><a href="#" data-toggle="modal" data-target="#agregarprocesador">Procesador</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregarmemoria">Memoria Ram</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregarmother">Motherboard</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregarfuente">Fuente</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregargabo">Gabinete</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregardisco">Disco</a></li>
								<li class="divider"></li>
								<li><a href="#" data-toggle="modal" data-target="#agregarperiferico">Periferico</a></li>
							</ul>
						</li>
						<li><a href="#" data-toggle="modal" data-target="#editdelete">MODIFICAR/ELIMINAR PRODUCTO</a></li>
						<!--  <li><a href="#">BUSCAR PRODUCTO</a></li>-->
						<li><a href="#" data-toggle="modal" data-target="#modalbusqueda">BUSCAR PRODUCTO</a></li>
						
						<li class="dropdown"><a href="#" class="dropdown-toggle"
							data-toggle="dropdown" role="button">LISTAR PRODUCTOS <span
								class="caret"></span></a>
							<ul class="dropdown-menu multi-level" role="menu">
								<li><a href="#" id="listartodo">Listar Todo</a></li>
								<li class="divider"></li>
								<li><a href="#" id="luser">Listar Usuarios</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lows">Listar por Low Stock</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lprocesadores">Listar Procesadores</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lmemorias">Listar Memorias</a></li>
								<li class="divider"></li>
								<li><a href="#" id="ldiscos">Listar Discos</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lmothers">Listar Motherboards</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lfuentes">Listar Fuentes</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lgabos">Listar Gabinetes</a></li>
								<li class="divider"></li>
								<li><a href="#" id="lperi">Listar Perifericos</a></li>
								
							</ul></li>



					</ul>
					<form name="logout" action="CloseSessionController" method="post">
						<div class="login-signup-shoppingcart pull-left">
							
											
							<a href="javascript:document.logout.submit()" class="btn btn-md btn-danger "><span class="glyphicon glyphicon-log-in"></span> Logout </a>
																
							<div class="btn-group">
								<a href="javascript:document.logout.submit()" class="btn btn-md btn-danger visible-md visible-sm visible-xs"><span class="glyphicon glyphicon-log-in"> Logout</span></a>
							</div>
						</div>	
					</form>
				

				</div>
			</div>
		</nav>
	</header>

	<div class="container" id="busquedaModal">

		<!-- Modal -->
		<div class="modal fade" id="modalbusqueda" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Buscar</h4>
					</div>
					<div class="modal-body">

						<form action="SearchController" method="post" class="">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="id_producto">ID Producto</label> <input type="text"
										class="form-control" name="id_producto" id="id_producto"
										placeholder="ID Producto">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="marca">Marca</label> <input
										class="form-control" name="marca" id="marca" type="text"
										placeholder="Marca">
								</div>
							</div>

							<div class="modal-footer">
								<input type="submit" value="Buscar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>

	<div class="container" id="procesadorModal">

		<!-- Modal -->
		<div class="modal fade" id="agregarprocesador" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Procesador</h4>
					</div>
					<div class="modal-body ">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="0"></input>
								
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label> <input
										class="form-control" name="stockmin" id="stockmin" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> <input
										class="form-control" name="stockact" id="stockact" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="cantnucleos">Cantidad de Nucleos</label> <input
										class="form-control" name="cantnucleos" id="cantnucleos" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="memcache">Memoria Cache</label> <input
										class="form-control" name="memcache" id="memcache" type="text"
										placeholder="" required pattern="[0-9]{4,6}"  title="Solo numeros">
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
	
	<div class="container" id="memoriasModal">

	<!-- 		Modal -->
		<div class="modal fade" id="agregarmemoria" role="dialog">
			<div class="modal-dialog">

	<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Memoria Ram</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="1"></input>
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="capacidad">Capacidad</label> <input
										class="form-control" name="capacidad" id="capacidad" type="text"
										placeholder="" required pattern="[0-9]{4}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="velocidad">Velocidad</label> <input
										class="form-control" name="velocidad" id="velocidad" type="text"
										placeholder="" required pattern="[0-9]{4,5}" title="Solo numeros">
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
	
	<div class="container" id="motherModal">

<!-- 		Modal -->
		<div class="modal fade" id="agregarmother" role="dialog">
			<div class="modal-dialog">

<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Motherboard</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="3"></input>
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="socket">Socket</label> <input
										class="form-control" name="socket" id="socket" type="text"
										placeholder="" >
								</div>
							</div>

								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>

	<div class="container" id="fuenteModal">

<!-- 		Modal -->
		<div class="modal fade" id="agregarfuente" role="dialog">
			<div class="modal-dialog">

<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Fuente</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label>
									<input style="display:none;" type="text" name="cat" value="4"></input>
									 <input type="text"
										class="form-control" name="marca" id="marca" placeholder=""
										required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion"
										type="text" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="potencia">Potencia</label> <input
										class="form-control" name="potencia" id="potencia" type="text"
										placeholder="" required pattern="[0-9]{1,4}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="certificacion">Certificacion</label> <input
										class="form-control" name="certificacion" id="certificacion"
										type="text" placeholder="">
								</div>
							</div>

							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>

	<div class="container" id="gaboModal">

		<!-- 		Modal -->
		<div class="modal fade" id="agregargabo" role="dialog">
			<div class="modal-dialog">

<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Gabinete</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="5"></input>
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="dimensiones">Dimensiones</label> <input
										class="form-control" name="dimensiones" id="dimensiones" type="text"
										placeholder="" required >
								</div>
							</div>

								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
	
	<div class="container" id="discoModal">

		<!-- 		Modal -->
		<div class="modal fade" id="agregardisco" role="dialog">
			<div class="modal-dialog">

<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Disco</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="2"></input>
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="capacidad">Capacidad</label> <input
										class="form-control" name="capacidad" id="capacidad" type="text"
										placeholder="" required pattern="[0-9]{1,2}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="tipo">Tipo</label> <input
										class="form-control" name="tipo" id="tipo" type="text"
										placeholder="" required >
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
	
	<div class="container" id="perifericoModal">

		<!-- 		Modal -->
		<div class="modal fade" id="agregarperiferico" role="dialog">
			<div class="modal-dialog">

<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Agregar Periferico</h4>
					</div>
					<div class="modal-body">

						<form action="Agregar" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="6"></input>
									<input type="text" class="form-control" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div> 
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<input type="submit" value="Agregar"
									class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>

	<div class=" container" id="editareliminar">

		<!-- Modal -->
		<div class="modal fade" id="editdelete" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar/Eliminar</h4>
					</div>
					<div class="modal-body">
						
						<form action="StepOne" method="post" class="">

							<div class="row">
								<div class="form-group col-md-6 col-md-offset-3">
									<label for="id_producto">Ingrese ID del producto que desea editar o eliminar</label> <input
										type="text" class="form-control" name="id_producto"
										id="id_producto" placeholder="ID Producto" required pattern="[0-9]{1,3}">
								</div>
							</div>

							<div class="modal-footer">
								<input type="submit" value="Buscar" class="btn btn-danger col-md-2 col-md-offset-5 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>
					
				</div>

			</div>
		</div>

	</div>

	

	<%
		ProductoDao dao = new ProductoDaoImpl();
		UsuarioDao daop = new UsuarioDaoImpl();
		
		List<Usuario> users = daop.listar();
		List<Producto> productos = dao.listarTodo();
		List<Producto> lowstock = dao.buscarProductoByLowStock();
	%>
	
	<section class="main container">
		<div class="table-responsive col-md-8 col-md-offset-2">
			<table class="table table-bordered" id="tusuarios">
				<h3 id="usuarios">Usuarios Registrados</h3>
				<tr class="table table-striped editable">
					<th>USERNAME</th>
					<th>E-MAIL</th>
					<th>PRIVILEGIOS</th>
				</tr>
		<%for(Usuario user: users){
			
		%>	
				<tr class="editable">
					<td><%=user.getUser()%></td>
					<td><%=user.getEmail()%></td>
				<%if(user.isPrivilegios()){ %>	
					<td>Admin</td>
				<%}else{ %>
					<td>Comun</td>
				<%}} %>
				</tr>
			
			</table>
		</div>
	
	</section>
	

	<section class="main container">
	<div class="table-responsive ">
		<table class="table " id="tprocesadores" name="procesadores" hidden >
			<h3 id="procesadores" hidden>Procesadores</h3>
			
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>NUCLEOS</th>
				<th>CACHE</th>
				
				
			</tr>	
			
			
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==0){
				Procesador ej=(Procesador) producto;
		%>
		

		
	
			<tr class="">
				<td><%=ej.getId_producto()%></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getCant_nucleos()%> Cores</td>
				<td><%=ej.getMem_cache()%> Mb</td>
			</tr>	
				<%}}%>
	</table>
		
	
			
		<table class="table" id="tmemorias" name="memorias" hidden>
			<h3 id="memorias" hidden>Memorias Ram</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>CAPACIDAD</th>
				<th>VELOCIDAD</th>
				
				
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==1){
			Memoria ej=(Memoria) producto;	
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=ej.getId_producto()%></a></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getCapacidad()%> Gb</td>
				<td><%=ej.getVelocidad()%> Mhz</td>
			</tr>
		<%}}%>
		
		
		
	</table>
		
		<table class="table" id="tdiscos" name="discos" hidden>
			<h3 id="discos" hidden>Discos</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>CAPACIDAD</th>
				<th>TIPO</th>
				
				
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==2){
			Almacenamiento ej=(Almacenamiento) producto;	
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=ej.getId_producto()%></a></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getCapacidad()%> Gb</td>
				<td><%=ej.getTipo()%></td>
			</tr>
		<%}}%>
		
		
		
	</table>
	
		<table class="table" id="tmotherboards" name="motherboard" hidden>
			<h3 id="motherboards" hidden>Motherboards</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>SOCKET</th>
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==3){
			Motherboard ej=(Motherboard) producto;	
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=ej.getId_producto()%></a></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getSocket()%></td>
			
			</tr>
		<%}}%>
		
		
		
	</table>
	
		<table class="table" id="tfuentes" name="fuente" hidden>
			<h3 id="fuentes" hidden>Fuentes</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>POTENCIA</th>
				<th>CERTIFICACION</th>
				
				
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==4){
			Fuente ej=(Fuente) producto;	
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=ej.getId_producto()%></a></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getPotencia()%> Watts</td>
				<td><%=ej.getCertificacion()%></td>
			</tr>
		<%}}%>
		
		
		
	</table>
		
		<table class="table" id="tgabinetes" name="gabinete" hidden>
			<h3 id="gabinetes" hidden>Gabinetes</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>DIMENSIONES</th>
				
				
				
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==5){
			Gabinete ej=(Gabinete) producto;	
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=ej.getId_producto()%></a></td>
				<td><%=ej.getMarca()%></td>
				<td><%=ej.getTipoCategoria()%></td>
				<td><%=ej.getDescripcion()%></td>
				<td>$ <%=ej.getPrecio()%></td>
				<td><%=ej.getStock_min()%></td>
				<td><%=ej.getStock_act()%></td>
				<td><%=ej.getDimension()%></td>
			
			</tr>
		<%}}%>
		
		
		
	</table>
		
		<table class="table" id="tperifericos" name="perifericos" hidden>
			<h3 id="perifericos" hidden>Perifericos</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
			</tr>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==6){
				
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=producto.getId_producto()%></a></td>
				<td><%=producto.getMarca()%></td>
				<td><%=producto.getTipoCategoria()%></td>
				<td><%=producto.getDescripcion()%></td>
				<td>$ <%=producto.getPrecio()%></td>
				<td><%=producto.getStock_min()%></td>
				<td><%=producto.getStock_act()%></td>
				
			</tr>
		<%}}%>
		
		
		
		
	</table>
		
			
	</div>
		 
	
	<div class="table-responsive ">
		 
		 <table class="table" id="tlowstock" name="lowstock" hidden>
			<h3 id="lowstock" hidden>Productos con Low Stock</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
			</tr>	
		
		<%for(Producto producto: lowstock){
			
				
		%>
			<tr class="">
				<td><a href="#" id="<%=producto.getId_producto()%>"><%=producto.getId_producto()%></a></td>
				<td><%=producto.getMarca()%></td>
				<td><%=producto.getTipoCategoria()%></td>
				<td><%=producto.getDescripcion()%></td>
				<td>$ <%=producto.getPrecio()%></td>
				<td><%=producto.getStock_min()%></td>
				<td><%=producto.getStock_act()%></td>
				
			</tr>
		<%}%>
		
		
	</table>
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
	<script src="js/scripts.js"></script>
	<script src="js/admin.js"></script>
</body>
</html>