package servicesImplements;

//import java.util.ArrayList;
import java.util.List;

import model.products.Almacenamiento;
import model.products.Fuente;
import model.products.Gabinete;
import model.products.Memoria;
import model.products.Motherboard;
import model.products.Procesador;
import model.products.Producto;
import servicesInterfaces.CrudServiceInterface;
import daoImplements.ProductoDaoImpl;
import daoInterfaces.ProductoDao;

public class ServicesCrud implements CrudServiceInterface {

	// Busca y retorna un producto por ID
	@Override
	public Producto buscarProducto(Producto prod) throws Exception {
		
		ProductoDao proDao = new ProductoDaoImpl();
		
		if (this.existeProducto(prod)) {
			prod=proDao.buscarProductoById(prod);
			switch (prod.getCategoria()) {
			case 0:
				Procesador proce = ((ProductoDaoImpl) proDao).selectProcesador(prod);
				prod = proce;
				break;
			case 1:
				Memoria mem = ((ProductoDaoImpl) proDao).selectMemoria(prod);
				prod = mem;
				break;
			case 2:
				Almacenamiento disco = ((ProductoDaoImpl) proDao).selectDisco(prod);
				prod = disco;
				break;
			case 3:
				Motherboard mother = ((ProductoDaoImpl) proDao).selectMother(prod);
				prod = mother;
				break;
			case 4:
				Fuente fuente = ((ProductoDaoImpl) proDao).selectFuente(prod);
				prod = fuente;
				break;
			case 5:
				Gabinete gabo = ((ProductoDaoImpl) proDao).selectGabo(prod);
				prod = gabo;
				break;
			}
			return prod;
		} else
			return null;
	}

	// Busca y retorna una lista de productos por Marca o Categoria
	@Override
	public List<Producto> buscarProductos(Producto prod) throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		Integer cat = null;
		cat = new Integer(prod.getCategoria());
		if (prod.getCategoria() >= 0 && prod.getCategoria() <= 6) {

			return proDao.buscarProductoByCategoria(prod);
		}else{
			if (prod.getMarca() != null) {
				return proDao.buscarProductoByMarca(prod);
			}
		}	
		return null;
	}

	// Busca y retorna todos los productos
	@Override
	public List<Producto> listarProductos() throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		return proDao.listarTodo();
	}

	// Busca y retorna una lista con todos los productos en Stock
	@Override
	public List<Producto> listarConStock() throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		return proDao.buscarProductoByStock();
	}

	// Busca y retorna una lista con todos los productos con un Stock actual
	// menor al Stock minimo
	@Override
	public List<Producto> listarBajoStock() throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		return proDao.buscarProductoByLowStock();
	}

	// Elimina un producto
	@Override
	public boolean eliminarProducto(Producto prod) throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		if (this.existeProducto(prod)) {
			switch (prod.getCategoria()) {
			case 0:
				((ProductoDaoImpl) proDao).eliminarProcesador(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 1:
				((ProductoDaoImpl) proDao).eliminarMemoria(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 2:
				((ProductoDaoImpl) proDao).eliminarDisco(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 3:
				((ProductoDaoImpl) proDao).eliminarMemoria(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 4:
				((ProductoDaoImpl) proDao).eliminarFuente(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 5:
				((ProductoDaoImpl) proDao).eliminarGabo(prod);
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			case 6:
				((ProductoDaoImpl) proDao).eliminarTablaPrincipal(prod);
				break;
			
			}return true;
		}else{

			return false;
		}

	}
	
	//Modifica un producto
	@Override
	public boolean modificarProducto(Producto prod) throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		
		if(this.existeProducto(prod)){
			return ((ProductoDaoImpl) proDao).modificarProducto(prod);
		}else{
			return false;
		}
	}
	
	public boolean existeMarca(Producto prod)throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		if(proDao.existeMarca(prod)){
			return true;
		}else{
			return false;
		}
	}
	
	public int ultimoId()throws Exception{
		ProductoDao proDao = new ProductoDaoImpl();
		return proDao.maxId();
	}
	
	
	//Agrega un producto(Ver que al agregar la misma descp 2 veces se produce error)
	@Override
	public boolean agregarProducto(Producto prod) throws Exception {
		ProductoDao proDao = new ProductoDaoImpl();
		if (!this.existeProducto(prod)){
			switch (prod.getCategoria()){
			case 0: ((ProductoDaoImpl) proDao).cargarProcesador((Procesador) prod);break;
			case 1:	((ProductoDaoImpl) proDao).cargarMemoria((Memoria) prod);break;
			case 2: ((ProductoDaoImpl) proDao).cargarDisco((Almacenamiento) prod);break;
			case 3:	((ProductoDaoImpl) proDao).cargarMother((Motherboard) prod);break;
			case 4: ((ProductoDaoImpl) proDao).cargarFuente((Fuente) prod);break;
			case 5:	((ProductoDaoImpl) proDao).cargarGabinete((Gabinete) prod);break;
			case 6:	((ProductoDaoImpl) proDao).cargarPeriferico(prod);break;
		}
			return true;
		}else{
			return false;
		}
		
		
	}
	
	private boolean existeProducto(Producto prod) throws Exception{
		ProductoDao proDao = new ProductoDaoImpl();
		if(proDao.buscarProductoById(prod)!=null){
			return true;
		}else{
			return false;
		}
	}

	
	
	
}
