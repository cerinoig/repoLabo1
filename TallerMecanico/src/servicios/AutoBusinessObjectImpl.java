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
		if (auto.getPatente().equals("") && auto.getMarca().equals("") && auto.getModelo().equals("")
				&& auto.getColor().equals("") && auto.getCantidadPuertas() != 0 && auto.getAño().equals("")
				&& auto.getKilometraje() != 0) {
			if (autoDAO.existeAuto(auto.getPatente())) {
				throw new ExistingCarException("El auto que intenta dar de alta ya existe");
			} else {
				autoDAO.insertAuto(auto);
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void updateAuto(Auto auto) throws TallerMecanicoException, NonExistingCarException, CamposVaciosException {
		if (auto.getPatente().equals("") && auto.getMarca().equals("") && auto.getModelo().equals("")
				&& auto.getColor().equals("") && auto.getCantidadPuertas() != 0 && auto.getAño().equals("")
				&& auto.getKilometraje() != 0) {
			autoDAO.updateAuto(auto);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void deleteAuto(String patente)
			throws TallerMecanicoException, NonExistingCarException, CamposVaciosException {
		if (!patente.equals("")) {
			if (autoDAO.existeAuto(patente)) {
				autoDAO.deleteAuto(patente);
			} else {
				throw new NonExistingCarException("El auto que intenta modificar no existe");
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public List<Auto> selectAll() throws TallerMecanicoException {
		return autoDAO.selectAll();
	}
}