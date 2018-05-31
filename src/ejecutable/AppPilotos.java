package ejecutable;

import java.awt.EventQueue;

import controlador.Controlador;
import vista.VConsulta;
import vista.VModificar;
import vista.VPrincipal;
import vista.VRegistro;

public class AppPilotos {

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				
				VPrincipal vprincipal = new VPrincipal();
				VRegistro vregistro = new VRegistro();
				VConsulta vconsulta = new VConsulta();
				VModificar vmodificar = new VModificar();
				Controlador control = new Controlador(vprincipal, vregistro, vconsulta, vmodificar);
				
				vprincipal.setControlador(control);
				vregistro.setControlador(control);
				vconsulta.setControlador(control);
				vmodificar.setControlador(control);
				vprincipal.hacerVisible();
							
			}
			
		});

	}

}
