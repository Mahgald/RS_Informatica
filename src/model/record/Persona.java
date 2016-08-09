package model.record;

import model.buy.Compra;
import model.products.Producto;

public class Persona {
	private String nombre;
	private String apellido;
	private String telefono;
	private String email;
	private String user;
	private String password;
	private boolean privilegios=false;
	private Compra [] compra;
	private Producto [] producto;

	public Producto[] getProducto() {
		return producto;
	}
	public void setProducto(Producto[] producto) {
		this.producto = producto;
	}
	public Compra[] getCompra() {
		return compra;
	}
	public void setCompra(Compra[] compra) {
		this.compra = compra;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	public Persona(String nombre, String apellido, String telefono, String email, String user, String password) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.email = email;
		this.user = user;
		this.password = password;
	}
	
	public Persona(){
		
	}
	@Override
	public String toString() {
		if(this.privilegios){
			return nombre+" " + apellido+" " + telefono+" " + email+" " + user+" " +  password+" " + "Admin" ;
		}return nombre+" " + apellido+" " + telefono+" " + email+" " + user+" " +  password+" " + "User";
		
	}
	public void setPrivilegio(boolean privilegio) {
		this.privilegios= privilegio;
		
	};
	
	
	
}
