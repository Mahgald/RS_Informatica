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
			<div class="container col-md-8 col-md-offset-4 ">
				<div class="navbar-header ">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#navegacion">
						<span class="sr-only">Desplegar / Ocultar Menu</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>

					</button>
					<a href="#" class="navbar-brand">ADMINISTRACION - BUSQUEDA</a>
				</div>

				<!-- Inicia Menu -->
				<div class="collapse navbar-collapse "  id="navegacion">
					<ul class="nav navbar-nav busquedanav">
						<li class="active btn-danger active"><a href="admin.jsp">VOLVER</a></li> 
						
						<li><a href="#" data-toggle="modal" data-target="#myModal">BUSCAR PRODUCTO</a></li>
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

	<div class=" container">

		<!-- Modal -->
		<div class="modal fade" id="myModal" role="dialog">
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
									<label for="id_producto">ID Producto</label> <input
										type="text" class="form-control" name="id_producto"
										id="id_producto" placeholder="ID Producto">
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
	<div class="co">
	<section class="main container">
		<div class="table-responsive ">
			<table class="table " name="procesadores">
				<h3>Procesadores</h3>

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

				<tr class="">

					<td><a href="#"><%=procesador.getId_producto()%></a></td>
					<td><%=procesador.getMarca()%></td>
					<td><%=procesador.getTipoCategoria()%></td>
					<td><%=procesador.getDescripcion()%></td>
					<td>$ <%=procesador.getPrecio()%></td>
					<td><%=procesador.getStock_min()%></td>
					<td><%=procesador.getStock_act()%></td>
					<td><%=procesador.getCant_nucleos()%> Cores</td>
					<td><%=procesador.getMem_cache()%> Mb</td>
				</tr>
			</table>
			<%
				}/* Cierre del if(procesador) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 1) {
						Memoria memoria = ((Memoria) request.getAttribute("producto"));
			%>
			<table class="table" name="memorias">
				<h3>Memorias Ram</h3>
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
				<tr class="">
					<td><a href="#"><%=memoria.getId_producto()%></a></td>
					<td><%=memoria.getMarca()%></td>
					<td><%=memoria.getTipoCategoria()%></td>
					<td><%=memoria.getDescripcion()%></td>
					<td>$ <%=memoria.getPrecio()%></td>
					<td><%=memoria.getStock_min()%></td>
					<td><%=memoria.getStock_act()%></td>
					<td><%=memoria.getCapacidad()%> Gb</td>
					<td><%=memoria.getVelocidad()%> Mhz</td>
				</tr>
			</table>
			<%
				}/* Cierre del if(memorias) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 2) {
						Almacenamiento disco = ((Almacenamiento) request.getAttribute("producto"));
			%>
			<table class="table" name="discos">
				<h3>Discos</h3>
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
				<tr class="">
					<td><a href="#"><%=disco.getId_producto()%></a></td>
					<td><%=disco.getMarca()%></td>
					<td><%=disco.getTipoCategoria()%></td>
					<td><%=disco.getDescripcion()%></td>
					<td>$ <%=disco.getPrecio()%></td>
					<td><%=disco.getStock_min()%></td>
					<td><%=disco.getStock_act()%></td>
					<td><%=disco.getCapacidad()%> Gb</td>
					<td><%=disco.getTipo()%></td>
				</tr>
			</table>

			<%
				}/* Cierre del if(discos) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 3) {
						Motherboard mother = ((Motherboard) request.getAttribute("producto"));
			%>
			<table class="table" name="motherboard">
				<h3>Motherboards</h3>
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
				<tr class="">
					<td><a href="#"><%=mother.getId_producto()%></a></td>
					<td><%=mother.getMarca()%></td>
					<td><%=mother.getTipoCategoria()%></td>
					<td><%=mother.getDescripcion()%></td>
					<td>$ <%=mother.getPrecio()%></td>
					<td><%=mother.getStock_min()%></td>
					<td><%=mother.getStock_act()%></td>
					<td><%=mother.getSocket()%></td>

				</tr>
			</table>


			<%
				}/* Cierre del if(mother) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 4) {
						Fuente fuente = ((Fuente) request.getAttribute("producto"));
			%>
			<table class="table" name="fuente">
				<h3>Fuentes</h3>
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

				<tr class="">
					<td><a href="#"><%=fuente.getId_producto()%></a></td>
					<td><%=fuente.getMarca()%></td>
					<td><%=fuente.getTipoCategoria()%></td>
					<td><%=fuente.getDescripcion()%></td>
					<td>$ <%=fuente.getPrecio()%></td>
					<td><%=fuente.getStock_min()%></td>
					<td><%=fuente.getStock_act()%></td>
					<td><%=fuente.getPotencia()%> Watts</td>
					<td><%=fuente.getCertificacion()%></td>
				</tr>
			</table>

			<%
				}/* Cierre del if(fuente) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 5) {
						Gabinete gabo = ((Gabinete) request.getAttribute("producto"));
			%>
			<table class="table" name="gabinete">
				<h3>Gabinetes</h3>
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

				<tr class="">
					<td><a href="#"><%=gabo.getId_producto()%></a></td>
					<td><%=gabo.getMarca()%></td>
					<td><%=gabo.getTipoCategoria()%></td>
					<td><%=gabo.getDescripcion()%></td>
					<td>$ <%=gabo.getPrecio()%></td>
					<td><%=gabo.getStock_min()%></td>
					<td><%=gabo.getStock_act()%></td>
					<td><%=gabo.getDimension()%></td>

				</tr>
			</table>
			<%
				}/* Cierre del if(gabo) */
					if ((((Producto) request.getAttribute("producto")).getCategoria()) == 6) {
						Producto producto = ((Producto) request.getAttribute("producto"));
			%>
			<table class="table" name="perifericos">
				<h3>Perifericos</h3>
				<tr class="table table-striped">
					<th>ID</th>
					<th>MARCA</th>
					<th>CATEGORIA</th>
					<th>DESCRIPCION</th>
					<th>PRECIO</th>
					<th>STOCK MINIMO</th>
					<th>STOCK ACTUAL</th>
				</tr>

				<tr class="">
					<td><a href="#"><%=producto.getId_producto()%></a></td>
					<td><%=producto.getMarca()%></td>
					<td><%=producto.getTipoCategoria()%></td>
					<td><%=producto.getDescripcion()%></td>
					<td>$ <%=producto.getPrecio()%></td>
					<td><%=producto.getStock_min()%></td>
					<td><%=producto.getStock_act()%></td>

				</tr>
				<%}} /* Cierre del if(perifericos) */ %>
		</table>
		</div>
	</section>
	
	
	
	<%if (request.getAttribute("categoria") != null) { 
		List<Producto> productos = (List<Producto>)request.getAttribute("categoria");
		if(!productos.isEmpty()){	
		
	%>
	
		<section class="main container" name="tabla categorias">
	
	<div class="table-responsive col-md-10 col-md-offset-1">
	<%Producto pr = productos.get(0);
		if(pr.getCategoria()==0){ %>
		<table class="table " name="procesadores">
			<h3>Procesadores</h3>
			
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
			
		<%} %>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==0){
				Procesador ej=(Procesador) producto;
		%>
		
			<tr class="">
				
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto mem = productos.get(0);
		if(mem.getCategoria()==1){ %>	
		<table class="table" name="memorias">
			<h3>Memorias Ram</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==1){
			Memoria ej=(Memoria) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto dis = productos.get(0);
		if(dis.getCategoria()==2){ %>
		<table class="table" name="discos">
			<h3>Discos</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==2){
			Almacenamiento ej=(Almacenamiento) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
	<%Producto mot = productos.get(0);
		if(mot.getCategoria()==3){ %>
		<table class="table" name="motherboard">
			<h3>Motherboards</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==3){
			Motherboard ej=(Motherboard) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
	<%Producto fu = productos.get(0);
		if(fu.getCategoria()==4){ %>
		<table class="table" name="fuente">
			<h3>Fuentes</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==4){
			Fuente ej=(Fuente) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto gab = productos.get(0);
		if(gab.getCategoria()==5){ %>
		<table class="table" name="gabinete">
			<h3>Gabinetes</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==5){
			Gabinete ej=(Gabinete) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto p = productos.get(0);
		if(p.getCategoria()==6){ %>
		<table class="table" name="perifericos">
			<h3>Perifericos</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
			</tr>	
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==6){
				
		%>
			<tr class="">
				<td><a href="#"><%=producto.getId_producto()%></a></td>
				<td><%=producto.getMarca()%></td>
				<td><%=producto.getTipoCategoria()%></td>
				<td><%=producto.getDescripcion()%></td>
				<td>$ <%=producto.getPrecio()%></td>
				<td><%=producto.getStock_min()%></td>
				<td><%=producto.getStock_act()%></td>
				
			</tr>
		<%}}}%>
		
		
		
		
	</table>
		
		
		 </div>
</section>
	
	
	<%}else{ if (request.getAttribute("marca") != null ) { 
		List<Producto> productos = (List<Producto>)request.getAttribute("marca");
			if(!productos.isEmpty()){
		
	%>
	
		<section class="main container">
	
	<div class="table-responsive col-md-10 col-md-offset-1" name="tabla marcas">
	<%Producto pr = productos.get(0);
		if(pr.getCategoria()==0){ %>
		<table class="table " name="procesadores">
			<h3>Procesadores</h3>
			
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
			
		<%} %>	
		
		<%for(Producto producto: productos){
			if(producto.getCategoria()==0){
				Procesador ej=(Procesador) producto;
		%>
		
			<tr class="">
				
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto mem = productos.get(0);
		if(mem.getCategoria()==1){ %>	
		<table class="table" name="memorias">
			<h3>Memorias Ram</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==1){
			Memoria ej=(Memoria) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto dis = productos.get(0);
		if(dis.getCategoria()==2){ %>
		<table class="table" name="discos">
			<h3>Discos</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==2){
			Almacenamiento ej=(Almacenamiento) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
	<%Producto mot = productos.get(0);
		if(mot.getCategoria()==3){ %>
		<table class="table" name="motherboard">
			<h3>Motherboards</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==3){
			Motherboard ej=(Motherboard) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
	<%Producto fu = productos.get(0);
		if(fu.getCategoria()==4){ %>
		<table class="table" name="fuente">
			<h3>Fuentes</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==4){
			Fuente ej=(Fuente) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto gab = productos.get(0);
		if(gab.getCategoria()==5){ %>
		<table class="table" name="gabinete">
			<h3>Gabinetes</h3>
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
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==5){
			Gabinete ej=(Gabinete) producto;	
		%>
			<tr class="">
				<td><a href="#"><%=ej.getId_producto()%></a></td>
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
		<%Producto p = productos.get(0);
		if(p.getCategoria()==6){ %>
		<table class="table" name="perifericos">
			<h3>Perifericos</h3>
			<tr class="table table-striped">
				<th>ID</th>
				<th>MARCA</th>
				<th>CATEGORIA</th>
				<th>DESCRIPCION</th>
				<th>PRECIO</th>
				<th>STOCK MINIMO</th>
				<th>STOCK ACTUAL</th>
			</tr>	
		<%} %>
		<%for(Producto producto: productos){
			if(producto.getCategoria()==6){
				
		%>
			<tr class="">
				<td><a href="#"><%=producto.getId_producto()%></a></td>
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
</section>
	
	
	<%}}} %>
	<%} else{ %>
		<h1>No se busco nada</h1>	
	<%} %>






	<script src="https://code.jquery.com/jquery-latest.js"></script>
	<script src="js/bootstrap.min.js"></script>

	
	
</body>
</html>