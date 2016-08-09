package servicesInterfaces;

import java.util.List;
import model.products.Producto;

public interface CrudServiceInterface {
	
	//Agrega un producto(Ver que al agregar la misma descp 2 veces se produce error)
	public boolean agregarProducto(Producto prod) throws Exception;
		
	
	//Modifica un producto
	public boolean modificarProducto(Producto prod)throws Exception;
		
	
	// Elimina un producto
	public boolean eliminarProducto(Producto prod)throws Exception;
	
	
	// Busca y retorna un producto por ID
	public Producto buscarProducto(Producto prod)throws Exception;
	
	
	// Busca y retorna una lista de productos por Marca o Categoria
	public List<Producto> buscarProductos(Producto prod)throws Exception;
	
	
	// Busca y retorna todos los productos
	public List<Producto> listarProductos()throws Exception;
	
	
	// Busca y retorna una lista con todos los productos en Stock
	public List<Producto> listarConStock() throws Exception;
	
	
	// Busca y retorna una lista con todos los productos con un Stock actual menor al Stock minimo
	public List<Producto> listarBajoStock() throws Exception;
}
