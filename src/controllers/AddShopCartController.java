package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.buy.Compra;


public class AddShopCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AddShopCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idproducto = Integer.parseInt(request.getParameter("idProducto"));
		int cantidad =  Integer.parseInt(request.getParameter("cantProductos"));
		
		HttpSession session = request.getSession(true);
		
		ArrayList<Compra> carrito= session.getAttribute("cartshop")==null ? new ArrayList<>() :(ArrayList) session.getAttribute("cartshop");
		
		boolean flag = false;
		
		if(carrito.size()>0){
			for(Compra c : carrito){
				if(idproducto == c.getId_productoCarrito()){
					c.setCantidad(c.getCantidad()+ cantidad);
					flag = true;
					break;
				}
			}
		}
		
		if(!flag){
			carrito.add(new Compra(cantidad, idproducto));
		}
		
		session.setAttribute("cartshop", carrito);
		
		response.sendRedirect("Redirection");;
		
	}

}
