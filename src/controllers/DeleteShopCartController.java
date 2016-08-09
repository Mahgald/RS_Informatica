package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.buy.Compra;

import java.util.ArrayList;


public class DeleteShopCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteShopCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int idproducto = Integer.parseInt(request.getParameter("idproducto"));
		
  		HttpSession session = request.getSession(true);
  		
		ArrayList<Compra> carrito= session.getAttribute("cartshop")==null ? null :(ArrayList) session.getAttribute("cartshop");
		
		if(carrito != null){
			for(Compra c : carrito){
				if(c.getId_productoCarrito()==idproducto){
					carrito.remove(c);
					break;
				}
			}
		}
		
		
	}

}
