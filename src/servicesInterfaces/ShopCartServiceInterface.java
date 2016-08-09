package servicesInterfaces;
import model.products.Producto;

public interface ShopCartServiceInterface {
	
	public String procesadores  () throws Exception;
	
	public String memorias_ram  () throws Exception;
	
	public String motherboards  () throws Exception;
	
	public String discos  () throws Exception;
	
	public String fuentes  () throws Exception;
	
	public String perifericos  () throws Exception;
	
	public String gabinetes  () throws Exception;
	
	public Producto getProducto(int id)throws Exception;
}
