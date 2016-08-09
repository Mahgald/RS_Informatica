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
 * Servlet implementation class EditStepOneController
 */
@WebServlet("/StepOne")
public class EditStepOneController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServicesCrud sv= new ServicesCrud();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id= request.getParameter("id_producto");
		Producto prod = new Producto();
		
		
		if((request.getParameter("id_producto") != null)&&(request.getParameter("id_producto")!="")){
			prod.setId_Producto(Integer.parseInt(request.getParameter("id_producto")));
		}else{
			prod=null;
		}
		
		try {
			if(prod!=null){
				if(prod.getId_producto() >0 & prod.getId_producto()<=sv.ultimoId()){
					//prod.setId_Producto(id_producto);
					request.setAttribute("producto", sv.buscarProducto(prod));
					request.setAttribute("empty", "nosoynull");
					request.getRequestDispatcher("editar.jsp").forward(request, response);
					
				}else{
					request.setAttribute("empty", "soynull");
					request.getRequestDispatcher("editar.jsp").forward(request, response);
				}
			}
			
			
		} catch (Exception e) {
			System.err.println("ERROR "+e);
			e.printStackTrace();
		}
		
	}

}
