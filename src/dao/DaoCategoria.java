package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import entidad.Categoria;

public class DaoCategoria {

	 private String host = "jdbc:mysql://localhost:3306/";
	 private String user = "root";
	 private String pass = "root";
	 private String dbName = "bdinventario";
	 
	 public DaoCategoria() {
		 
	 }
	 
	 public int agregarCategoria(Categoria categoria) {
		 String query = "Insert into categorias(IdCategoria,Nombre) values('"+ categoria.getIdCategoria() +"','"+ categoria.getNombre()+"')";
		 
		 Connection cn = null; //objeto de tipo Connection
		 
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
	 
	 public int bajaCategoria(int idCategoria) {
			String query = "delete from categorias where IdCategoria='"+idCategoria+"'";
			
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
	 public int modificarCategoria(Categoria categoria) {
			String query = "update categorias set Nombre='"+categoria.getNombre()+"' where IdCategoria='"+categoria.getIdCategoria()+"'";
			
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
	 
	 public Categoria obtenerCategoria(int id) {
		 Categoria x = new Categoria();
		 
		 Connection cn = null;
		 
		 try 
		 {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 Statement st = cn.createStatement();
			 String query = "Select * from Categorias where IdCategoria="+id;
			 ResultSet rs = st.executeQuery(query);
			 rs.next();
			 x.setNombre(rs.getString("Nombre"));
			 x.setIdCategoria(rs.getInt("IdCategoria"));
		 }
		 catch (Exception e) 
		 {
				e.printStackTrace();
		 }
		 
		 return x;
	 }
	 
	 public ArrayList<Categoria> obtenerTodasLasCategorias() 
	 {
		 ArrayList<Categoria> lCategoria = new ArrayList<Categoria>();
		 
		 Connection cn = null;
		 
		 try 
		 {
			 cn = DriverManager.getConnection(host+dbName,user,pass);
			 String query = "Select * from Categorias";
			 Statement st = cn.createStatement();
			 ResultSet rs = st.executeQuery(query);
			 while(rs.next()) 
			 {
				Categoria x = new Categoria();
				x.setIdCategoria(rs.getInt("IdCategoria"));
				x.setNombre(rs.getString("Nombre"));
				lCategoria.add(x);
			 }
			 
		 }
		 catch (Exception e) 
		 {
				e.printStackTrace();
		 }
		 
		 return lCategoria;
	 }
}
