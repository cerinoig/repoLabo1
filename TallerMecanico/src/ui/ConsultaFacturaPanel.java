package ui;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import handler.Handler;

public class ConsultaFacturaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	public ConsultaFacturaPanel(Handler handler) {
		initUI(handler);
	}

	private void initUI(Handler handler) {
		setLayout(new BorderLayout());
		FacturasTableModel facturasTableModel = new FacturasTableModel(handler.selectAllFacturas());
		JScrollPane scroll = new JScrollPane(new JTable(facturasTableModel));
		add(scroll);
	}
}
