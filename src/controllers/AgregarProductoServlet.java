package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.products.*;
import servicesImplements.ServicesCrud;

public class AgregarProductoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 
    public AgregarProductoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoria = Integer.parseInt(request.getParameter("cat"));
		ServicesCrud svc= new ServicesCrud();
		
		
		try {
			switch (categoria){
				
				case 0:
				
					Procesador proce=new Procesador(0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),(Integer.parseInt(request.getParameter("cantnucleos"))),(Integer.parseInt(request.getParameter("memcache"))));
					svc.agregarProducto(proce);
					response.sendRedirect("products.jsp#procesadores");
					break;
				case 1:
				
					Memoria mem=new Memoria(0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),(Integer.parseInt(request.getParameter("capacidad"))),(Integer.parseInt(request.getParameter("velocidad"))));
					svc.agregarProducto(mem);
					response.sendRedirect("products.jsp#memorias");
					break;
				case 2:
				
					String tipo= request.getParameter("tipo");
					if(tipo.compareToIgnoreCase("hdd")==0){
						Almacenamiento disc= new Almacenamiento(0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),(Integer.parseInt(request.getParameter("capacidad"))),false);
						svc.agregarProducto(disc);
						response.sendRedirect("products.jsp#discos");
						//break;
					}else{
						Almacenamiento disc= new Almacenamiento(0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),(Integer.parseInt(request.getParameter("capacidad"))),true);
						svc.agregarProducto(disc);
						response.sendRedirect("products.jsp#discos");
						break;
					}
				
				case 3:
				
					Motherboard mother= new Motherboard(0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),request.getParameter("socket"));
					svc.agregarProducto(mother);
					response.sendRedirect("products.jsp#mothers");
					break;
				case 4:
				
					Fuente fuente= new Fuente (0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),(Integer.parseInt(request.getParameter("potencia"))),request.getParameter("certificacion"));
					svc.agregarProducto(fuente);
					response.sendRedirect("products.jsp#fuentes");
					break;
				case 5:
				
					Gabinete gabo= new Gabinete (0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))),request.getParameter("dimensiones"));
					svc.agregarProducto(gabo);
					response.sendRedirect("products.jsp#gabinetes");
					break;
				case 6:
				
					Producto peri= new Producto (0,request.getParameter("marca"),categoria,request.getParameter("descripcion"),request.getParameter("imagen"),(Float.parseFloat(request.getParameter("precio"))),(Integer.parseInt(request.getParameter("stockmin"))),(Integer.parseInt(request.getParameter("stockact"))));
					svc.agregarProducto(peri);
					response.sendRedirect("products.jsp#peri");
					break;
			
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

}
