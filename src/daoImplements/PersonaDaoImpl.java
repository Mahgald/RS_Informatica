package daoImplements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.Conexion;
import daoInterfaces.PersonaDao;
import model.record.Persona;

public class PersonaDaoImpl extends Conexion implements PersonaDao {

	@Override
	public void registrar(Persona per) throws Exception {
		try {
			this.conectar();
			String consulta = "insert into usuarios (nombre,apellido,telefono,email,usuario,contraseña,privilegio)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, per.getNombre());
			st.setString(2, per.getApellido());
			st.setString(3, per.getTelefono());
			st.setString(4, per.getEmail());
			st.setString(5, per.getUser());
			st.setString(6, per.getPassword());
			st.setBoolean(7, false);
			st.executeUpdate(); 
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
		
	}

	@Override
	public void modificar(Persona per) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE usuarios set contraseña = ? where email = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, per.getPassword());
			st.setString(2, per.getEmail());
			st.executeUpdate(); 
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
		
	}

	@Override
	public Persona buscar(Persona per) throws Exception {
		
		try {
			this.conectar();
			
			String consulta = "SELECT * FROM usuarios WHERE email = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, per.getEmail());
			
			ResultSet rs = st.executeQuery();
				rs.next();
				Persona p = new Persona();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setTelefono(rs.getString("telefono"));
				p.setEmail(rs.getString("email"));
				p.setUser(rs.getString("usuario"));
				p.setPassword(rs.getString("contraseña"));
				p.setPrivilegio(rs.getBoolean("privilegio"));
				
				if(p.getEmail().equals(per.getEmail())){
					return p;
				}
			
			
		} catch (Exception e) {
			throw e;
		} finally{
			this.cerrar();
		}
		return null;
	}
	
	@Override
	public void eliminar(Persona per) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM usuarios WHERE email = ?";
			PreparedStatement st=this.conexion.prepareStatement(consulta);
			st.setString(1, per.getEmail());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		}finally{
			this.cerrar();
		}
	}

	@Override
	public List<Persona> listar() throws Exception {
		List<Persona> lista=null;
		try {
			this.conectar();
			String consulta = "SELECT * FROM usuarios";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			lista = new ArrayList<Persona>();
			ResultSet rs = st.executeQuery();
			
			while (rs.next()) {
				Persona per = new Persona();
				per.setNombre(rs.getString("nombre"));
				per.setApellido(rs.getString("apellido"));
				per.setTelefono(rs.getString("telefono"));
				per.setEmail(rs.getString("email"));
				per.setUser(rs.getString("usuario"));
				per.setPassword(rs.getString("contraseña"));
				per.setPrivilegio(rs.getBoolean("privilegio"));
				lista.add(per);
			}
		}catch(Exception e){
			throw e;
		}finally{
			this.cerrar();
		}
		
		return lista;	
	
	
	}

	@Override
	public boolean isRegistrado(Persona per) throws Exception {
		try {
			this.conectar();
			
			String consulta = "SELECT * FROM usuarios WHERE email = ? and usuario = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, per.getEmail());
			st.setString(2, per.getUser());
			
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Persona p = new Persona();
				p.setNombre(rs.getString("nombre"));
				p.setApellido(rs.getString("apellido"));
				p.setTelefono(rs.getString("telefono"));
				p.setEmail(rs.getString("email"));
				p.setUser(rs.getString("usuario"));
				p.setPassword(rs.getString("contraseña"));
				p.setPrivilegio(rs.getBoolean("privilegio"));
				
				if(p.getEmail().equals(per.getEmail()) && p.getUser().equals(per.getUser())){
					return true;
				}
			}
			
			
					
		} catch (Exception e) {
			throw e;
		} finally{
			this.cerrar();
		}
		return false;
	}

		
	


	
}



