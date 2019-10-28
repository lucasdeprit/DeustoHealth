package progIII.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import bd.SqliteDatabase;

public class Register {
	
	public JFrame frame;
	private JTextField name_textField;
	private JTextField address_textField;
	private JTextField email_textField;
	private JTextField rol_textField;
	private JPasswordField user_passwordField;
	Connection conn = null;
	private JTextField id_textField;
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
		conn = SqliteDatabase.initBD("Usuarios");
		
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
		name_lbl.setBounds(20, 79, 70, 14);
		frame.getContentPane().add(name_lbl);
		
		JLabel password_lbl = new JLabel("CONTRASE\u00D1A:");
		password_lbl.setForeground(Color.WHITE);
		password_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		password_lbl.setBounds(10, 104, 86, 14);
		frame.getContentPane().add(password_lbl);
		
		JLabel adress_lbl = new JLabel("DIRECCION:");
		adress_lbl.setForeground(Color.WHITE);
		adress_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		adress_lbl.setBounds(20, 129, 70, 14);
		frame.getContentPane().add(adress_lbl);
		
		JLabel email_lbl = new JLabel("EMAIL:");
		email_lbl.setForeground(Color.WHITE);
		email_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		email_lbl.setBounds(20, 154, 70, 14);
		frame.getContentPane().add(email_lbl);
		
		JLabel rol_lbl = new JLabel("ROL:");
		rol_lbl.setForeground(Color.WHITE);
		rol_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		rol_lbl.setBounds(20, 179, 70, 14);
		frame.getContentPane().add(rol_lbl);
		
		name_textField = new JTextField();
		name_textField.setBounds(92, 76, 342, 20);
		frame.getContentPane().add(name_textField);
		name_textField.setColumns(10);
		
		address_textField = new JTextField();
		address_textField.setColumns(10);
		address_textField.setBounds(92, 126, 342, 20);
		frame.getContentPane().add(address_textField);
		
		email_textField = new JTextField();
		email_textField.setColumns(10);
		email_textField.setBounds(92, 151, 342, 20);
		frame.getContentPane().add(email_textField);
		
		rol_textField = new JTextField();
		rol_textField.setColumns(10);
		rol_textField.setBounds(92, 176, 101, 20);
		frame.getContentPane().add(rol_textField);
		
		user_passwordField = new JPasswordField();
		user_passwordField.setBounds(92, 101, 342, 17);
		frame.getContentPane().add(user_passwordField);
		
		JButton register_btn = new JButton("");
		register_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String p = "paciente";
				String d = "doctor";
				
				SqliteDatabase.usarCrearTablasBD(conn);
				
				if(rol_textField.getText().toLowerCase().equals(p)){
					
					JOptionPane.showMessageDialog(null, rol_textField);
					try (PreparedStatement pst = conn.prepareStatement("INSERT INTO patient(name,id,password,address,mail) VALUES(?,?,?,?,?)");) 
					{
						pst.setString(1, name_textField.getText());
						pst.setString(2, id_textField.getText());
						pst.setString(3, user_passwordField.getPassword().toString());
						pst.setString(4, address_textField.getText());
						pst.setString(5, email_textField.getText());
						
						pst.executeUpdate();
						
						JOptionPane.showMessageDialog(null, "Paciente registrado");
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}if(rol_textField.getText().toLowerCase().equals(d)){
					JOptionPane.showMessageDialog(null, rol_textField);
					try {
						
						String query = "INSERT INTO doctor(name,id,password,address,mail) VALUES(?,?,?,?,?)";
						PreparedStatement pst = conn.prepareStatement(query);
						pst.setString(1, name_textField.getText());
						pst.setString(2, id_textField.getText());
						pst.setString(3, user_passwordField.getPassword().toString());
						pst.setString(4, address_textField.getText());
						pst.setString(5, email_textField.getText());
						
						ResultSet rs = pst.executeQuery();
						
						JOptionPane.showMessageDialog(null, "Doctor registrado");
						
						pst.close();
						rs.close();
						
					}catch(Exception e) {
						e.printStackTrace();
					}
				}else{
					JOptionPane.showMessageDialog(null, rol_textField.getText().toString());
					JOptionPane.showMessageDialog(null, "Introduce un ROL compatible: paciente o médico");
				}
			}
		});
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
		title_lbl.setBounds(78, 11, 275, 41); 
		title_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-registration-64.png"))); //Registration icon by Icons8
		frame.getContentPane().add(title_lbl); 
		
		JLabel id_lbl = new JLabel("ID:");
		id_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		id_lbl.setForeground(Color.WHITE);
		id_lbl.setBounds(20, 55, 70, 14);
		frame.getContentPane().add(id_lbl);
		
		id_textField = new JTextField();
		id_textField.setColumns(10);
		id_textField.setBounds(92, 52, 342, 20);
		frame.getContentPane().add(id_textField);
		
	}
}
