package daoImplements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.Conexion;
import daoInterfaces.UsuarioDao;
import model.record.Usuario;

public class UsuarioDaoImpl extends Conexion implements UsuarioDao {

	@Override
	public Usuario buscar(Usuario user) throws Exception,NullPointerException {
		try {
			this.conectar();
			String consulta = "SELECT * FROM usuarios WHERE usuario = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, user.getUser());

			ResultSet rs = st.executeQuery();
			Usuario u ;
			rs.next();
				u = new Usuario(rs.getString("email"),rs.getString("usuario"),rs.getBoolean("privilegio"),"000");
			

			if (u.getUser().equals(user.getUser())) {
				return u;
			}
		
		} catch (Exception e) {
			throw e;
		}
		this.cerrar();

		return null;

	}

	@Override
	public void cambiarContraseña(Usuario user) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE usuarios set contraseña = ? where usuario = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, user.getPassword());
			st.setString(2, user.getUser());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public void cambiarEmail(Usuario user) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE usuarios set email = ? where usuario = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, user.getEmail());
			st.setString(2, user.getUser());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

	}

	@Override
	public List<Usuario> listar() throws Exception {
		List<Usuario> lista = null;
		try {
			this.conectar();
			String consulta = "SELECT * FROM usuarios";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			lista = new ArrayList<Usuario>();
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Usuario user = new Usuario();
				user.setUser(rs.getString("usuario"));
				user.setEmail(rs.getString("email"));
				user.setPrivilegios(rs.getBoolean("privilegio"));

				lista.add(user);
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

		return lista;

	}

	@Override
	public boolean isUsuario(Usuario user) throws Exception {
		try {
			this.conectar();

			String consulta = "SELECT * FROM usuarios WHERE usuario = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, user.getUser());

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Usuario usr = new Usuario();
				usr.setUser((rs.getString("usuario")));
				usr.setEmail((rs.getString("email")));
				usr.setPrivilegios((rs.getBoolean("privilegio")));

				if (user.getUser().equals(user.getUser())) {
					return true;
				}
			}

		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}

	@Override
	public boolean logear(Usuario user) throws Exception {
		try {
			this.conectar();
			String consulta = "SELECT * FROM usuarios WHERE usuario = ? and contraseña = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, user.getUser());
			st.setString(2, user.getPassword());

			ResultSet rs = st.executeQuery();
			while(rs.next()){
				Usuario u = new Usuario();
				u.setUser(rs.getString("usuario"));
				u.setPassword(rs.getString("contraseña"));
				u.setPrivilegios(rs.getBoolean("privilegio"));

				if (u.getUser().equals(user.getUser()) && u.getPassword().equals(user.getPassword())) {
					return true;
				}
			}
		} catch (Exception e) {
			throw e;
		}
		this.cerrar();

		return false;
	}

}
