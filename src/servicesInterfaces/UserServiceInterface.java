package servicesInterfaces;

import java.util.List;

import model.record.*;

public interface UserServiceInterface {
		
	public boolean registrarService(Persona per)throws Exception;
	
	//public boolean isLogeadoService(Usuario user) throws Exception;
	
	public boolean logearService(Usuario user) throws Exception;
	
	public boolean tienePrivilegios(Usuario user) throws Exception;
	
	public boolean cambiarContraseñaService(Usuario User) throws Exception;
	
	public List<Usuario> listarService() throws Exception;
	
}
