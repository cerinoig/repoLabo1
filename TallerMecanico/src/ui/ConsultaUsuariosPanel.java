package ui;

import java.awt.BorderLayout;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import handler.Handler;

public class ConsultaUsuariosPanel extends ConsultaPanel{

	private static final long serialVersionUID = 1L;
	UsuariosTableModel usuariosTableModel ;
	public ConsultaUsuariosPanel(Handler handler) {
		super(handler);
	}

	@Override
	public void initUI(Handler handler) {
		
	}
	
	@Override
	public JLabel getTituloPanel() {
		return new JLabel("LISTADO DE USUARIOS");
	}

	@Override
	public JScrollPane getBody(Handler handler) {
		initTableModel(handler);
		return new JScrollPane(new JTable(usuariosTableModel));
	}

	@Override
	public void initTableModel(Handler handler) {
		usuariosTableModel = new UsuariosTableModel(handler.selectAllUsuarios());
		
	}

}
