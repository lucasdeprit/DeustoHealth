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
import java.sql.Statement;
import java.sql.SQLException;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import progIII.logic.*;
import progIII.bd.SqliteDatabase;

import javax.swing.JRadioButton;


public class Login extends JFrame   implements ThreadCompleteListener {
	
	public JFrame frame;
	private JTextField User_textField;
	private JPasswordField User_passwordField;
	Connection conn = null;
	private boolean hayActividad;
	NotifyingThread hilo;
	static Login login_window;

	public String user;
	public String pass;

	JRadioButton Doctor;
	JRadioButton Paciente;

	
	/* Lanzar la ventana()
	*/
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try { // crear la ventana y hacerla visible			
					login_window = new Login();
					login_window.frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
		
	}
	
	public Login() { // inicializar contenidos de la ventana.
		initialize();
		conn = SqliteDatabase.initBD("Usuarios");
		hilo = new CompruebaInactividad(100);
		hilo.addListener(this); // add ourselves as a listener
		hilo.start(); // Start the Thread
		
		/*File archivo = new File("JUnit/SqliteDatabasetest/SqliteDatabaseTest.test");
		Conexion SqliteDatabase = new Conexion(archivo);
		SqliteDatabase.abrir();
		SqliteDatabase.*/
		//SqliteDatabase.usarCrearTablasBD(conn);
	}

	private void initialize() { // definir contenidos ventana para inicializarlos
		frame = new JFrame();
		frame.setBounds(100,100,450,300); // definir tama�o ventana
		frame.getContentPane().setBackground(SystemColor.textHighlight);	//color del fondo de la ventana
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana
		frame.setUndecorated(true); //para remover el marco de la ventana
		frame.setLocationRelativeTo(null); // para centrar la ventana
		
		
		
		JButton btnLogin = new JButton("INICIAR SESION"); // crear boton
		btnLogin.addActionListener(new ActionListener() { // definir accion que ejecutar� el boton
			@Override
			public void actionPerformed(ActionEvent e) {
				//BD JOEL
				String p = "paciente";
				String d = "doctor";
				boolean paciente = Paciente.isSelected();
				//mandamps info a la clase que comprueba la actividad
				LoginCorrecto log = new LoginCorrecto(User_textField.getText(), User_passwordField.getPassword().toString(),conn,paciente);
				
				//if(LoginCorrecto.isTrue()&&paciente.isSelected())->try cacth cy acceso
				
				if( Doctor.isSelected()||Paciente.isSelected()) {
					
					
					SqliteDatabase.usarCrearTablasBD(conn);
					
					if(Paciente.isSelected()){
						
						int resultado = 0;
						
						try
						{
							user = User_textField.getText();
							pass = String.valueOf(User_passwordField.getText());
							
							System.out.println(pass);
							//PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient WHERE name=? AND password=?");
							
							
							//pst.setString(1, User_textField.getText());
							//pst.setString(2, User_passwordField.getPassword().toString());
							
							
							
							//pst.executeQuery();
							
							
							
							String sql = "select * from patient where name = '" + user + "'and password = '" + pass + "' ";
							
							PreparedStatement st = conn.prepareStatement(sql);
							ResultSet rs = st.executeQuery();
							
							if(rs.next()) {
								
								resultado = 1;
								
								if(resultado == 1) {
									
									JOptionPane.showMessageDialog(null, "Sesion iniciada como Paciente");
									
									frame.dispose();
									Homepage homepage_window = new Homepage(user);
									//homepage_window.user_name_lbl.setText(User_textField.getText().toUpperCase());
									homepage_window.rol_lbl.setText(p.toUpperCase());
									homepage_window.frame.setVisible(true);
									
									SqliteDatabase.cerrarBD(conn);
									
								}else {
									JOptionPane.showMessageDialog(null, "error al iniciar sesion, vuelva a intentarlo");
								}
							}
							
							// por ahora no se comprueba es para seguir haciendo cosas
							

							

							
							

							
							
						

						}catch(SQLException ex) {

							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "error al iniciar sesion, vuelva a intentarlo");
						}
						
					}if(Doctor.isSelected()){
						
						int resultado = 0;
						
						try
						{
							user = User_textField.getText();
							pass = String.valueOf(User_passwordField.getText());
							
							System.out.println(pass);
							//PreparedStatement pst = conn.prepareStatement("SELECT * FROM patient WHERE name=? AND password=?");
							
							
							//pst.setString(1, User_textField.getText());
							//pst.setString(2, User_passwordField.getPassword().toString());
							
							
							
							//pst.executeQuery();
							
							
							
							String sql = "select * from doctor where name = '" + user + "'and password = '" + pass + "' ";
							
							PreparedStatement st = conn.prepareStatement(sql);
							ResultSet rs = st.executeQuery();
							
							if(rs.next()) {
								
								resultado = 1;
								
								if(resultado == 1) {
									
									JOptionPane.showMessageDialog(null, "Sesion iniciada como Doctor");
									
									frame.dispose();
									Homepage homepage_window = new Homepage();
									homepage_window.user_name_lbl.setText(User_textField.getText().toUpperCase());
									homepage_window.rol_lbl.setText(d.toUpperCase());
									homepage_window.frame.setVisible(true);
									
									
								}else {
									JOptionPane.showMessageDialog(null, "error al iniciar sesion, vuelva a intentarlo");
								}
							}
							
							// por ahora no se comprueba es para seguir haciendo cosas
							

							

							
							

							
							
						

						}catch(SQLException ex) {

							ex.printStackTrace();
							JOptionPane.showMessageDialog(null, "error al iniciar sesion, vuelva a intentarlo");
						}
					
				}
					
				}else{
					JOptionPane.showMessageDialog(null, "Introduce un ROL compatible: paciente o doctor");
					}
			} 
		}); 

		btnLogin.setForeground(new Color(51,0,51)); // primer plano del boton
		btnLogin.setBackground(Color.LIGHT_GRAY); // color de fondo del boton
		btnLogin.setFont(new Font("Tahoma", Font.BOLD, 9)); // tipo de letra y tama�o
		btnLogin.setBounds(230,203,123,52); // definir los bordes del boton (localizacion)
		frame.getContentPane().add(btnLogin); // a�adir el boton a nuestra ventana
		

		JButton btnRegister = new JButton("REGISTRARSE");
		btnRegister.addActionListener(new ActionListener() {
			@Override
			
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				Register register_window = new Register();
				register_window.frame.setVisible(true);
				hayActividad = true;
			}
		});
		btnRegister.setForeground(new Color(51,0,51)); 
		btnRegister.setBackground(Color.LIGHT_GRAY); 
		btnRegister.setFont(new Font("Tahoma", Font.BOLD, 10)); 
		btnRegister.setBounds(88,203,123,52);
		frame.getContentPane().add(btnRegister); 
		
		JButton btnExit = new JButton("SALIR");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
			}
		});
		btnExit.setForeground(new Color(51,0,51)); 
		btnExit.setBackground(Color.LIGHT_GRAY); 
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11)); 
		btnExit.setBounds(102, 266, 244, 23);
		frame.getContentPane().add(btnExit);
		
		User_textField = new JTextField();				//campo en el que proporcionaremos un nombre de usuario
		User_textField.setBounds(129, 58, 214, 30);
		frame.getContentPane().add(User_textField);
		User_textField.setColumns(10);
		
		User_passwordField = new JPasswordField();		//se utiliza para cuando queremos guardar una cotrase�a, ya que siempre es algo que no se debe ver, debido a la seguridad del usuario
		User_passwordField.setBounds(129, 111, 214, 30);
		frame.getContentPane().add(User_passwordField);
		
		JLabel user_lbl = new JLabel("");
		user_lbl.setHorizontalAlignment(SwingConstants.CENTER);							 //definimos el punto de referencia para la alineaci�n horizontal que seleccionamos
		user_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-user-30.png"))); //ruta de la imagen que situaremos en este label.
		user_lbl.setBounds(88, 58, 32, 30);												 //User icon by Icons8
		frame.getContentPane().add(user_lbl);
		
		JLabel password_lbl = new JLabel("");
		password_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		password_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-password-1-48.png"))); //Password1 icon by Icons8
		password_lbl.setBounds(83, 99, 38, 45);
		frame.getContentPane().add(password_lbl);
		
		JLabel title_lbl = new JLabel(" DEUSTOHEALTH LOGIN");
		title_lbl.setForeground(SystemColor.text);
		title_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		title_lbl.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 20));
		title_lbl.setBounds(72, 11, 315, 36);
		title_lbl.setIcon(new ImageIcon(Login.class.getResource("/icons8-user-30.png")));//User icon by Icons8 
		frame.getContentPane().add(title_lbl);
		
		JLabel rol_lbl = new JLabel("ROL:");
		rol_lbl.setFont(new Font("Tahoma", Font.PLAIN, 13));
		rol_lbl.setForeground(Color.WHITE);
		rol_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		rol_lbl.setBounds(74, 160, 46, 29);
		frame.getContentPane().add(rol_lbl);
		JList<JTextField> seleccion = new JList<JTextField>();
		JTextField doctor = new JTextField("Doctor");
		doctor.setVisible(true);
		
		JTextField paciente = new JTextField("Paciente");
		paciente.setVisible(true);
		
		seleccion.add(doctor, 0);
		seleccion.add(paciente,1);
		seleccion.setFont(new Font("Tahoma", Font.PLAIN, 13));
		seleccion.setForeground(Color.WHITE);
		//seleccion.setHorizontalAlignment(SwingConstants.RIGHT);
		seleccion.setBounds(74, 160, 46, 29);
		frame.getContentPane().add(rol_lbl);
		
		Paciente = new JRadioButton("Paciente");
		Paciente.setForeground(Color.WHITE);
		Paciente.setBounds(151, 165, 73, 18);
		frame.getContentPane().add(Paciente);
		
		Doctor=new JRadioButton("Doctor");
		Doctor.setForeground(Color.WHITE);
		Doctor.setBounds(236, 165, 67, 18);
		frame.getContentPane().add(Doctor);
		seleccion.setVisible(true);
		ButtonGroup contenedor = new ButtonGroup();
		contenedor.add(Doctor);
		contenedor.add(Paciente);
		/*JRadioButton contenedor = new JRadioButton();
		contenedor.add(Doctor);
		contenedor.add(Paciente);
		contenedor.setVisible(true);
		
*/
		
			
	}

	public JTextField getUser_textField() {
		return User_textField;
	}

	public void setUser_textField(JTextField user_textField) {
		User_textField = user_textField;
	}

	public JPasswordField getUser_passwordField() {
		return User_passwordField;
	}

	public void setUser_passwordField(JPasswordField user_passwordField) {
		User_passwordField = user_passwordField;
	}

	@Override
	public void notifyOfThreadComplete(Thread thread) {
		if (!hayActividad) {
			System.exit(0);
			System.out.println(hayActividad);
		} else {
			login_window.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		}
		
	}
}
