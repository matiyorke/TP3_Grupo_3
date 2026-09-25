package main;

import java.util.ArrayList;

import dao.DaoCategoria;
import dao.DaoProducto;
import entidad.Categoria;
import entidad.Producto;

public class Principal {

	public static void main(String[] args) {

		DaoCategoria daoCategoria = new DaoCategoria();

		// ---- ALTA ----
		Categoria c1 = new Categoria(1, "Electrónica");
		Categoria c2 = new Categoria(2, "Alimentos");
		Categoria c3 = new Categoria(3, "Limpieza");

		daoCategoria.agregarCategoria(c1);
		daoCategoria.agregarCategoria(c2);
		daoCategoria.agregarCategoria(c3);

		// ---- LISTADO ----
		System.out.println("--- Categorias cargadas ---");
		ArrayList<Categoria> categorias = daoCategoria.obtenerTodasLasCategorias();
		for (Categoria c : categorias) {
			System.out.println(c);
		}

		// ---- MODIFICACION ----
		c1.setNombre("Electrodomesticos");
		daoCategoria.modificarCategoria(c1);
		System.out.println("--- Categoria 1 modificada ---");
		System.out.println(daoCategoria.obtenerCategoria(1));

		// ---- BAJA ----
		Categoria categoriaDescartable = new Categoria(4, "Descartable");
		daoCategoria.agregarCategoria(categoriaDescartable);
		daoCategoria.bajaCategoria(categoriaDescartable.getIdCategoria());
		System.out.println("--- Categorias despues de la baja ---");
		for (Categoria c : daoCategoria.obtenerTodasLasCategorias()) {
			System.out.println(c);
		}

		// ---- ALTA DE 10 PRODUCTOS POR PROCEDIMIENTO ALMACENADO ----
		DaoProducto daoProducto = new DaoProducto();

		Producto p1 = new Producto("P001", "Televisor 42\"", 350000.00, 5, 1);
		Producto p2 = new Producto("P002", "Notebook 15\"", 900000.00, 3, 1);
		Producto p3 = new Producto("P003", "Auriculares Bluetooth", 25000.00, 20, 1);
		Producto p4 = new Producto("P004", "Arroz 1kg", 1500.00, 100, 2);
		Producto p5 = new Producto("P005", "Fideos 500g", 900.00, 150, 2);
		Producto p6 = new Producto("P006", "Aceite 900ml", 3200.00, 80, 2);
		Producto p7 = new Producto("P007", "Detergente 750ml", 2100.00, 60, 3);
		Producto p8 = new Producto("P008", "Lavandina 1L", 1200.00, 90, 3);
		Producto p9 = new Producto("P009", "Esponja x3", 800.00, 200, 3);
		Producto p10 = new Producto("P010", "Jabon en polvo 3kg", 4500.00, 40, 3);

		daoProducto.ejecutarSPAgregarProducto(p1);
		daoProducto.ejecutarSPAgregarProducto(p2);
		daoProducto.ejecutarSPAgregarProducto(p3);
		daoProducto.ejecutarSPAgregarProducto(p4);
		daoProducto.ejecutarSPAgregarProducto(p5);
		daoProducto.ejecutarSPAgregarProducto(p6);
		daoProducto.ejecutarSPAgregarProducto(p7);
		daoProducto.ejecutarSPAgregarProducto(p8);
		daoProducto.ejecutarSPAgregarProducto(p9);
		daoProducto.ejecutarSPAgregarProducto(p10);

		System.out.println("--- Productos cargados ---");
		for (Producto p : daoProducto.obtenerTodosLosProductos()) {
			System.out.println(p);
		}

		// ---- MODIFICACION ----
		p1.setPrecio(320000.00);
		p1.setStock(8);
		daoProducto.modificarProducto(p1);
		System.out.println("--- Producto P001 modificado ---");
		System.out.println(daoProducto.ObtenerProducto("P001"));

		// ---- BAJA ----
		Producto productoDescartable = new Producto("P011", "Producto de prueba", 100.00, 1, 1);
		daoProducto.ejecutarSPAgregarProducto(productoDescartable);
		daoProducto.bajaProducto(productoDescartable.getCodigo());
		System.out.println("--- Productos despues de la baja ---");
		for (Producto p : daoProducto.obtenerTodosLosProductos()) {
			System.out.println(p);
		}

	}

}
