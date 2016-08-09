package model.products;

public class Producto {
	
	private int id_producto;
	private String marca;
	private final String [] tipoCategoria = {"Procesador","Memoria","Almacenamiento","Motherboard","Fuente","Gabinete","Periferico"};
	private int categoria;
	private String descripcion;
	private String img_producto;
	private float precio;
	private int stock_min;
	private int stock_act;
	
	public int getCategoria() {
		return categoria;
	}
	public void setCategoria(int categoria) {
		this.categoria = categoria;
	}
	
	public String getTipoCategoria() {
		return tipoCategoria[this.categoria];
	}
	
	
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getImg_producto() {
		return img_producto;
	}
	public void setImg_producto(String img_producto) {
		this.img_producto = img_producto;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public int getStock_min() {
		return stock_min;
	}
	public void setStock_min(int stock_min) {
		this.stock_min = stock_min;
	}
	public int getStock_act() {
		return stock_act;
	}
	public void setStock_act(int stock_act) {
		this.stock_act = stock_act;
	}
	public int getId_producto() {
		return id_producto;
	}
	public void setId_Producto(int id_producto){
		this.id_producto=id_producto;
	}
	
	@Override
	public String toString() {
		return "id_producto= " + id_producto + " marca= " + marca + " categoria= " + this.getTipoCategoria() + " descripcion= " + descripcion + " precio= " + precio + " stock_min= " + stock_min + " stock_act= "
				+ stock_act;
	}
	
	public Producto(){
		
	}
	public Producto(int id_producto,String marca, int categoria, String descripcion, String img_producto, float precio,int stock_min, int stock_act) {
		
		this.id_producto = id_producto;
		this.marca = marca;
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.img_producto = img_producto;
		this.precio = precio;
		this.stock_min = stock_min;
		this.stock_act = stock_act;
	}
	
	
	
	
}
