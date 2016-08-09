package model.products;

public class Almacenamiento extends Producto {
	
	private int capacidad;
	private boolean ssd;
	private String tipo;
	public int getCapacidad() {
		return capacidad;
	}
	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}
	public boolean isSsd() {
		return ssd;
	}
	public void setSsd(boolean ssd) {
		this.ssd = ssd;
	}
	
	public void setTipo(boolean ssd){
		if(isSsd()){
			this.tipo="SSD";
		}else{
			this.tipo="HDD";
		}
	}
	
	public String getTipo() {
		return tipo;
	}
	public Almacenamiento() {
		
	}
	
	public Almacenamiento(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, int capacidad, boolean ssd) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.capacidad = capacidad;
		this.ssd = ssd;
		this.setTipo(ssd);
	}
	
	@Override
	public String toString() {
		return super.toString()+ " capacidad= " + capacidad + " ssd= " + ssd;
	}
	
}
