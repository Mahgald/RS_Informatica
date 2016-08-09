package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.products.Producto;
import servicesImplements.ServicesCrud;

/**
 * Servlet implementation class DeleteController
 */
@WebServlet("/Delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoria = Integer.parseInt(request.getParameter("cat"));
		int id = Integer.parseInt(request.getParameter("codigo"));
		ServicesCrud svc= new ServicesCrud();
		
		
		try {
			
			Producto prod=new Producto();
			prod.setCategoria(categoria);
			prod.setId_Producto(id);
			if(svc.eliminarProducto(prod)){
				response.sendRedirect("admin.jsp");
				
			}else{
				response.sendRedirect("editar.jsp");
			}
			
			
			
		} catch (Exception e) {
			System.err.println("ERROR "+e);
			e.printStackTrace();
		}
	}

}
