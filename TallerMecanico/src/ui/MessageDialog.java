package ui;

import javax.swing.JOptionPane;

public class MessageDialog {

	private static String mensajeVentanaError = "Error";

	public static void usuarioExiste() {
		JOptionPane.showMessageDialog(null, "El usuario ya existe, por favor ingrese uno nuevo", mensajeVentanaError,
				JOptionPane.ERROR_MESSAGE);
	}

	public static void autoExiste() {
		JOptionPane.showMessageDialog(null, "El auto ya existe, por favor ingrese uno nuevo", mensajeVentanaError,
				JOptionPane.ERROR_MESSAGE);
	}

	public static void problemaGenerico() {
		JOptionPane.showMessageDialog(null, "Hubo un problema, disculpe las molestias lo estamos solucionando",
				mensajeVentanaError, JOptionPane.ERROR_MESSAGE);
	}

	public static void errorCarga() {
		JOptionPane.showMessageDialog(null, "Hubo un problema en la carga, disculpe las molestias ocasionadas",
				mensajeVentanaError, JOptionPane.ERROR_MESSAGE);
	}
	
	
	public static void usuarioNoExiste() {
		JOptionPane.showMessageDialog(null, "Hubo un problema en la carga, el usuario no existe",
				mensajeVentanaError, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void autoNoExiste() {
		JOptionPane.showMessageDialog(null, "Hubo un problema en la carga, el auto no existe",
				mensajeVentanaError, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void presupuestoNoExiste() {
		JOptionPane.showMessageDialog(null, "Hubo un problema en la carga, el presupuesto no existe",
				mensajeVentanaError, JOptionPane.ERROR_MESSAGE);
	}
	
	public static void datosCargados() {
		JOptionPane.showMessageDialog(null, "Se cargaron los datos correctamente ");
	}

	public static void datosModificados() {
		JOptionPane.showMessageDialog(null, "Se modificaron los datos correctamente");
	}
	
	public static void datosEliminados() {
		JOptionPane.showMessageDialog(null, "Se eliminaron los datos correctamente");
	}
	
	
}
