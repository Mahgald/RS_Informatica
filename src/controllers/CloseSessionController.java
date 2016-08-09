package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.record.Usuario;
import servicesImplements.ServicesUsers;

/**
 * Servlet implementation class CloseSessionController
 */

public class CloseSessionController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CloseSessionController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		ServicesUsers sv=new ServicesUsers();
		Usuario admin= (Usuario)session.getAttribute("adminLogin");
		
		
		Usuario user= (Usuario)session.getAttribute("userLogin");
		
		try {
			if(admin != null){
				session.removeAttribute("adminLogin");
				session.removeAttribute("cartshop");
				//request.getRequestDispatcher("index.jsp").forward(request, response);
				response.sendRedirect("index.jsp");
			}else{
				if(user !=null){
					session.removeAttribute("userLogin");
					session.removeAttribute("cartshop");
					//request.getRequestDispatcher("index.jsp").forward(request, response);
					response.sendRedirect("index.jsp");
				}
			}
			
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
