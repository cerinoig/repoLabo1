package servicios;

import java.util.List;

import dao.FacturaDAO;
import entidades.Factura;
import excepciones.CamposVaciosException;
import excepciones.FacturaExistenteException;
import excepciones.FacturaNoExistenteException;
import excepciones.NoIdObtainedException;
import excepciones.TallerMecanicoException;

public class FacturaBusinessObjectImpl implements FacturaBusinessObject {

	private FacturaDAO facturaDAO;

	@Override
	public void setDAO(FacturaDAO facturaDAO) {
		this.facturaDAO = facturaDAO;
	}

	@Override
	public Factura selectFactura(int idFactura)
			throws TallerMecanicoException, CamposVaciosException, FacturaNoExistenteException {
		if (!String.valueOf(idFactura).equals("")) {
			if (facturaDAO.selectFactura(idFactura) == null) {
				throw new FacturaNoExistenteException("La factura no existe con el codigo " + idFactura);
			} else {
				return facturaDAO.selectFactura(idFactura);
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void insertFactura(Factura factura)
			throws TallerMecanicoException, NoIdObtainedException, CamposVaciosException, FacturaExistenteException {
		if (validarFactura(factura)) {
			if (facturaDAO.selectFactura(factura.getIdFactura()) == null) {
				facturaDAO.insertFactura(factura);
			} else {
				throw new FacturaExistenteException("La factura que intenta cargar ya existe");
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void updateFactura(Factura factura) throws TallerMecanicoException, CamposVaciosException {
		if (validarFactura(factura)) {
			facturaDAO.updateFactura(factura);
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void deleteFactura(int idFactura)
			throws TallerMecanicoException, CamposVaciosException, FacturaNoExistenteException {
		if (!String.valueOf(idFactura).equals("")) {
			if (facturaDAO.selectFactura(idFactura) == null) {
				throw new FacturaNoExistenteException("La factura que intenta eliminar no existe");
			} else {
				facturaDAO.deleteFactura(idFactura);
			}
		} else {
			throw new CamposVaciosException("No puede haber espacios sin completar");
		}
	}

	@Override
	public void cobrarArreglo(Factura factura) throws TallerMecanicoException {
		facturaDAO.cobrarArreglo(factura);
	}

	@Override
	public List<Factura> selectAll() throws TallerMecanicoException {
		return facturaDAO.selectAll();
	}

	public boolean validarFactura(Factura factura) {
		if (!factura.getPatente().equals("") && !factura.getArreglo().equals("") && factura.getCostoAreglo() != 0) {
			return true;
		} else {
			return false;
		}
	}

}
