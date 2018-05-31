package vista;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import controlador.Controlador;
import modelo.piloto;

import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class VConsulta extends JPanel {
	
	private JTable table;
	private JButton btnModificar;
	private JButton btnEliminar;
	private DefaultTableModel ta;
	
	public VConsulta() {
		inicializar();
	}
	private void inicializar() {
		setLayout(null);
		setBounds(0,0, 494, 448);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 80, 474, 298);
		add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int filaSel = table.getSelectedRow();
				
				if(filaSel == -1) {
					btnEliminar.setEnabled(false);
				}else{
					btnEliminar.setEnabled(true);
				}
			}
		});
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("PILOTOS REGISTRADOS");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(91, 11, 287, 44);
		add(lblNewLabel);
		
		btnModificar = new JButton("MODIFICAR");
		btnModificar.setBounds(10, 387, 162, 50);
		add(btnModificar);
		
		btnEliminar = new JButton("ELIMINAR");
		btnEliminar.setBounds(289, 389, 172, 48);
		add(btnEliminar);
		btnEliminar.setEnabled(false);
	}
	public void setControlador(Controlador c) {
		btnEliminar.addActionListener(c);
		btnModificar.addActionListener(c);
	}
	
	public void rellenarTable(ArrayList<piloto> lista) {
		
		 ta = new DefaultTableModel() {
				
				public boolean isCellEditable(int row, int colum) {
					 return false;
				}	
			};
		table.setModel(ta);
		
		
		ta.addColumn("NUMERO");
		ta.addColumn("NOMBRE");
		ta.addColumn("NACIONALIDAD");
		ta.addColumn("EDAD");
		ta.addColumn("ESCUDERIA");
		
		table.getColumn("NUMERO").setPreferredWidth(50);
		table.getColumn("NOMBRE").setPreferredWidth(125);
		table.getColumn("NACIONALIDAD").setPreferredWidth(75);
		table.getColumn("EDAD").setPreferredWidth(50);
		table.getColumn("ESCUDERIA").setPreferredWidth(125);
		
		Object[] fila = new Object[5];
		
		
		for(piloto pi : lista) {
			
			fila[0] = pi.getNumero();
			fila[1] = pi.getNombre();
			fila[2] = pi.getNacionalidad();
			fila[3] = pi.getEdad();
			fila[4] = pi.getEscuderia();
			ta.addRow(fila);
		}
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	public JButton getBtnEliminar() {
		return btnEliminar;
	}
	public piloto getDatos() {
		piloto pi = new piloto((int)table.getModel().getValueAt(table.getSelectedRow(), 0), table.getModel().getValueAt(table.getSelectedRow(), 1).toString(), table.getModel().getValueAt(table.getSelectedRow(), 2).toString(),(int) table.getModel().getValueAt(table.getSelectedRow(), 3), table.getModel().getValueAt(table.getSelectedRow(), 4).toString());
		return pi;
	}
	
	public boolean selecionado() {
		boolean seleccion = false;
		int filaSel = table.getSelectedRow();
		if(filaSel != -1) {		
			seleccion = true;
		}		
		return seleccion;
	}	
}
