package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import handler.Handler;

public class ConsultaUsuariosPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConsultaUsuariosPanel(Handler handler) {
		initUI(handler);
	}

	private void initUI(Handler handler) {
		setLayout(new BorderLayout());
		UsuariosTableModel autosTableModel = new UsuariosTableModel(handler.selectAllUsuarios());
		JScrollPane scroll = new JScrollPane(new JTable(autosTableModel));
		add(scroll);
	}

}
