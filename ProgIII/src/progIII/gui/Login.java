package progIII.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Login {
	
	private JFrame frame;
	
	/* Lanzar la ventana()
	*/
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try { // crear la ventana y hacerla visible			
					Login login_window = new Login();
					login_window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Login() { // inicializar contenidos de la ventana
		initialize();
	}

	private void initialize() { // definir contenidos ventana para inicializarlos
		frame = new JFrame();
		frame.setBounds(100,100,450,300); // definir tamaño ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana
		
		JButton btnLogin = new JButton("Login"); // crear boton
		btnLogin.addActionListener(new ActionListener() { // definir accion que ejecutará el boton
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnLogin.setForeground(new Color(51,0,51)); // primer plano del boton
		btnLogin.setBackground(new Color(0,251,0)); // color de fondo del boton
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 12)); // tipo de letra y tamaño
		btnLogin.setBounds(250,144,123,52); // definir los bordes del boton (localizacion)
		frame.getContentPane().add(btnLogin); // añadir el boton a nuestra ventana
		

		JButton btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnRegister.setForeground(new Color(51,0,51)); 
		btnRegister.setBackground(new Color(0,251,0)); 
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 12)); 
		btnRegister.setBounds(50,144,123,52);
		frame.getContentPane().add(btnRegister); 
		
	}
}
