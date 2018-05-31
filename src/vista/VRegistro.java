package vista;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import controlador.Controlador;
import modelo.piloto;

import javax.swing.JSpinner;

public class VRegistro extends JPanel {
	private JButton btnGuardar;
	private JTextField txtNombre;
	private JTextField txtNacio;
	private JTextField txtEscuderia;
	private JSpinner spinnerNum;
	private JSpinner spinnerEdad;
	
	public VRegistro() {
		inicializar();
	}
	
	private void inicializar() {
		setLayout(null);
		setBounds(0,0, 494, 448);
		
		btnGuardar = new JButton("GUARDAR");
		btnGuardar.setBounds(96, 343, 278, 70);
		add(btnGuardar);
		
		JLabel lblNumero = new JLabel("NUMERO");
		lblNumero.setBounds(10, 11, 150, 42);
		add(lblNumero);
		
		JLabel lblNombre = new JLabel("NOMBRE");
		lblNombre.setBounds(10, 64, 150, 42);
		add(lblNombre);
		
		JLabel lblNacionalidad = new JLabel("NACIONALIDAD");
		lblNacionalidad.setBounds(10, 117, 150, 47);
		add(lblNacionalidad);
		
		JLabel lblEdad = new JLabel("EDAD");
		lblEdad.setBounds(10, 175, 98, 47);
		add(lblEdad);
		
		JLabel lblEscuderia = new JLabel("ESCUDERIA");
		lblEscuderia.setBounds(10, 243, 169, 47);
		add(lblEscuderia);
		
		txtNombre = new JTextField();
		txtNombre.setColumns(10);
		txtNombre.setBounds(127, 75, 235, 29);
		add(txtNombre);
		
		txtNacio = new JTextField();
		txtNacio.setColumns(10);
		txtNacio.setBounds(127, 130, 235, 29);
		add(txtNacio);
		
		txtEscuderia = new JTextField();
		txtEscuderia.setColumns(10);
		txtEscuderia.setBounds(127, 256, 235, 29);
		add(txtEscuderia);
		
		spinnerEdad = new JSpinner();
		spinnerEdad.setBounds(127, 188, 45, 34);
		add(spinnerEdad);
		
		spinnerNum = new JSpinner();
		spinnerNum.setBounds(134, 11, 45, 34);
		add(spinnerNum);
	}
	
	public void setControlador(Controlador c) {
		btnGuardar.addActionListener(c);
	}

	public JButton getBtnGuardar() {
		return btnGuardar;
	}
	
	public piloto getDatos(){
		
		piloto pi = null;
		
		if(txtNombre.getText().equals("") || txtNacio.getText().equals("")) {
			JOptionPane.showMessageDialog(null, "No puede dejar ni el nombre ni la nacionalidad vacias");
		}
		else{
			pi = new piloto((int)spinnerNum.getValue(), txtNombre.getText(), txtNacio.getText(), (int)spinnerEdad.getValue(), txtEscuderia.getText());
		}
		
		return pi;
	}
}
