package model.products;

public class Procesador extends Producto {
	
	private int cant_nucleos;
	private int mem_cache;
	
	public int getCant_nucleos() {
		return cant_nucleos;
	}
	public void setCant_nucleos(int cant_nucleos) {
		this.cant_nucleos = cant_nucleos;
	}
	public int getMem_cache() {
		return mem_cache;
	}
	public void setMem_cache(int mem_cache) {
		this.mem_cache = mem_cache;
	}
	
	
	
	public Procesador() {
		
	}
	
	public Procesador(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, int cant_nucleos, int mem_cache) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.cant_nucleos = cant_nucleos;
		this.mem_cache = mem_cache;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " cant_nucleos= " + cant_nucleos + " mem_cache= " + mem_cache;
	}
	
	
}
