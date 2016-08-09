package daoInterfaces;

import java.util.List;
import model.record.Persona;

public interface PersonaDao {

	void modificar(Persona per) throws Exception;
	public void eliminar(Persona per) throws Exception;
	
	public Persona buscar(Persona per) throws Exception;
	public List<Persona> listar() throws Exception;
	
	public void registrar(Persona per) throws Exception;
	public boolean isRegistrado(Persona per) throws Exception;
}
