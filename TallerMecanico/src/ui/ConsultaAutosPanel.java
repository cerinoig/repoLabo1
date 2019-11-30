package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import handler.Handler;

public class ConsultaAutosPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConsultaAutosPanel(Handler handler) {
		initUI(handler);
	}

	private void initUI(Handler handler) {
		setLayout(new BorderLayout());
		AutosTableModel autosTableModel = new AutosTableModel(handler.selectAllAutos());
		JScrollPane scroll = new JScrollPane(new JTable(autosTableModel));
		add(scroll);
	}

}
