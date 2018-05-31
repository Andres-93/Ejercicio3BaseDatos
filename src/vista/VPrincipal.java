package vista;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;

import controlador.Controlador;

public class VPrincipal extends JFrame {
	private JMenuItem mntRegistrar;
	private JMenuItem mntConsulta;
	private JMenuItem mntSalir;
	private JScrollPane scrollPane;
	public VPrincipal() {
		
		inicializar();
	}
	private void inicializar() {
		
		try {
			UIManager.setLookAndFeel(
					UIManager.getCrossPlatformLookAndFeelClassName());
		} catch (Exception e) {
			e.printStackTrace();
		}
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		mntRegistrar = new JMenuItem("Registrar");
		menuBar.add(mntRegistrar);
		
		mntConsulta = new JMenuItem("Consultar");
		menuBar.add(mntConsulta);
		
		mntSalir = new JMenuItem("Salir");
		menuBar.add(mntSalir);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 494, 448);
		getContentPane().add(scrollPane);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		setLocationRelativeTo(null);
	}

	public void hacerVisible() {
		
		setVisible(true);
		setSize(500, 500);	
		setLocationRelativeTo(null);
	}
	
	public void setPanel(JPanel panel) {			
		scrollPane.setViewportView(panel);
	}
	
	public void setControlador(Controlador c) {
		mntConsulta.addActionListener(c);
		mntRegistrar.addActionListener(c);
		mntSalir.addActionListener(c);
	}
	public JMenuItem getMntRegistrar() {
		return mntRegistrar;
	}
	public JMenuItem getMntConsulta() {
		return mntConsulta;
	}
	public JMenuItem getMntSalir() {
		return mntSalir;
	}
	
	public void confirmarSalida() {
		
		int num = JOptionPane.showConfirmDialog(getParent(),"Seguro que desea salir?","ventana",JOptionPane.YES_NO_OPTION);
		
		if(num == JOptionPane.YES_OPTION) {
			System.exit(0);			
		}
		
	}
	
}
