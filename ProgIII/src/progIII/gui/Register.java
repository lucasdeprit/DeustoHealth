package progIII.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;


public class Register {
	
	private JFrame frame;
	
	/* Lanzar la ventana()
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try { // crear la ventana y hacerla visible			
					Register register_window = new Register();
					register_window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Register() { // inicializar contenidos de la ventana
		initialize();
	}

	private void initialize() { // definir contenidos ventana para inicializarlos
		frame = new JFrame();
		frame.setBounds(100,100,450,300); // definir tamaño ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana
	
	}
}
