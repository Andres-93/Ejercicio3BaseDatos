package vista;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.piloto;

import javax.swing.JSpinner;
import javax.swing.JButton;

public class VModificar extends JPanel {
	private JTextField txtNum;
	private JTextField txtNombre;
	private JTextField txtNacio;
	private JTextField txtEscuderia;
	private JSpinner spinnerEdad;
	private JButton btnModificar;
	public VModificar() {
		inicializar();
	}
	private void inicializar() {
		setBounds(0,0, 494, 448);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NUMERO");
		lblNewLabel.setBounds(10, 34, 98, 36);
		add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 110, 103, 28);
		add(lblNombre);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(10, 165, 103, 28);
		add(lblNacionalidad);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(10, 223, 103, 28);
		add(lblEdad);
		
		JLabel lblEscuderia = new JLabel("ESCUDERIA");
		lblEscuderia.setBounds(10, 277, 103, 28);
		add(lblEscuderia);
		
		txtNum = new JTextField();
		txtNum.setBounds(143, 29, 234, 36);
		add(txtNum);
		txtNum.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(143, 102, 234, 36);
		add(txtNombre);
		
		txtNacio = new JTextField();
		txtNacio.setColumns(10);
		txtNacio.setBounds(143, 157, 234, 36);
		add(txtNacio);
		
		txtEscuderia = new JTextField();
		txtEscuderia.setColumns(10);
		txtEscuderia.setBounds(143, 269, 234, 36);
		add(txtEscuderia);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(143, 204, 63, 44);
		add(spinnerEdad);
		
		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(101, 336, 276, 76);
		add(btnModificar);
		txtNum.setEnabled(false);
		txtNombre.setEnabled(false);
	}
	
	public void setControlador(Controlador c) {
		btnModificar.addActionListener(c);
	}
	
	public void mostrarDatos(piloto pi) {
		
		txtNombre.setText(pi.getNombre());
		txtEscuderia.setText(pi.getEscuderia());
		txtNacio.setText(pi.getNacionalidad());
		txtNum.setText(pi.getNumero()+ "");
		spinnerEdad.setValue(pi.getEdad());
	}
	public JButton getBtnModificar() {
		return btnModificar;
	}
	
	public piloto getDatos() {
		piloto pi = new piloto(Integer.parseInt(txtNum.getText()),txtNombre.getText(), txtNacio.getText(), (int)spinnerEdad.getValue(), txtEscuderia.getText());
		return pi;
	}
	
}
