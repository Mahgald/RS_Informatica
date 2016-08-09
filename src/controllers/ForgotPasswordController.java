package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daoImplements.PersonaDaoImpl;
import daoInterfaces.PersonaDao;
import model.record.Persona;
import model.record.SendEmail;

@WebServlet("/ForgotPassword")
public class ForgotPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email = request.getParameter("email");    
		Persona per= new Persona();
		per.setEmail(email);
		
		PersonaDao dao = new PersonaDaoImpl();
		
		
		try {
			per = dao.buscar(per);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String msg = "Has recibido este mensaje debido a que has olvidado tu contraseña. \n"
                + "Si no has sido tú el solicitante, por favor no ignora este mail. \n\n"
                + "La clave es: " + per.getPassword() ;
     
		SendEmail.send(email, "Forgotten Password", msg);
		response.sendRedirect("login.jsp");
	       
	}

}
