package model.products;

public class Motherboard extends Producto {
	
	private String socket;

	public String getSocket() {
		return socket;
	}
	public void setSocket(String socket) {
		this.socket = socket;
	}
	
	public Motherboard() {
		
	}
	
	public Motherboard(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, String socket) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.socket = socket;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " socket= " + socket;
	}
	
	
	
}
