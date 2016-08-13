package controllers;

import java.io.IOException;
import java.util.ArrayList;
import model.record.SendEmail;
import model.record.Usuario;
import servicesImplements.ShopCartService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.buy.Compra;
import model.products.Producto;

/**
 * Servlet implementation class CompraSinLoginController
 */
@WebServlet("/SinLogin")
public class CompraSinLoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nombre= request.getParameter("slnombre");
		String apellido= request.getParameter("slapellido");
		String email=request.getParameter("slemail");
		String dir=request.getParameter("sldireccion");
		String caracteristica=request.getParameter("slcaract");
		String fin= request.getParameter("sltel");
		String telefono="";
		if((request.getParameter("slquince")!=null)&&(request.getParameter("slquince")!="")){
			String quince = "15";
			telefono += "0"+caracteristica+" "+quince+" "+fin;
		}else{
			telefono+=caracteristica+" "+fin;
		}
		
		HttpSession session = request.getSession(true);
		ArrayList<Compra> carrito= session.getAttribute("cartshop")==null ? null :(ArrayList) session.getAttribute("cartshop");
		ShopCartService scs = new ShopCartService();
		
		String stringcompra="";
		Float total = (float) 0;
		for(Compra c: carrito){
			try {
				Producto prod = scs.getProducto(c.getId_productoCarrito());
				total+=(prod.getPrecio()*c.getCantidad()) ;
				stringcompra +="Producto: "+ prod.getDescripcion()+" Cantidad " + c.getCantidad() + " unidades Precio: $" + prod.getPrecio()+ "\n\n";
				
			} catch (Exception e) {
				
				e.printStackTrace();
			}	
			
		
		}
		
		stringcompra+="MONTO TOTAL $ "+total;
		
		
			
			String msgvendedor= "Ha recibido un pedido comuniquese con lo antes posible \n\n"
								+"Nombre: "+nombre+"\n"
								+"Apellido: "+apellido+"\n"
								+"Direccion: "+dir+"\n"
								+"Telefono: "+telefono+"\n"
								+"E-Mail: "+email+"\n"
								+ stringcompra;
			String msgcomprador = "Has recibido este mensaje debido a que has realizado una compra \n"
	                + "En las proximas 24hs un representante se estara comunicando contigo para concretar la compra. \n\n"
					+ stringcompra;
	                
	     
			SendEmail.send(email, "Notificacion de Compra", msgcomprador);
			
			SendEmail.send("rs.mail.informatica@gmail.com", "Notificacion de nuevo pedido", msgvendedor);
			
			session.removeAttribute("cartshop");
			response.sendRedirect("index.jsp");
		
	}

}
