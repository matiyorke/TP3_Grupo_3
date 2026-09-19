package dao;

import java.sql.Statement;

import entidad.Producto;

import java.sql.Connection;
import java.sql.DriverManager;

public class DaoProducto {
	
	private String host = "jdbc:mysql://localhost:3306/";
	private String user = "root";
	private String pass = "root";
	private String dbName = "dbinventario";
	
	public DaoProducto() {
		
	}

//se HACE CON EL SP 
	
	public int bajaProducto(String codigo) {
		String query = "delete from productos where Codigo='"+codigo+"'";
		
		Connection cn = null;
		int filas = 0;
		
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	public int modificarProducto(Producto producto) {
		String query = "update productos set Nombre='"+producto.getNombre()+"', Precio='"+producto.getPrecio()+"', Stock='"+producto.getStock()+"', IdCategoria='"+producto.getIdCategoria()+"' where Codigo='"+producto.getCodigo()+"'";
		
		Connection cn = null;
		int filas = 0;
		
		try 
		{
			cn = DriverManager.getConnection(host+dbName,user,pass);
			Statement st = cn.createStatement();
			filas = st.executeUpdate(query);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return filas;
	}
	
}
