package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servicesImplements.ShopCartService;
import sun.java2d.pipe.OutlineTextRenderer;


public class ProductsController extends HttpServlet {
	ShopCartService productos= new ShopCartService();
	
	private static final long serialVersionUID = 1L;
       
   
    public ProductsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String proce= request.getParameter("procesadores");
		String memo=request.getParameter("memorias");
		PrintWriter out = response.getWriter();
		
		
		out.println("<h1>"+ proce + " "+ memo +" </h1>");
		
		
		HttpSession showproductos= request.getSession(false); 
		
		
		try {
				response.sendRedirect("shop.jsp");
				
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		
		
		
		
		
		
		
		
		
		
		
	}

}
