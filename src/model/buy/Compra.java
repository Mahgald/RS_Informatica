package model.buy;

public class Compra {
	private int cantidad;
	private int id_productoCarrito;
	

	
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public int getId_productoCarrito() {
		return id_productoCarrito;
	}
	public void setId_productoCarrito(int id_productoCarrito) {
		this.id_productoCarrito = id_productoCarrito;
	}
	
	public Compra(int cantidad, int id_productoCarrito) {
		this.cantidad = cantidad;
		this.id_productoCarrito = id_productoCarrito;
	}

}
