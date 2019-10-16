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

public class Register {
	
	public JFrame frame;
	private JTextField name_textField;
	private JTextField direction_textField;
	private JTextField email_textField;
	private JTextField rol_textField;
	private JPasswordField user_passwordField;
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
		frame.getContentPane().setBackground(SystemColor.textHighlight);
		frame.setBounds(100,100,450,300); // definir tamaño ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana
		frame.setUndecorated(true); //para remover el marco de la ventana
		
		JLabel name_lbl = new JLabel("NOMBRE:");
		name_lbl.setForeground(Color.WHITE);
		name_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		name_lbl.setBounds(10, 64, 70, 14);
		frame.getContentPane().add(name_lbl);
		
		JLabel password_lbl = new JLabel("PASSWORD:");
		password_lbl.setForeground(Color.WHITE);
		password_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		password_lbl.setBounds(0, 89, 80, 14);
		frame.getContentPane().add(password_lbl);
		
		JLabel adress_lbl = new JLabel("DIRECCION:");
		adress_lbl.setForeground(Color.WHITE);
		adress_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		adress_lbl.setBounds(10, 114, 70, 14);
		frame.getContentPane().add(adress_lbl);
		
		JLabel email_lbl = new JLabel("EMAIL:");
		email_lbl.setForeground(Color.WHITE);
		email_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		email_lbl.setBounds(10, 139, 70, 14);
		frame.getContentPane().add(email_lbl);
		
		JLabel rol_lbl = new JLabel("ROL:");
		rol_lbl.setForeground(Color.WHITE);
		rol_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		rol_lbl.setBounds(10, 164, 70, 14);
		frame.getContentPane().add(rol_lbl);
		
		name_textField = new JTextField();
		name_textField.setBounds(82, 61, 342, 20);
		frame.getContentPane().add(name_textField);
		name_textField.setColumns(10);
		
		direction_textField = new JTextField();
		direction_textField.setColumns(10);
		direction_textField.setBounds(82, 111, 342, 20);
		frame.getContentPane().add(direction_textField);
		
		email_textField = new JTextField();
		email_textField.setColumns(10);
		email_textField.setBounds(82, 136, 342, 20);
		frame.getContentPane().add(email_textField);
		
		rol_textField = new JTextField();
		rol_textField.setColumns(10);
		rol_textField.setBounds(82, 161, 101, 20);
		frame.getContentPane().add(rol_textField);
		
		user_passwordField = new JPasswordField();
		user_passwordField.setBounds(82, 86, 342, 17);
		frame.getContentPane().add(user_passwordField);
		
		JButton register_btn = new JButton("");
		register_btn.setIcon(new ImageIcon(Register.class.getResource("/icons8-registration-64.png"))); //Registration icon by Icons8
		register_btn.setBounds(251, 207, 159, 64);
		frame.getContentPane().add(register_btn);
		
		JButton return_btn = new JButton("");
		return_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Login is_window = new Login(); 
				is_window.frame.setVisible(true); 
			}
		});
		return_btn.setBounds(38, 207, 165, 64);
		return_btn.setIcon(new ImageIcon(Register.class.getResource("/icons8-left-2-64.png")));//Left2 icon by Icons8
		frame.getContentPane().add(return_btn);
		
		JLabel title_lbl = new JLabel("REGISTRARSE"); 
		title_lbl.setForeground(SystemColor.text); 
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER); 
		title_lbl.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 20)); 
		title_lbl.setBounds(89, 11, 275, 41); 
		title_lbl.setIcon(new ImageIcon(Register.class.getResource("/icons8-registration-64.png"))); //Registration icon by Icons8
		frame.getContentPane().add(title_lbl); 
	}
}
