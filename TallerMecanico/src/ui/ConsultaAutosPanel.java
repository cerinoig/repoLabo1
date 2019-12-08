package ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import handler.Handler;

public class ConsultaAutosPanel extends ConsultaPanel {

	private static final long serialVersionUID = 1L;
	AutosTableModel autosTableModel;

	public ConsultaAutosPanel(Handler handler) {
		super(handler);
	}

	public void initUI(Handler handler) {
		
	}

	@Override
	public JLabel getTituloPanel() {

		return new JLabel("LISTADO DE AUTOS");
	}

	@Override
	public JScrollPane getBody(Handler handler) {
		initTableModel(handler);
		return new JScrollPane(new JTable(autosTableModel));
	}

	@Override
	public void initTableModel(Handler handler) {
		autosTableModel = new AutosTableModel(handler.selectAllAutos());
	}


}
