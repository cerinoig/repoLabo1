package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import entidades.Factura;
import handler.Handler;

public class ConsultaFacturaPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JButton confirmarBoton = new JButton("Pagar");
	private JButton cancelarBoton = new JButton("Cancelar");

	public ConsultaFacturaPanel(Handler handler) {
		initUI(handler);
	}

	private void initUI(Handler handler) {
		setLayout(new BorderLayout());

		FacturasTableModel facturasTableModel = new FacturasTableModel(handler.selectAllFacturas());
		JScrollPane scroll = new JScrollPane(new JTable(facturasTableModel));

		JButton[] botones = { confirmarBoton, cancelarBoton };

		add(new JLabel("CONSULTA DE FACTURAS"), BorderLayout.NORTH);
		add(scroll, BorderLayout.CENTER);
		add(crearBotonera(botones), BorderLayout.SOUTH);

		confirmarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Factura> facturas = new ArrayList<>();
				Double total = 0.00;				
				for (int i = 0; i < facturasTableModel.getRowCount(); i++) {
					Boolean checked = Boolean.valueOf(facturasTableModel.getValueAt(i, 4).toString());
					if (checked) {
						facturas.add(new Factura(Integer.valueOf(facturasTableModel.getValueAt(i, 0).toString()), 
								facturasTableModel.getValueAt(i, 1).toString(), 
								facturasTableModel.getValueAt(i, 2).toString(), 
								Double.parseDouble(facturasTableModel.getValueAt(i, 3).toString()), checked));
						Double subtotal = Double.parseDouble(facturasTableModel.getValueAt(i, 3).toString());
						total = total + subtotal;
					}
				}
				int input = JOptionPane.showOptionDialog(null, "Esta por pagar $" + total, "Cierre de caja",
						JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, null);

				if (input == JOptionPane.OK_OPTION) {
					handler.cobrarArreglo(facturas);
					handler.mostrarExito("Listo! El pago se realizo con exito");
				}
			}
		});

		cancelarBoton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				handler.irAlInicio();
			}
		});

	}

	public Box crearBotonera(JButton[] botones) {
		Box horizontal = Box.createHorizontalBox();
		Box botonera = Box.createHorizontalBox();
		botonera.add(Box.createHorizontalGlue());

		for (int i = 0; i < botones.length; i++) {
			botonera.add(Box.createHorizontalStrut(10));
			botonera.add(botones[i]);
		}

		horizontal.add(botonera);
		add(horizontal, BorderLayout.SOUTH);

		return horizontal;
	}

}
