package ui;

import javax.swing.JCheckBox;
import javax.swing.JTextField;

import handler.Handler;

public abstract class FacturaPanel extends MiPanel {

	private static final long serialVersionUID = 1L;
	
	
	protected JTextField idFacturaTextField;
	protected JTextField patenteTextField;
	protected JTextField arregloTextField;
	protected JCheckBox cobradoCheckBox;

	public FacturaPanel(Handler handler) {
		super(handler);
		
	}

}
