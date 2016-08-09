package daoInterfaces;

import model.products.Almacenamiento;
import model.products.Fuente;
import model.products.Gabinete;
import model.products.Memoria;
import model.products.Motherboard;
import model.products.Procesador;
import model.products.Producto;
import java.util.List;


public interface ProductoDao {
	
	//public void cargarProducto (Producto prod) throws Exception;
	//public void eliminarProducto (Producto prod) throws Exception;
	
	public boolean cargarProcesador(Procesador proc) throws Exception;
	public boolean cargarMemoria(Memoria mem) throws Exception;
	public boolean cargarDisco(Almacenamiento disco) throws Exception;
	public boolean cargarMother(Motherboard mother) throws Exception;
	public boolean cargarFuente(Fuente fuente) throws Exception;
	public boolean cargarGabinete(Gabinete gabo) throws Exception;
	public boolean cargarPeriferico(Producto peri) throws Exception;
	
	
	public void modificarProductoMarca (Producto prod) throws Exception;
	public void modificarProductoCategoria (Producto prod) throws Exception; 
	public void modificarProductoDescripcion (Producto prod) throws Exception;
	public void modificarProductoImgUrl (Producto prod) throws Exception;
	public void modificarProductoPrecio (Producto prod) throws Exception;
	public void modificarProductoStockMin (Producto prod) throws Exception;
	public void modificarProductoStockAct (Producto prod) throws Exception;
	
	
	public void eliminarProcesador(Producto prod) throws Exception;
	public void eliminarMemoria(Producto prod) throws Exception;
	public void eliminarFuente(Producto prod) throws Exception;
	public void eliminarDisco(Producto prod) throws Exception; 
	public void eliminarMotherboard(Producto prod) throws Exception;
	public void eliminarGabo(Producto prod) throws Exception;
	public void eliminarTablaPrincipal(Producto prod) throws Exception;
	
	
	public Procesador selectProcesador(Producto prod)throws Exception;
	public Memoria selectMemoria(Producto prod) throws Exception;
	public Almacenamiento selectDisco(Producto prod) throws Exception;
	public Motherboard selectMother(Producto prod) throws Exception;
	public Fuente selectFuente(Producto prod) throws Exception;
	public Gabinete selectGabo(Producto prod) throws Exception;
	
	public Producto buscarProductoById(Producto prod) throws Exception;
	
	public List<Producto> buscarProductoByMarca (Producto prod) throws Exception;
	public List<Producto> buscarProductoByCategoria (Producto prod) throws Exception;
	public List<Producto> buscarProductoByStock () throws Exception;
	public List<Producto> buscarProductoByLowStock () throws Exception;
	
	public List<Producto> listarTodo () throws Exception;
	
	//public Producto buscarTodosProductos(Producto prod) throws Exception;
	
	public boolean existeMarca(Producto prod) throws Exception;
	
	public boolean ventaProducto(Producto prod) throws Exception;
	public boolean hayStock(Producto prod) throws Exception;
	public int maxId()throws Exception;
	
	
}
