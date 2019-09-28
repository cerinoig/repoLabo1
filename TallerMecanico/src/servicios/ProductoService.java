package servicios;

import java.sql.SQLException;

import entidades.Producto;
import excepciones.ExistingUserException;
import excepciones.NonExistingUserException;

public interface ProductoService {

	public Producto selectProducto(int codigoProducto) throws SQLException, NonExistingUserException;

	public void insertProducto(Producto producto) throws SQLException, ExistingUserException;

	public void updateProducto(Producto producto) throws SQLException, NonExistingUserException;

	public void deleteProducto(int codigoProducto) throws SQLException, NonExistingUserException;

}