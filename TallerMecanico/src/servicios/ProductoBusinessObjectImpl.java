package servicios;

import java.sql.SQLException;

import dao.ProductoDAO;
import dao.ProductoDAOImpl;
import entidades.Producto;
import excepciones.ExistingProductException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingProductException;

public class ProductoBusinessObjectImpl implements ProductoBusinessObject {

	private ProductoDAO productoDAO = new ProductoDAOImpl();

	@Override
	public Producto selectProducto(int codigoProducto) throws SQLException, NonExistingProductException {
		try {
			return productoDAO.selectProducto(codigoProducto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingProductException nonExistingUserException) {
			throw new NonExistingProductException();
		}

		return null;
	}

	@Override
	public void insertProducto(Producto producto) throws SQLException, ExistingProductException, NoIdObtainedException {
		try {
			productoDAO.insertProducto(producto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (ExistingProductException existingUserException) {
			throw new ExistingProductException();
		} catch (NoIdObtainedException noIdObtainedException) {
			throw new NoIdObtainedException();
		}
	}

	@Override
	public void updateProducto(Producto producto) throws SQLException, NonExistingProductException {
		try {
			productoDAO.updateProducto(producto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingProductException nonExistingUserException) {
			throw new NonExistingProductException();
		}
	}

	@Override
	public void deleteProducto(int codigoProducto) throws SQLException, NonExistingProductException {
		try {
			productoDAO.deleteProducto(codigoProducto);
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingProductException nonExistingUserException) {
			throw new NonExistingProductException();
		}
	}
}
