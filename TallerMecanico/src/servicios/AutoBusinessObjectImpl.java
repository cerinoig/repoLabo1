package servicios;

import dao.AutoDAO;
import dao.AutoDAOImpl;
import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;
import excepciones.TallerMecanicoException;

public class AutoBusinessObjectImpl implements AutoBusinessObject {

	private AutoDAO autoDAO = new AutoDAOImpl();

	@Override
	public void setDAO(AutoDAO autoDAO) {
		this.autoDAO = autoDAO;
	}

	@Override
	public Auto selectAuto(String patente) throws TallerMecanicoException, NonExistingCarException {
		return autoDAO.selectAuto(patente);
	}

	@Override
	public void insertAuto(Auto auto) throws TallerMecanicoException, ExistingCarException, NoIdObtainedException {
		autoDAO.insertAuto(auto);
	}

	@Override
	public void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException {
		autoDAO.updateAuto(auto);
	}

	@Override
	public void deleteAuto(String patente) throws TallerMecanicoException, NonExistingCarException {
		autoDAO.deleteAuto(patente);
	}
}