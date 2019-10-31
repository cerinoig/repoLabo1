package ui;

import javax.swing.JTextField;

import handler.Handler;

public class EliminarAutosPanel extends EliminarDatosPanel{
	
	public EliminarAutosPanel(Handler handler) {	
		super(handler, "Patente");
	}
	
	
	@Override
	public void eliminarDatos(Handler handler){
		
		handler.deleteAuto(((JTextField) datos1.getComponent(3)).getText().toString());
		
	}
	
	

}
