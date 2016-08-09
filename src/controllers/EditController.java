package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.products.Almacenamiento;
import model.products.Fuente;
import model.products.Gabinete;
import model.products.Memoria;
import model.products.Motherboard;
import model.products.Procesador;
import model.products.Producto;
import servicesImplements.ServicesCrud;

/**
 * Servlet implementation class EditController
 */
@WebServlet("/Edit")
public class EditController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoria = Integer.parseInt(request.getParameter("cat"));
		ServicesCrud svc= new ServicesCrud();
		
		
		try {
			switch (categoria){
				
				case 0:
					
					Producto prod=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(prod)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
										
				case 1:
				
					Producto memoria=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(memoria)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
				case 2:
				
					Producto disco=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(disco)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
				
				case 3:
				
					Producto mother=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(mother)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
				case 4:
				
					Producto fuente=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(fuente)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
				case 5:
				
					Producto gabo=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(gabo)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
				case 6:
				
					Producto periferico=new Producto((Integer.parseInt(request.getParameter("codigo"))),request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					if(svc.modificarProducto(periferico)){
						response.sendRedirect("editar.jsp");
						break;
					}else{
						break;
					}
			
			}
			
		} catch (Exception e) {
			System.err.println("ERROR "+e);
			e.printStackTrace();
		}
		
		
		
		
	}

}
