package dao;

import java.sql.SQLException;

import entidades.Auto;
import excepciones.ExistingCarException;
import excepciones.NoIdObtainedException;
import excepciones.NonExistingCarException;

public interface AutoDAO {

	public Auto selectAuto(int patente) throws SQLException, NonExistingCarException;

	public void insertAuto(Auto auto) throws SQLException, NoIdObtainedException, ExistingCarException;

	public void updateAuto(Auto auto) throws SQLException, NonExistingCarException;

	public void deleteAuto(int patente) throws SQLException, NonExistingCarException;

}