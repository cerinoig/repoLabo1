package main;

import java.sql.SQLException;

import excepciones.NonExistingUserException;
import servicios.UsuarioBusinessObject;
import servicios.UsuarioBusinessObjectImpl;
import ui.MiFrame;
import utils.Dentre;

public class Main {

	private static UsuarioBusinessObject usuarioBusinessObject = new UsuarioBusinessObjectImpl();

	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new MiFrame().setVisible(true);
			}
		});
	}

	public static void deleteUsuario() {
		try {
			System.out.println("---------------");
			System.out.println("BAJA DE USUARIO	");
			System.out.println("---------------");
			usuarioBusinessObject.deleteUsuario(Dentre.texto("Ingrese el usuario que desea eliminar"));

			System.out.println("El usuario fue eliminado con exito");
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} catch (NonExistingUserException e) {
			System.out.println("El usuario que desea eliminar no existe");
		}
	}
}
