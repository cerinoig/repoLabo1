package dao;

import java.sql.SQLException;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;

public interface AutoDAO {

	public Auto selectAuto(String patente) throws SQLException, NonExistingCarException;

	public void insertAuto(Auto auto) throws SQLException, NoIdObtainedException, ExistingCarException;

	public void updateAuto(Auto auto) throws SQLException, NonExistingCarException;

	public void deleteAuto(String patente) throws SQLException, NonExistingCarException;

}
