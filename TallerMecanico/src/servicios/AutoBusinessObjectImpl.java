package servicios;

import java.sql.SQLException;

import dao.AutoDAO;
import dao.AutoDAOImpl;
import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;

public class AutoBusinessObjectImpl implements AutoBusinessObject {

	private AutoDAO autoDAO = new AutoDAOImpl();

	@Override
	public Auto selectAuto(int patente) throws SQLException, NonExistingCarException {
		try {
			return autoDAO.selectAuto(patente);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException nonExistingCarException) {
			throw new NonExistingCarException();
		}
	}

	@Override
	public void insertAuto(Auto auto) throws SQLException, ExistingCarException, NoIdObtainedException {
		try {
			autoDAO.insertAuto(auto);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (ExistingCarException existingCarException) {
			throw new ExistingCarException();
		} catch (NoIdObtainedException noIdObtainedException) {
			throw new NoIdObtainedException();
		}
	}

	@Override
	public void updateAuto(Auto auto) throws SQLException, NonExistingCarException {
		try {
			autoDAO.updateAuto(auto);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException nonExistingCarException) {
			throw new NonExistingCarException();
		}
	}

	@Override
	public void deleteAuto(int patente) throws SQLException, NonExistingCarException {
		try {
			autoDAO.deleteAuto(patente);
		} catch (SQLException sqle) {
			throw new SQLException();
		} catch (NonExistingCarException nonExistingCarException) {
			throw new NonExistingCarException();
		}
	}
}