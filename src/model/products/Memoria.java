package model.products;

public class Memoria extends Producto {
	private int capacidad;
	private int velocidad;
	
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public int getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}
	
	public Memoria() {
		
	}
	
	public Memoria(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, int capacidad, int velocidad) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.capacidad = capacidad;
		this.velocidad = velocidad;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " capacidad= " + capacidad + " velocidad= " + velocidad;
	}
}
