package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.record.Usuario;
import servicesImplements.ServicesUsers;

public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession(false);
		
		String usuario=request.getParameter("usuario");
		String password=request.getParameter("password");
		
		Usuario user= new Usuario();
		user.setUser(usuario);
		user.setPassword(password);
		
		
		//session.setAttribute("usuarioLogin",user);
		
		ServicesUsers sv = new ServicesUsers();
		
		try {
			if(sv.logearService(user)){
				if(sv.tienePrivilegios(user)){
					
					/*Entra si es admin */
					session.setAttribute("adminLogin",user);
					request.getRequestDispatcher("AdminLoginController").forward(request, response);
					
					
				}else{
				
					/*Entra si es user comun */
					session.setAttribute("userLogin",user);
					request.getRequestDispatcher("UserLoginController").forward(request, response);
					
				
				}	
			}else{
				/*Si hay error de user o password */
				//request.getRequestDispatcher("login.jsp").forward(request, response);
				response.sendRedirect("login.jsp");
			}
		} catch (Exception e) {
			System.err.println("ERROR "+e);
			e.printStackTrace();
		}
	}

}
