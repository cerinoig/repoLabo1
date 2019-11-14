package servicios;

import java.util.List;

import dao.AutoDAO;
import dao.AutoDAOImpl;
import entidades.Auto;
import excepciones.CamposVaciosException;
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
	public Auto selectAuto(String patente)
			throws TallerMecanicoException, NonExistingCarException, CamposVaciosException {
		if (!patente.equals("")) {
			return autoDAO.selectAuto(patente);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}

	}

	@Override
	public void insertAuto(Auto auto)
			throws TallerMecanicoException, ExistingCarException, NoIdObtainedException, CamposVaciosException {
		if (auto.getPatente() != null && auto.getMarca() != null && auto.getModelo() != null && auto.getColor() != null
				&& auto.getCantidadPuertas() != 0 && auto.getAño() != null && auto.getKilometraje() != 0) {
			autoDAO.insertAuto(auto);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException {
		autoDAO.updateAuto(auto);
	}

	@Override
	public void deleteAuto(String patente)
			throws TallerMecanicoException, NonExistingCarException, CamposVaciosException {
		if (!patente.equals("")) {
			autoDAO.deleteAuto(patente);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public List<Auto> selectAll() throws TallerMecanicoException {
		return autoDAO.selectAll();
	}
}