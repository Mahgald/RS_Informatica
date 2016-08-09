package daoImplements;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import conection.Conexion;
import daoInterfaces.ProductoDao;

import model.products.*;


public class ProductoDaoImpl extends Conexion implements ProductoDao {
	
	//CARGAR
/*	public boolean cargarProcesador(Procesador proc) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, proc.getMarca());
			st.setInt(2, proc.getCategoria());
			st.setString(3, proc.getDescripcion());
			st.setString(4, proc.getImg_producto());
			st.setFloat(5, proc.getPrecio());
			st.setInt(6, proc.getStock_min());
			st.setInt(7, proc.getStock_act());
			st.executeUpdate();
			
			String identi=proc.getDescripcion();
			String consultaProcesador = "INSERT INTO procesador (id_producto,cant_nucleos,mem_cache) values ((SELECT id_producto FROM productos WHERE descripcion = ?),?,?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, proc.getCant_nucleos());
			st.setInt(3, proc.getMem_cache());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}*/
	
	public boolean cargarProcesador(Procesador proc) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, proc.getMarca());
			st.setInt(2, proc.getCategoria());
			st.setString(3, proc.getDescripcion());
			st.setString(4, proc.getImg_producto());
			st.setFloat(5, proc.getPrecio());
			st.setInt(6, proc.getStock_min());
			st.setInt(7, proc.getStock_act());
			st.executeUpdate();
			
			String identi=proc.getDescripcion();
			int cate= proc.getCategoria();
			float pre=proc.getPrecio();
			String consultaProcesador = "INSERT INTO procesador (id_producto,cant_nucleos,mem_cache) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?,?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setInt(4, proc.getCant_nucleos());
			st.setInt(5, proc.getMem_cache());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	
	public boolean cargarMemoria(Memoria mem) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, mem.getMarca());
			st.setInt(2, mem.getCategoria());
			st.setString(3, mem.getDescripcion());
			st.setString(4, mem.getImg_producto());
			st.setFloat(5, mem.getPrecio());
			st.setInt(6, mem.getStock_min());
			st.setInt(7, mem.getStock_act());
			st.executeUpdate();
			
			String identi=mem.getDescripcion();
			int cate= mem.getCategoria();
			float pre=mem.getPrecio();
			String consultaProcesador = "INSERT INTO memoria (id_producto,velocidad,capacidad) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?,?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setInt(4, mem.getVelocidad());
			st.setInt(5, mem.getCapacidad());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	public boolean cargarDisco(Almacenamiento disco) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, disco.getMarca());
			st.setInt(2, disco.getCategoria());
			st.setString(3, disco.getDescripcion());
			st.setString(4, disco.getImg_producto());
			st.setFloat(5, disco.getPrecio());
			st.setInt(6, disco.getStock_min());
			st.setInt(7, disco.getStock_act());
			st.executeUpdate();
			
			String identi=disco.getDescripcion();
			int cate= disco.getCategoria();
			float pre=disco.getPrecio();
			String consultaProcesador = "INSERT INTO almacenamiento (id_producto,capacidad,hdd,ssd) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?,?,?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setInt(4, disco.getCapacidad());
			if(disco.isSsd()){
				st.setBoolean(4, !disco.isSsd());
				st.setBoolean(5, disco.isSsd());
				
			}else{
				st.setBoolean(4, !disco.isSsd());
				st.setBoolean(5, disco.isSsd());
			}
			
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	public boolean cargarMother(Motherboard mother) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, mother.getMarca());
			st.setInt(2, mother.getCategoria());
			st.setString(3, mother.getDescripcion());
			st.setString(4, mother.getImg_producto());
			st.setFloat(5, mother.getPrecio());
			st.setInt(6, mother.getStock_min());
			st.setInt(7, mother.getStock_act());
			st.executeUpdate();
			
			String identi=mother.getDescripcion();
			int cate= mother.getCategoria();
			float pre=mother.getPrecio();

			
			String consultaProcesador = "INSERT INTO motherboard (id_producto,socket) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setString(4, mother.getSocket());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	public boolean cargarFuente(Fuente fuente) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, fuente.getMarca());
			st.setInt(2, fuente.getCategoria());
			st.setString(3, fuente.getDescripcion());
			st.setString(4, fuente.getImg_producto());
			st.setFloat(5, fuente.getPrecio());
			st.setInt(6, fuente.getStock_min());
			st.setInt(7, fuente.getStock_act());
			st.executeUpdate();
			
			String identi=fuente.getDescripcion();
			int cate= fuente.getCategoria();
			float pre=fuente.getPrecio();

			
			String consultaProcesador = "INSERT INTO fuente (id_producto,potencia,certificacion) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?,?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);
			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setInt(4, fuente.getPotencia());
			st.setString(5, fuente.getCertificacion());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	public boolean cargarGabinete(Gabinete gabo) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, gabo.getMarca());
			st.setInt(2, gabo.getCategoria());
			st.setString(3, gabo.getDescripcion());
			st.setString(4, gabo.getImg_producto());
			st.setFloat(5, gabo.getPrecio());
			st.setInt(6, gabo.getStock_min());
			st.setInt(7, gabo.getStock_act());
			st.executeUpdate();
			
			String identi=gabo.getDescripcion();
			int cate= gabo.getCategoria();
			float pre=gabo.getPrecio();
				
			String consultaProcesador = "INSERT INTO gabinete (id_producto,dimensiones) values ((SELECT id_producto FROM productos WHERE descripcion = ? and categoria = ? and precio = ?),?)";
					
			st = this.conexion.prepareStatement(consultaProcesador);
			
			st.setString(1, identi);

			st.setInt(2, cate);
			st.setFloat(3, pre);
			st.setString(4, gabo.getDimension());
			st.executeUpdate();
			
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	public boolean cargarPeriferico(Producto peri) throws Exception{
		try {
			this.conectar();
			String consultaProducto = "INSERT INTO productos (marca,categoria,descripcion,img_producto,precio,stock_min,stock_act)values(?,?,?,?,?,?,?)";
			PreparedStatement st = this.conexion.prepareStatement(consultaProducto);
			st.setString(1, peri.getMarca());
			st.setInt(2, peri.getCategoria());
			st.setString(3, peri.getDescripcion());
			st.setString(4, peri.getImg_producto());
			st.setFloat(5, peri.getPrecio());
			st.setInt(6, peri.getStock_min());
			st.setInt(7, peri.getStock_act());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return false;
	}
	
	//BUSCAR
	public Procesador selectProcesador(Producto prod)throws Exception{
		Procesador pro= new Procesador();
		try {
			this.conectar();
			String consulta= "SELECT * FROM procesador WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			pro = new Procesador(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getInt("cant_nucleos"),rs.getInt("mem_cache"));
		} catch (Exception e) {
			throw e;
		}
		return pro;
	}
	public Memoria selectMemoria(Producto prod) throws Exception {
		Memoria memoria= new Memoria();
		try {
			this.conectar();
			String consulta= "SELECT * FROM memoria WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			memoria = new Memoria(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getInt("capacidad"),rs.getInt("velocidad"));
		} catch (Exception e) {
			throw e;
		}
		return memoria;
	}
	public Almacenamiento selectDisco(Producto prod) throws Exception{
		Almacenamiento disco= new Almacenamiento();
		try {
			this.conectar();
			String consulta= "SELECT * FROM almacenamiento WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			disco = new Almacenamiento(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getInt("capacidad"),rs.getBoolean("ssd"));
		} catch (Exception e) {
			throw e;
		}
		return disco;
	}
	public Motherboard selectMother(Producto prod) throws Exception{
		Motherboard mother= new Motherboard();
		try {
			this.conectar();
			String consulta= "SELECT * FROM motherboard WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			mother = new Motherboard(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getString("socket"));
		} catch (Exception e) {
			throw e;
		}
		return mother;
	}
	public Fuente selectFuente(Producto prod) throws Exception{
		Fuente fuente= new Fuente();
		try {
			this.conectar();
			String consulta= "SELECT * FROM fuente WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			fuente = new Fuente(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getInt("potencia"),rs.getString("certificacion"));
		} catch (Exception e) {
			throw e;
		}
		return fuente;
	}
	public Gabinete selectGabo(Producto prod) throws Exception{
		Gabinete gabo= new Gabinete();
		try {
			this.conectar();
			String consulta= "SELECT * FROM gabinete WHERE id_producto=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			rs.next();
			gabo = new Gabinete(prod.getId_producto(),prod.getMarca(),prod.getCategoria(),prod.getDescripcion(),prod.getImg_producto(),prod.getPrecio(),prod.getStock_min(),prod.getStock_act(),rs.getString("dimensiones"));
		} catch (Exception e) {
			throw e;
		}
		return gabo;
	}
	
	@Override
	public Producto buscarProductoById(Producto prod) throws Exception {
		try {
			this.conectar();
			//Producto p = new Producto();
			String consulta = "CALL selectProducto(?)";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			ResultSet rs = st.executeQuery();
			if(rs.next()){
				prod = new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
				return prod;
			}
			//prod = new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return null;
	}
	
	//ELIMINAR
	public void eliminarProcesador(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM procesador WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarMemoria(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM memoria WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarFuente(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM fuente WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarDisco(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM almacenamiento WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarMotherboard(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM motherboard WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarGabo(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "DELETE FROM gabinete WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	public void eliminarTablaPrincipal(Producto prod) throws Exception{
		try {
			this.conectar();
			String consulta = "DELETE FROM productos WHERE id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		}
	}
	
	// MODIFICAR
	@Override
	public void modificarProductoMarca(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set marca = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, prod.getMarca());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoCategoria(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set categoria = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getCategoria());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoDescripcion(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set descripcion = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, prod.getDescripcion());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoImgUrl(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set img_producto = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, prod.getImg_producto());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoPrecio(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set precio = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setFloat(1, prod.getPrecio());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoStockMin(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set stock_min = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getStock_min());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	@Override
	public void modificarProductoStockAct(Producto prod) throws Exception {
		try {
			this.conectar();
			String consulta = "UPDATE productos set stock_act = ? where id_producto = ?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getStock_act());
			st.setInt(2, prod.getId_producto());
			st.executeUpdate();
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
	}
	
	public boolean modificarProducto(Producto prod)throws Exception{
		try {
			if(this.buscarProductoById(prod)!=null){
				this.modificarProductoCategoria(prod);
				this.modificarProductoDescripcion(prod);
				this.modificarProductoImgUrl(prod);
				this.modificarProductoMarca(prod);
				this.modificarProductoPrecio(prod);
				this.modificarProductoStockAct(prod);
				this.modificarProductoStockMin(prod);
				
				return true;
			}else{
				return true;
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
	}
	//LISTAR
		
	@Override
	public List<Producto> buscarProductoByMarca(Producto prod) throws Exception {
		List<Producto> productos = null;

		try {
			this.conectar();
			String consulta = "CALL selectProductoByMarca(?)";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, prod.getMarca());
			productos = new ArrayList<Producto>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto p=new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
				if(p.getMarca()!=null){
					switch (p.getCategoria()) {
						case 0:
							Procesador pro= this.selectProcesador(p);
							productos.add(pro);	
							break;
						case 1:
							Memoria mem= this.selectMemoria(p);
							productos.add(mem);
							break;
						case 2: 
							Almacenamiento disco=this.selectDisco(p);
							productos.add(disco);
							break;
						case 3:	
							Motherboard mother= this.selectMother(p);
							productos.add(mother);
							
							break;
						case 4: 
							Fuente fuente= this.selectFuente(p);
							productos.add(fuente);
							break;
						case 5:	
							Gabinete gabo= this.selectGabo(p);
							productos.add(gabo);
							break;
						case 6:	
							productos.add(p);
							break;
					}
					
						
					}else{
						productos=null;
					}
					
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

		return productos;

	}

	@Override
	public List<Producto> buscarProductoByCategoria(Producto prod) throws Exception {
		List<Producto> productos = null;

		try {
			this.conectar();
			String consulta = "CALL selectProductoByCategoria(?)";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setInt(1, prod.getCategoria());
			productos = new ArrayList<Producto>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto p=new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
				switch (p.getCategoria()) {
				case 0:
					Procesador pro= this.selectProcesador(p);
					productos.add(pro);	
				break;
				case 1:
					Memoria mem= this.selectMemoria(p);
					productos.add(mem);
				break;
				case 2: 
					Almacenamiento disco=this.selectDisco(p);
					productos.add(disco);
				break;
				case 3:	
					Motherboard mother= this.selectMother(p);
					productos.add(mother);
					
				break;
				case 4: 
					Fuente fuente= this.selectFuente(p);
					productos.add(fuente);
				break;
				case 5:	
					Gabinete gabo= this.selectGabo(p);
					productos.add(gabo);
				break;
				case 6:	
					productos.add(p);
				break;
			}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}

		return productos;
	}

	@Override
	public List<Producto> buscarProductoByStock() throws Exception {
		List<Producto> productos = null;

		try {
			this.conectar();
			String consulta = "CALL selectProductoByStock()";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			productos = new ArrayList<Producto>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto prod=new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
				
				switch (prod.getCategoria()) {
					case 0:
						Procesador pro= this.selectProcesador(prod);
						productos.add(pro);	
					break;
					case 1:
						Memoria mem= this.selectMemoria(prod);
						productos.add(mem);
					break;
					case 2: 
						Almacenamiento disco=this.selectDisco(prod);
						productos.add(disco);
					break;
					case 3:	
						Motherboard mother= this.selectMother(prod);
						productos.add(mother);
						
					break;
					case 4: 
						Fuente fuente= this.selectFuente(prod);
						productos.add(fuente);
					break;
					case 5:	
						Gabinete gabo= this.selectGabo(prod);
						productos.add(gabo);
					break;
					case 6:	
						productos.add(prod);
					break;
				}
				}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return productos;
	}

	@Override
	public List<Producto> buscarProductoByLowStock() throws Exception {
		List<Producto> productos = null;

		try {
			this.conectar();
			String consulta = "CALL selectProductoByLowStock()";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			productos = new ArrayList<Producto>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto prod=new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
				
				switch (prod.getCategoria()) {
					case 0:
						Procesador pro= this.selectProcesador(prod);
						productos.add(pro);	
					break;
					case 1:
						Memoria mem= this.selectMemoria(prod);
						productos.add(mem);
					break;
					case 2: 
						Almacenamiento disco=this.selectDisco(prod);
						productos.add(disco);
					break;
					case 3:	
						Motherboard mother= this.selectMother(prod);
						productos.add(mother);
						
					break;
					case 4: 
						Fuente fuente= this.selectFuente(prod);
						productos.add(fuente);
					break;
					case 5:	
						Gabinete gabo= this.selectGabo(prod);
						productos.add(gabo);
					break;
					case 6:	
						productos.add(prod);
					break;
				}
				}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return productos;
	}

	
	public List<Producto> listarTodo() throws Exception {
		List<Producto> productos = null;
		try {
			this.conectar();
			String consulta = "CALL selectProductos";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			productos = new ArrayList<Producto>();
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Producto prod=new Producto(rs.getInt("id_producto"),rs.getString("marca"),rs.getInt("categoria"),rs.getString("descripcion"),rs.getString("img_producto"),rs.getFloat("precio"),rs.getInt("stock_min"),rs.getInt("stock_act"));
					
				switch (prod.getCategoria()) {
					case 0:
						Procesador pro= this.selectProcesador(prod);
						productos.add(pro);	
					break;
					case 1:
						Memoria mem= this.selectMemoria(prod);
						productos.add(mem);
					break;
					case 2: 
						Almacenamiento disco=this.selectDisco(prod);
						productos.add(disco);
					break;
					case 3:	
						Motherboard mother= this.selectMother(prod);
						productos.add(mother);
						
					break;
					case 4: 
						Fuente fuente= this.selectFuente(prod);
						productos.add(fuente);
					break;
					case 5:	
						Gabinete gabo= this.selectGabo(prod);
						productos.add(gabo);
					break;
					case 6:	
						productos.add(prod);
					break;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		return productos;
	}
		
	
	public boolean existeMarca(Producto prod) throws Exception{
		try {
			this.conectar();
			String consulta= "SELECT * FROM productos WHERE marca=?";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			st.setString(1, prod.getMarca());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				if(rs.getString("marca")!=null){
					return true;
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		return false;
	}
	
	public int maxId() throws Exception{
		try {
			this.conectar();
			String consulta= "SELECT MAX(id_producto) AS id_producto FROM productos";
			PreparedStatement st = this.conexion.prepareStatement(consulta);
			ResultSet rs = st.executeQuery();
			rs.next();
			return rs.getInt("id_producto");	
		} catch (Exception e) {
			throw e;
		} finally {
			this.cerrar();
		}
		
		
	}
	
	
	//Venta - Control Stock
	@Override
	public boolean ventaProducto(Producto prod) throws Exception {
		if(this.hayStock(prod)){
			Producto p = this.buscarProductoById(prod);
			int mod=p.getStock_act();
			--mod ;
			p.setStock_act(mod);
			this.modificarProductoStockAct(p);
			return true;
		
		}else{	
			return false;
		}	
	}

	@Override
	public boolean hayStock(Producto prod) throws Exception {
		Producto p= this.buscarProductoById(prod);
		if(p.getStock_act()>0){
			return true;
		}else{
			return false;
		}
	}

	

}
