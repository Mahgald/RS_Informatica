package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.products.Producto;
import servicesImplements.ServicesCrud;
import sun.java2d.pipe.OutlineTextRenderer;

public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
		ServicesCrud sv= new ServicesCrud();
	  
		public SearchController() {
        super();
        // TODO Auto-generated constructor stub
		}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String id= request.getParameter("id_producto");
		String marca= request.getParameter("marca");
		String categoria= request.getParameter("categoria");
		
		Producto prod = new Producto();
		prod.setCategoria(-1);
		if(((request.getParameter("id_producto") != null) || (request.getParameter("categoria") != null)) || (request.getParameter("marca") != null)){
			if((request.getParameter("id_producto") != null)&&(request.getParameter("id_producto")!="")){
				prod.setId_Producto(Integer.parseInt(request.getParameter("id_producto"))); 
			}else{
				if((request.getParameter("categoria") != null)&& (request.getParameter("categoria") != "")){
					prod.setCategoria(Integer.parseInt(request.getParameter("categoria")));
				}else{
					if((request.getParameter("marca") != null) && (request.getParameter("marca") != "")){
						prod.setMarca(request.getParameter("marca"));
					}
				}
			}
		}else{
			prod=null;
		}
					
		//HttpSession dataSession = request.getSession(false);
				
		try {
			if(prod!=null){
				if(prod.getId_producto() >0 & prod.getId_producto()<=sv.ultimoId()){
					//prod.setId_Producto(id_producto);
					request.setAttribute("producto", sv.buscarProducto(prod));
					request.setAttribute("empty", "nosoynull");
					request.getRequestDispatcher("busqueda.jsp").forward(request, response);
				}else{
					if(prod.getCategoria()>=0 & prod.getCategoria()<=6){
						
						//prod.setCategoria(cat);
						request.setAttribute("categoria", sv.buscarProductos(prod));
						request.setAttribute("empty", "nosoynull");
						request.getRequestDispatcher("busqueda.jsp").forward(request, response);
					}else{
							if(sv.existeMarca(prod)){
								request.setAttribute("marca", sv.buscarProductos(prod));
								request.setAttribute("empty", "nosoynull");
								request.getRequestDispatcher("busqueda.jsp").forward(request, response);
							
								
							}else{
								request.setAttribute("marca", null);
								request.setAttribute("empty", "soynull");
								request.getRequestDispatcher("busqueda.jsp").forward(request, response);
							}
					}
				}
			}else{
				if(prod.getCategoria()>6)
				request.setAttribute("empty", "soynull");
				request.getRequestDispatcher("busqueda.jsp").forward(request, response);
			}
			
			
			
		//	prod.setId_Producto(id_producto);
		//	request.setAttribute("producto", sv.buscarProducto(prod));
		//	request.getRequestDispatcher("busqueda.jsp").forward(request, response);
		
		
		} catch (Exception e1) {
			System.err.println("ERROR ACA "+e1);
			e1.printStackTrace();
		}
		
	}}	
	


