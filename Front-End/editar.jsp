<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ page import="daoImplements.ProductoDaoImpl"%>
<%@ page import="daoInterfaces.ProductoDao"%>
<%@ page import="java.util.List"%>
<%@ page import="model.products.*"%>
<%@ page import="javax.servlet.http.HttpServletRequest"%>

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
<body>
<%	
		if(session.getAttribute("adminLogin")!= null){
			
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	%>
	<header>
		<nav class="navbar navbar-fixed-top navbar-default" role="navigation">
			<div class="container col-md-10 col-md-offset-2 ">
				<div class="navbar-header ">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion">
						<span class="sr-only">Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>

					</button>
					<a href="#" class="navbar-brand">ADMINISTRACION - MODIFICAR/ELIMINAR</a>
				</div>

				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse "  id="navegacion">
					<ul class="nav navbar-nav busquedanav">
						<li class="active btn-danger active"><a href="admin.jsp">VOLVER</a></li> 
						
						<li><a href="#" data-toggle="modal" data-target="#editdelete">MODIFICAR/ELIMINAR PRODUCTO</a></li>
						</li>



					</ul>
				
					<form name="logout" action="CloseSessionController" method="post">
						<div class="login-signup-shoppingcart busqueda">
							
							<a href="admin.jsp" class="btn btn-md btn-danger "><span class="glyphicon glyphicon-log-in"></span> Admin </a>
																
							<a href="javascript:document.logout.submit()" class="btn btn-md btn-danger "><span class="glyphicon glyphicon-log-in"></span> Logout </a>
																
							
						</div>	
					</form>
				

				</div>
			</div>
		</nav>
	</header>
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

	<% if(request.getAttribute("empty") != "soynull"){ 
		if (request.getAttribute("producto") != null) {
			if ((((Producto) request.getAttribute("producto")).getCategoria()) == 0) {
				Procesador procesador = ((Procesador) request.getAttribute("producto"));
	%>
<div id="">
	<div class="container">
			<table class="table table-bordered" name="procesadores">
				<h3>Procesador</h3>

				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>NUCLEOS</th>
					<th>CACHE</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>

				<tr class=" editable">

					<td><a href="#"><%=procesador.getId_producto()%></a></td>
					<td><%=procesador.getMarca()%></td>
					<td><%=procesador.getTipoCategoria()%></td>
					<td><%=procesador.getDescripcion()%></td>
					<td>$ <%=procesador.getPrecio()%></td>
					<td><%=procesador.getStock_min()%></td>
					<td><%=procesador.getStock_act()%></td>
					<td><%=procesador.getCant_nucleos()%> Cores</td>
					<td><%=procesador.getMem_cache()%> Mb</td>
					<td><a href="#" data-toggle="modal" data-target="#modificarprocesador"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminarprocesador"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>
				</tr>
			</table>
	</div>	
		<div class="container" id="procesadorModal">

		<!-- Modal -->
		<div class="modal fade" id="modificarprocesador" role="dialog">
			<div class="modal-dialog">

				<!-- Modal content-->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Procesador</h4>
					</div>
					<div class="modal-body ">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="0"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=procesador.getId_producto()%>">
									<input type="text" class="form-control" value="<%=procesador.getMarca()%>" name="marca" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" value="<%=procesador.getDescripcion()%>" name="descripcion" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=procesador.getImg_producto()%>"  id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=procesador.getPrecio()%>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label> <input
										class="form-control" name="stockmin" value="<%=procesador.getStock_min()%>" id="stockmin" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> <input
										class="form-control" name="stockact" value="<%=procesador.getStock_act()%>" id="stockact" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="cantnucleos">Cantidad de Nucleos</label> <input
										class="form-control" name="cantnucleos" value="<%=procesador.getCant_nucleos()%>" id="cantnucleos" type="text"
										placeholder="" required pattern="[0-9]{1,2}"  title="Solo numeros" disabled>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="memcache">Memoria Cache</label> <input
										class="form-control" name="memcache" value="<%=procesador.getMem_cache()%>" id="memcache" type="text"
										placeholder="" required pattern="[0-9]{4,6}"  title="Solo numeros" disabled>
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminarprocesador" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Procesador</h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="0"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=procesador.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%=procesador.getTipoCategoria()%> <%= procesador.getDescripcion() %></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
			<%
				}/* Cierre del if(procesador) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 1) {
						Memoria memoria = ((Memoria) request.getAttribute("producto"));
			%>
	<div class="container">		
			<table class="table table-bordered" name="memorias">
				<h3>Memoria Ram</h3>
				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>CAPACIDAD</th>
					<th>VELOCIDAD</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>
				<tr class="editable">
					<td><a href="#"><%=memoria.getId_producto()%></a></td>
					<td><%=memoria.getMarca()%></td>
					<td><%=memoria.getTipoCategoria()%></td>
					<td><%=memoria.getDescripcion()%></td>
					<td>$ <%=memoria.getPrecio()%></td>
					<td><%=memoria.getStock_min()%></td>
					<td><%=memoria.getStock_act()%></td>
					<td><%=memoria.getCapacidad()%> Gb</td>
					<td><%=memoria.getVelocidad()%> Mhz</td>
					<td><a href="#" data-toggle="modal" data-target="#modificarmemoria"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminarmemoria"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>
				</tr>
			</table>
	</div>
	<div class="container" id="memoriasModal">

	<!-- 		Modal -->
		<div class="modal fade" id="modificarmemoria" role="dialog">
			<div class="modal-dialog">

	<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Memoria Ram</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="1"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=memoria.getId_producto()%>">
									<input type="text" class="form-control" name="marca" value="<%=memoria.getMarca()%>" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=memoria.getDescripcion()%>" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=memoria.getImg_producto()%>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=memoria.getPrecio()%>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%=memoria.getStock_min()%>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%=memoria.getStock_act()%>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="capacidad">Capacidad</label> <input
										class="form-control" name="capacidad" value="<%=memoria.getCapacidad()%>" id="capacidad" type="text"
										placeholder="" required pattern="[0-9]{4}" title="Solo numeros" disabled>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="velocidad">Velocidad</label> <input
										class="form-control" name="velocidad" value="<%=memoria.getVelocidad()%>" id="velocidad" type="text"
										placeholder="" required pattern="[0-9]{4,5}" title="Solo numeros" disabled>
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminarmemoria" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Memoria Ram </h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
								<input style="display:none;" type="text" name="cat" value="1"></input>
								<input style="display:none;" type="text" name="codigo" value="<%=memoria.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%=memoria.getTipoCategoria() %> <%= memoria.getDescripcion() %></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
			<%
				}/* Cierre del if(memorias) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 2) {
						Almacenamiento disco = ((Almacenamiento) request.getAttribute("producto"));
			%>
	<div class="container">		
			<table class="table table-bordered" name="discos">
				<h3>Disco</h3>
				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>CAPACIDAD</th>
					<th>TIPO</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>

				</tr>
				<tr class="editable">
					<td><a href="#"><%=disco.getId_producto()%></a></td>
					<td><%=disco.getMarca()%></td>
					<td><%=disco.getTipoCategoria()%></td>
					<td><%=disco.getDescripcion()%></td>
					<td>$ <%=disco.getPrecio()%></td>
					<td><%=disco.getStock_min()%></td>
					<td><%=disco.getStock_act()%></td>
					<td><%=disco.getCapacidad()%> Gb</td>
					<td><%=disco.getTipo()%></td>
					<td><a href="#" data-toggle="modal" data-target="#modificardisco"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminardisco"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>
				</tr>
			</table>
	</div>
	<div class="container" id="discoModal">

		<!-- 		Modal -->
		<div class="modal fade" id="modificardisco" role="dialog">
			<div class="modal-dialog">

		<!--	Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Disco</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="2"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=disco.getId_producto()%>">
									<input type="text" class="form-control" name="marca" value="<%=disco.getMarca() %>"  id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=disco.getDescripcion() %>" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=disco.getImg_producto() %>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=disco.getPrecio() %>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%=disco.getStock_min() %>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%=disco.getStock_act() %>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="capacidad">Capacidad</label> <input
										class="form-control" name="capacidad" value="<%=disco.getCapacidad() %>" id="capacidad" type="text"
										placeholder="" required pattern="[0-9]{1,2}" title="Solo numeros" disabled>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="tipo">Tipo</label> <input
										class="form-control" name="tipo" value="<%=disco.getTipo() %>" id="tipo" type="text"
										placeholder="" required disabled>
								</div>
							</div>
								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminardisco" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Disco </h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="2"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=disco.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%= disco.getTipoCategoria() %> <%= disco.getDescripcion()%></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>		
			<%
				}/* Cierre del if(discos) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 3) {
						Motherboard mother = ((Motherboard) request.getAttribute("producto"));
			%>
	<div class="container">		
			<table class="table table-bordered" name="motherboard">
				<h3>Motherboard</h3>
				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>SOCKET</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>
				</tr>
				<tr class="editable">
					<td><a href="#"><%=mother.getId_producto()%></a></td>
					<td><%=mother.getMarca()%></td>
					<td><%=mother.getTipoCategoria()%></td>
					<td><%=mother.getDescripcion()%></td>
					<td>$ <%=mother.getPrecio()%></td>
					<td><%=mother.getStock_min()%></td>
					<td><%=mother.getStock_act()%></td>
					<td><%=mother.getSocket()%></td>
					<td><a href="#" data-toggle="modal" data-target="#modificarmother"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminarmother"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>

				</tr>
			</table>

	</div>
	<div class="container" id="motherModal">

			<!-- 		Modal -->
		<div class="modal fade" id="modificarmother" role="dialog">
			<div class="modal-dialog">

			<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Motherboard</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="3"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=mother.getId_producto()%>">
									<input type="text" class="form-control" name="marca" value="<%= mother.getMarca() %>" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=mother.getDescripcion() %>" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%= mother.getImg_producto() %>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%= mother.getPrecio() %>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%= mother.getStock_min() %>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%= mother.getStock_act() %>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="socket">Socket</label> <input
										class="form-control" name="socket" value="<%= mother.getSocket() %>" id="socket" type="text"
										placeholder="" disabled>
								</div>
							</div>

								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminarmother" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Motherboard</h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="3"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=mother.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%= mother.getTipoCategoria() %> <%= mother.getDescripcion()%></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>		
			<%
				}/* Cierre del if(mother) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 4) {
						Fuente fuente = ((Fuente) request.getAttribute("producto"));
			%>
			
	<div class="container">		
			<table class="table table-bordered" name="fuente">
				<h3>Fuente</h3>
				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>POTENCIA</th>
					<th>CERTIFICACION</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>

				</tr>

				<tr class="editable">
					<td><a href="#"><%=fuente.getId_producto()%></a></td>
					<td><%=fuente.getMarca()%></td>
					<td><%=fuente.getTipoCategoria()%></td>
					<td><%=fuente.getDescripcion()%></td>
					<td>$ <%=fuente.getPrecio()%></td>
					<td><%=fuente.getStock_min()%></td>
					<td><%=fuente.getStock_act()%></td>
					<td><%=fuente.getPotencia()%> Watts</td>
					<td><%=fuente.getCertificacion()%></td>
					<td><a href="#" data-toggle="modal" data-target="#modificarfuente"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminarfuente"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>
				</tr>
			</table>
	</div>
	
	<div class="container" id="fuenteModal">

		<!-- 		Modal -->
		<div class="modal fade" id="modificarfuente" role="dialog">
			<div class="modal-dialog">

		<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Fuente</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label>
									<input style="display:none;" type="text" name="cat" value="4"></input>
									 <input style="display:none;" type="text" name="codigo" value="<%=fuente.getId_producto()%>">
									 <input type="text"
									 	
										class="form-control" name="marca" value="<%=fuente.getMarca() %>" id="marca" placeholder=""
										required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=fuente.getDescripcion() %>" id="descripcion"
										type="text" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=fuente.getImg_producto() %>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=fuente.getPrecio() %>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%=fuente.getStock_min() %>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%=fuente.getStock_act() %>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="potencia">Potencia</label> <input
										class="form-control" name="potencia" value="<%=fuente.getPotencia() %>" id="potencia" type="text"
										placeholder="" required pattern="[0-9]{1,4}" title="Solo numeros" disabled>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="certificacion">Certificacion</label> <input
										class="form-control" name="certificacion" value="<%=fuente.getCertificacion() %>" id="certificacion"
										type="text" placeholder="" disabled>
								</div>
							</div>

							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminarfuente" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Fuente </h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="4"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=fuente.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%= fuente.getTipoCategoria() %> <%= fuente.getDescripcion()%></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>		
			
			<%
				}/* Cierre del if(fuente) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 5) {
						Gabinete gabo = ((Gabinete) request.getAttribute("producto"));
			%>
	<div class="container">		
			<table class="table table-bordered" name="gabinete">
				<h3>Gabinete</h3>
				<tr class="table table-striped editable">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
					<th>DIMENSIONES</th>
					<th>EDITAR</th>
					<th>ELIMINAR</th>


				</tr>

				<tr class="editable">
					<td><a href="#"><%=gabo.getId_producto()%></a></td>
					<td><%=gabo.getMarca()%></td>
					<td><%=gabo.getTipoCategoria()%></td>
					<td><%=gabo.getDescripcion()%></td>
					<td>$ <%=gabo.getPrecio()%></td>
					<td><%=gabo.getStock_min()%></td>
					<td><%=gabo.getStock_act()%></td>
					<td><%=gabo.getDimension()%></td>
					<td><a href="#" data-toggle="modal" data-target="#modificargabo"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
					<td><a href="#" data-toggle="modal" data-target="#eliminargabo"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>

				</tr>
			</table>
	</div>
	<div class="container" id="gaboModal">

		<!-- 		Modal -->
		<div class="modal fade" id="modificargabo" role="dialog">
			<div class="modal-dialog">

			<!-- 				Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Gabinete</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="5"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=gabo.getId_producto()%>">
									<input type="text" class="form-control" name="marca" value="<%=gabo.getMarca() %>" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=gabo.getDescripcion() %>" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=gabo.getImg_producto() %>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=gabo.getPrecio() %>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%=gabo.getStock_min() %>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%=gabo.getStock_act() %>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="dimensiones">Dimensiones</label> <input
										class="form-control" name="dimensiones" value="<%= gabo.getDimension()%>" id="dimensiones" type="text"
										placeholder="" required disabled>
								</div>
							</div>

								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminargabo" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Gabinete </h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="5"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=gabo.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%= gabo.getTipoCategoria() %> <%= gabo.getDescripcion()%></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
			<%
				}/* Cierre del if(gabo) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 6) {
						Producto producto = ((Producto) request.getAttribute("producto"));
			%>
	<div class="container">		
		<table class="table table-bordered" name="perifericos">
			<h3>Periferico</h3>
			<tr class="table table-striped editable">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
				<th>EDITAR</th>
				<th>ELIMINAR</th>
			</tr>
			<tr class="editable">
				<td><a href="#"><%=producto.getId_producto()%></a></td>
				<td><%=producto.getMarca()%></td>
				<td><%=producto.getTipoCategoria()%></td>
				<td><%=producto.getDescripcion()%></td>
				<td>$ <%=producto.getPrecio()%></td>
				<td><%=producto.getStock_min()%></td>
				<td><%=producto.getStock_act()%></td>
				<td><a href="#" data-toggle="modal" data-target="#modificarperiferico"><span class="glyphicon glyphicon-pencil btn btn-default"></span></a> </td>
				<td><a href="#" data-toggle="modal" data-target="#eliminarperiferico"><span class="glyphicon glyphicon-glyphicon glyphicon-remove btn btn-danger"></span></a> </td>
			</tr>
	<div class="container" id="perifericoModal">

		<!-- 		Modal -->
		<div class="modal fade" id="modificarperiferico" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Editar Periferico</h4>
					</div>
					<div class="modal-body">

						<form action="Edit" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label for="marca">Marca</label> 
									<input style="display:none;" type="text" name="cat" value="6"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=producto.getId_producto()%>">
									<input type="text" class="form-control" name="marca" value="<%=producto.getMarca() %>" id="marca" placeholder="" required>
								</div>
							</div>

							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="descripcion">Descripcion</label> <input
										class="form-control" name="descripcion" value="<%=producto.getDescripcion() %>" id="descripcion" type="text"
										placeholder="" required>
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="imagen">Imagen del Producto</label> <input
										class="form-control" name="imagen" value="<%=producto.getImg_producto() %>" id="imagen" type="text"
										placeholder="" required>
								</div>
							</div> 
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="precio">Precio</label> <input
										class="form-control" name="precio" value="<%=producto.getPrecio() %>" id="precio" type="text"
										placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockmin">Stock Minimo</label>
									<input class="form-control" name="stockmin" value="<%=producto.getStock_min() %>" id="stockmin" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							<div class="row">
								<div class="form-group col-md-4 col-md-offset-4">
									<label class="" for="stockact">Stock Actual</label> 
									<input class="form-control" name="stockact" value="<%=producto.getStock_act() %>" id="stockact" type="text" placeholder="" required pattern="[0-9]{1,5}" title="Solo numeros">
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<input type="submit" value="Guardar Cambios"
									class="btn btn-danger col-md-6 col-md-offset-3 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>
		<div class="container" id="">

		<!-- 		Modal -->
		<div class="modal fade" id="eliminarperiferico" role="dialog">
			<div class="modal-dialog">

		|<!-- Modal content -->
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal">&times;</button>
						<h4 class="modal-title">Eliminar Periferico </h4>
					</div>
					<div class="modal-body">

						<form action="Delete" method="post" class=" form-inline" role="form">

							<div class="row">
								<div class="form-group col-md-8 col-md-offset-2">
									<input style="display:none;" type="text" name="cat" value="6"></input>
									<input style="display:none;" type="text" name="codigo" value="<%=producto.getId_producto()%>">
									<p class="modalparrafo">Esta por eliminar <%= producto.getTipoCategoria() %> <%= producto.getDescripcion()%></p>
								</div>
							</div>
							
							
								
							<div class="modal-footer">
								<button class="btn btn-default" data-dismiss="modal">Cancelar</button>
								<input type="submit" value="Eliminar" class="btn btn-danger col-md-4 col-md-offset-4 col-xs-4 col-xs-offset-4 ">
							</div>
						</form>
					</div>

				</div>

			</div>
		</div>

	</div>			
				<%}} /* Cierre del if(perifericos) */ %>
		</table>
		
		
	</div>
</div>	
	
	
	
	<%} else{ %>
		<div class="container">
			<h1>El codigo ingresado no existe en el sistema</h1>	
		</div>
	<%} %>

	
	
	
	






	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>

	
	
</body>
</html>