package conection;

import java.sql.DriverManager;
import java.sql.Connection;


public class Conexion {
	// Credenciales
	private final String USERNAME = "root";
	private final String PASSWORD = "Sur.1989";
	
	// Host, puerto y nombre de la base de datos
	private final String HOST = "localhost";
	private final String PORT = "3306";
	private final String DATABASE = "rs_informatica";
	
	// Jdbc driver nombre y url base de datos
	private final String CLASSNAME = "com.mysql.jdbc.Driver";
	private final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/"+DATABASE;
	
	protected Connection conexion;
	
	public void conectar() throws Exception {
		try {
			Class.forName(CLASSNAME);
			conexion = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (Exception e) {
			System.err.println("Error "+e);
			throw e;
		}
	}
	
	public void cerrar() throws Exception {
		if(conexion != null){
			if(!conexion.isClosed()){
				conexion.close();
			}
		}
	}

	
}
