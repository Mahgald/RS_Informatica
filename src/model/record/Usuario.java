package model.record;

public class Usuario {
	private String email;
	private String user;
	private String password;
	
	private boolean privilegios;
	
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
	public boolean isPrivilegios() {
		return privilegios;
	}
	public void setPrivilegios(boolean privilegios) {
		this.privilegios = privilegios;
	}
	
	public Usuario(){
		
	}
	public Usuario(String email, String user, boolean privilegios, String password) {
		this.email = email;
		this.user = user;
		this.privilegios = privilegios;
		this.password = password;
	}
	
	@Override
	public String toString() {
		if(this.privilegios){
			return "User = "+user+" --> " +"Email = "+ email + " --> " +"Tipo = "+ "Admin";
		}return "User = "+user+" --> " +"Email = "+ email + " --> " +"Tipo = "+ "User";
		
	}
	
	
	
}
