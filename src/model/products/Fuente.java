package model.products;

public class Fuente extends Producto {
	private int potencia;
	private String certificacion;
	
	public int getPotencia() {
		return potencia;
	}
	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	public String getCertificacion() {
		return certificacion;
	}
	public void setCertificacion(String certificacion) {
		this.certificacion = certificacion;
	}

	public Fuente() {
		
	}
	
	public Fuente(int id_producto, String marca, int categoria, String descripcion, String img_producto,float precio, int stock_min, int stock_act, int potencia, String certificacion) {
		super(id_producto, marca, categoria, descripcion, img_producto, precio, stock_min, stock_act);
		this.potencia = potencia;
		this.certificacion = certificacion;
	}
	
	@Override
	public String toString() {
		return super.toString()+ " potencia= " + potencia + " certificacion= " + certificacion;
	}
}