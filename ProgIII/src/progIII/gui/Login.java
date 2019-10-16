package progIII.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Login {
	
	private JFrame frame;
	private JTextField User_textField;
	private JPasswordField User_passwordField;
	
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
		frame.setBounds(100,100,450,300); // definir tama�o ventana
		frame.getContentPane().setBackground(SystemColor.textHighlight);	//color del fondo de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana
		frame.setUndecorated(true); //para remover el marco de la ventana
		
		
		JButton btnLogin = new JButton("INICIAR SESION"); // crear boton
		btnLogin.addActionListener(new ActionListener() { // definir accion que ejecutar� el boton
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnLogin.setForeground(new Color(51,0,51)); // primer plano del boton
		btnLogin.setBackground(Color.LIGHT_GRAY); // color de fondo del boton
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 9)); // tipo de letra y tama�o
		btnLogin.setBounds(72,191,123,52); // definir los bordes del boton (localizacion)
		frame.getContentPane().add(btnLogin); // a�adir el boton a nuestra ventana
		

		JButton btnRegister = new JButton("REGISTRARSE");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		btnRegister.setForeground(new Color(51,0,51)); 
		btnRegister.setBackground(Color.LIGHT_GRAY); 
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 10)); 
		btnRegister.setBounds(236,191,123,52);
		frame.getContentPane().add(btnRegister); 
		
		JButton btnExit = new JButton("SALIR");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnExit.setForeground(new Color(51,0,51)); 
		btnExit.setBackground(Color.LIGHT_GRAY); 
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11)); 
		btnExit.setBounds(89, 266, 244, 23);
		frame.getContentPane().add(btnExit);
		
		User_textField = new JTextField();				//campo en el que proporcionaremos un nombre de usuario
		User_textField.setBounds(130, 82, 214, 30);
		frame.getContentPane().add(User_textField);
		User_textField.setColumns(10);
		
		User_passwordField = new JPasswordField();		//se utiliza para cuando queremos guardar una cotrase�a, ya que siempre es algo que no se debe ver, debido a la seguridad del usuario
		User_passwordField.setBounds(130, 135, 214, 30);
		frame.getContentPane().add(User_passwordField);
		
		JLabel user_lbl = new JLabel("");
		user_lbl.setHorizontalAlignment(SwingConstants.CENTER);							 //definimos el punto de referencia para la alineaci�n horizontal que seleccionamos
		user_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-user-30.png"))); //ruta de la imagen que situaremos en este label.
		user_lbl.setBounds(89, 82, 32, 30);												 //User icon by Icons8
		frame.getContentPane().add(user_lbl);
		
		JLabel password_lbl = new JLabel("");
		password_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		password_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-password-1-48.png"))); //Password1 icon by Icons8
		password_lbl.setBounds(84, 123, 38, 45);
		frame.getContentPane().add(password_lbl);
		
		JLabel title_lbl = new JLabel("DEUSTOHEALTH LOGIN");
		title_lbl.setForeground(SystemColor.text);
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		title_lbl.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 20));
		title_lbl.setBounds(84, 21, 275, 50);
		frame.getContentPane().add(title_lbl);
		
		
	}
}
