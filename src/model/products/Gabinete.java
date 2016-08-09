package model.products;

public class Gabinete extends Producto {
	
	private String dimension;

	public String getDimension() {
		return dimension;
	}
	public void setDimension(String dimension) {
		this.dimension = dimension;
	}
	
	public Gabinete() {
		
	}
	
	public Gabinete(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, String dimension) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.dimension = dimension;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " dimension= " + dimension;
	}
}
