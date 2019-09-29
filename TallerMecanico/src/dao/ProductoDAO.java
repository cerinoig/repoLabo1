package dao;

import java.sql.SQLException;

import entidades.Producto;
import excepciones.NoIdObtainedException;

public interface ProductoDAO {

	public Producto selectProducto(int codigoProducto) throws SQLException;

	public void insertProducto(Producto producto) throws SQLException, NoIdObtainedException;

	public void updateProducto(Producto producto) throws SQLException;

	public void deleteProducto(int codigoProducto) throws SQLException;
	
	public boolean buscarProducto(int codigoProducto) throws SQLException;

}