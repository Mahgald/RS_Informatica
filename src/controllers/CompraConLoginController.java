package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import daoImplements.UsuarioDaoImpl;
import model.record.SendEmail;
import model.buy.Compra;
import model.products.Producto;
import model.record.Usuario;
import servicesImplements.ServicesUsers;
import servicesImplements.ShopCartService;
import servicesInterfaces.UserServiceInterface;

/**
 * Servlet implementation class CompraConLoginController
 */
@WebServlet("/ConLogin")
public class CompraConLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		ArrayList<Compra> carrito= session.getAttribute("cartshop")==null ? null :(ArrayList) session.getAttribute("cartshop");
		UsuarioDaoImpl sv= new UsuarioDaoImpl();
		ShopCartService scs = new ShopCartService();
		
		
		Usuario user= new Usuario();
		Usuario u;
		String stringcompra="";
		Float total = (float) 0;
		for(Compra c: carrito){
			try {
				Producto prod = scs.getProducto(c.getId_productoCarrito());
				total+=(prod.getPrecio()*c.getCantidad()) ;
				stringcompra +="Producto: "+ prod.getDescripcion()+" Cantidad " + c.getCantidad() + " unidades Precio: $" + prod.getPrecio()+ "\n\n";
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		
		}
		
		stringcompra+="MONTO TOTAL $ "+total;
		
		user = (Usuario) session.getAttribute("userLogin");
		try {
			u=sv.buscar(user);
			String msgvendedor= "Ha recibido un pedido de " + u.getEmail() +" Comuniquese con lo antes posible \n\n"+
			stringcompra;
			String msgcomprador = "Has recibido este mensaje debido a que has realizado una compra \n"
	                + "En las proximas 24hs un representante se estara comunicando contigo para concretar la compra. \n\n"
					+ stringcompra;
	                
	     
			SendEmail.send(u.getEmail(), "Notificacion de Compra", msgcomprador);
			
			SendEmail.send("rs.mail.informatica@gmail.com", "Notificacion de nuevo pedido", msgvendedor);
			
			session.removeAttribute("cartshop");
			response.sendRedirect("index.jsp");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		}	

}
	
