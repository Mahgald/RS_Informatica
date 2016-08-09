package servicesImplements;

import java.util.List;

import daoImplements.*;
import daoInterfaces.PersonaDao;
import daoInterfaces.UsuarioDao;
import model.record.Persona;
import model.record.Usuario;
import servicesInterfaces.UserServiceInterface;

public class ServicesUsers implements UserServiceInterface{

	@Override
	public boolean registrarService(Persona per) throws Exception {
		PersonaDao perDao=new PersonaDaoImpl();
		
		if(perDao.isRegistrado(per)){
			return false;
		}else{
			perDao.registrar(per);
			return true;
		}
	}
	
	@Override
	public boolean logearService(Usuario user) throws Exception {
		UsuarioDao userDao = new UsuarioDaoImpl();
		
		if(userDao.logear(user)){
			
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public boolean tienePrivilegios(Usuario user) throws Exception {
		UsuarioDao userDao = new UsuarioDaoImpl();
		Usuario u= userDao.buscar(user);
		
		if(u.isPrivilegios() && u!=null){
			return true;
		}else{
			return false;
		}
	}

	

	@Override
	public boolean cambiarContraseñaService(Usuario user) throws Exception {
		UsuarioDao userDao = new UsuarioDaoImpl();
		
		if(this.logearService(user)){
			userDao.cambiarContraseña(user);
			return true;
		}else{
			return false;
		}
	}

	@Override
	public List<Usuario> listarService() throws Exception {
		UsuarioDao userDao = new UsuarioDaoImpl();
		if(userDao.listar() != null){
			return userDao.listar();
		}else{
			return null;
		}
	}

	
	
	

	
	
}
