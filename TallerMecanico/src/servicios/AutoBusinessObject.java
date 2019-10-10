package servicios;

import java.sql.SQLException;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;

public interface AutoBusinessObject {

	public Auto selectAuto(int patente) throws SQLException, NonExistingCarException;

	public void insertAuto(Auto auto) throws SQLException, ExistingCarException, NoIdObtainedException;

	public void updateAuto(Auto auto) throws SQLException, NonExistingCarException;

	public void deleteAuto(int patente) throws SQLException, NonExistingCarException;

}
