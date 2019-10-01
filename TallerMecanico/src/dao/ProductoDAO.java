package dao;

import java.sql.SQLException;

import entidades.Producto;
import excepciones.ExistingProductException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingProductException;

public interface ProductoDAO {

	public Producto selectProducto(int codigoProducto) throws SQLException, NonExistingProductException;

	public void insertProducto(Producto producto) throws SQLException, NoIdObtainedException, ExistingProductException;

	public void updateProducto(Producto producto) throws SQLException, NonExistingProductException;

	public void deleteProducto(int codigoProducto) throws SQLException, NonExistingProductException;

}