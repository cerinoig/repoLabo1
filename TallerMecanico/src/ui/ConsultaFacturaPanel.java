package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Factura;
import handler.Handler;

public class ConsultaFacturaPanel extends ConsultaPanel {

	private static final long serialVersionUID = 1L;
	FacturasTableModel facturasTableModel;

	public ConsultaFacturaPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initUI(Handler handler) {

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pagarFacturas(handler);
			}
		});

	}

	@Override
	public void initButtons() {
		confirmarBoton = new JButton("Pagar");
		cancelarBoton = new JButton("Cancelar");
	}

	@Override
	public JButton[] getBotones() {
		initButtons();
		JButton[] botones = { confirmarBoton, cancelarBoton };
		return botones;
	}

	@Override
	public JLabel getTituloPanel() {
		return new JLabel("FATURACION DEL DIA");
	}

	@Override
	public JScrollPane getBody(Handler handler) {
		initTableModel(handler);
		return new JScrollPane(new JTable(facturasTableModel));
	}

	@Override
	public void initTableModel(Handler handler) {
		facturasTableModel = new FacturasTableModel(handler.selectAllFacturas());
	}

	public void pagarFacturas(Handler handler) {
		int input = 99999;
		List<Factura> facturas = new ArrayList<>();
		BigDecimal total = new BigDecimal(0);

		for (int i = 0; i < facturasTableModel.getRowCount(); i++) {
			Boolean checked = Boolean.valueOf(facturasTableModel.getValueAt(i, 4).toString());
			if (checked) {
				facturas.add(new Factura(Integer.valueOf(facturasTableModel.getValueAt(i, 0).toString()),
						facturasTableModel.getValueAt(i, 1).toString(), facturasTableModel.getValueAt(i, 2).toString(),
						new BigDecimal(facturasTableModel.getValueAt(i, 3).toString()), checked));

				BigDecimal subtotal = new BigDecimal(facturasTableModel.getValueAt(i, 3).toString());
				total = total.add(subtotal);
			}
		}

		input = JOptionPane.showOptionDialog(null, "Esta por pagar $" + total.toString().replace(".", ","), "Cierre de caja",
				JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

		if (input == JOptionPane.OK_OPTION) {
			handler.cobrarArreglo(facturas);
			handler.mostrarExito("Listo! El pago se realizo con exito");
		}
	}

}
