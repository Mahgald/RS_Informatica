package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.record.Persona;
import servicesImplements.ServicesUsers;

/**
 * Servlet implementation class SignupController
 */

public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String nombre = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String telefono = request.getParameter("telefono");
		String email = request.getParameter("email");
		String usuario = request.getParameter("usuario");
		String password = request.getParameter("password");
		String remail = request.getParameter("remail");
		String rpassword = request.getParameter("rpassword");

		Persona per = new Persona(nombre,apellido,telefono,email,usuario,password);
		ServicesUsers sv = new ServicesUsers();
		
		if (email.equals(remail) && password.equals(rpassword)) {
			
			try {
				if (sv.registrarService(per)) {
					//response.sendRedirect("index.jsp");
					request.getRequestDispatcher("index.jsp").forward(request, response);
				} else {
					//response.sendRedirect("login.jsp");
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.err.println("ERROR "+e);
				e.printStackTrace();
			};

		} else {
			response.sendRedirect("signup.jsp");

		}

	}
}
