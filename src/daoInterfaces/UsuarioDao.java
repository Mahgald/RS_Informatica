package daoInterfaces;

import java.util.List;

import model.record.Usuario;

public interface UsuarioDao {
	
	public void cambiarContraseña(Usuario user) throws Exception;
	public void cambiarEmail(Usuario user) throws Exception;
	
	public Usuario buscar(Usuario user) throws Exception;
	public List<Usuario> listar() throws Exception;
	
	public boolean logear(Usuario user)throws Exception;
	public boolean isUsuario(Usuario user) throws Exception;
}
