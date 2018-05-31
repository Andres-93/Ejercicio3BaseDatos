package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import persistencia.PilotoPersistencia;
import vista.VConsulta;
import vista.VModificar;
import vista.VPrincipal;
import vista.VRegistro;

public class Controlador implements ActionListener {

	private VPrincipal vprincipal;
	private VRegistro vregistro;
	private VConsulta vconsulta;
	private VModificar vmodificar;
	
	
	
		
	public Controlador(VPrincipal vprincipal, VRegistro vregistro, VConsulta vconsulta,VModificar vmodificar) {
		this.vprincipal = vprincipal;
		this.vregistro = vregistro;
		this.vconsulta = vconsulta;
		this.vmodificar = vmodificar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource().equals(vprincipal.getMntRegistrar())) {
			vprincipal.setPanel(vregistro);
		}else if(e.getSource().equals(vprincipal.getMntConsulta())) {
			vprincipal.setPanel(vconsulta);
			vconsulta.rellenarTable(new PilotoPersistencia().cargarPilotos());
		}else if(e.getSource().equals(vregistro.getBtnGuardar())) {
			if(vregistro.getDatos() != null) {
				new PilotoPersistencia().añadirPiloto(vregistro.getDatos());
			}
		}else if(e.getSource().equals(vconsulta.getBtnModificar())) {
			
			if(vconsulta.selecionado()) {
				vprincipal.setPanel(vmodificar);
				vmodificar.mostrarDatos(vconsulta.getDatos());
			}else {
				JOptionPane.showMessageDialog(null, "Debe seleccionar un piloto para modificar");
			}
		}else if(e.getSource().equals(vconsulta.getBtnEliminar())) {
			new PilotoPersistencia().eliminarPiloto(vconsulta.getDatos());
			vconsulta.rellenarTable(new PilotoPersistencia().cargarPilotos());
		}else if(e.getSource().equals(vmodificar.getBtnModificar())) {
			new PilotoPersistencia().modificarAlumno(vmodificar.getDatos());
			vprincipal.setPanel(vconsulta);
			vconsulta.rellenarTable(new PilotoPersistencia().cargarPilotos());
		}else if(e.getSource().equals(vprincipal.getMntSalir())) {
			vprincipal.confirmarSalida();
		}

	}

}
