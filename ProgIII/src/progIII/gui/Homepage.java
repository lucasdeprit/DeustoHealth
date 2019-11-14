package progIII.gui;

import java.awt.EventQueue;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Homepage {

	public JFrame frame;
	public JLabel rol_lbl = new JLabel("New label");
	public JLabel user_name_lbl = new JLabel("New label");
	
	/**
	 * Launch the application.
	 * @throws UnsupportedLookAndFeelException 
	 * @throws IllegalAccessException 
	 * @throws InstantiationException 
	 * @throws ClassNotFoundException 
	 */
	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, UnsupportedLookAndFeelException {
		
		UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Homepage homepage_window = new Homepage();
					homepage_window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Homepage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100,100,600,450); // definir tamaño ventana 
		frame.getContentPane().setBackground(SystemColor.textHighlight);	//color del fondo de la ventana 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frame.getContentPane().setLayout(null); // definir distribucion componentes en la ventana 
		frame.setUndecorated(true); //para remover el marco de la ventana 
		frame.setLocationRelativeTo(null); // para centrar la ventana
		rol_lbl.setForeground(Color.WHITE);
		
		
		rol_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		rol_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		rol_lbl.setBounds(392, 79, 99, 29);
		frame.getContentPane().add(rol_lbl);
		
		JLabel titulo_lbl = new JLabel("  PAGINA PRINCIPAL");
		titulo_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		titulo_lbl.setFont(new Font("Imprint MT Shadow", Font.ITALIC, 23));
		titulo_lbl.setForeground(Color.WHITE);
		titulo_lbl.setBounds(92, 11, 375, 57);
		titulo_lbl.setIcon(new ImageIcon(Homepage.class.getResource("/icons8-casa-64.png")));	// Casa icon by Icons8
		frame.getContentPane().add(titulo_lbl);
		
		
		user_name_lbl.setForeground(Color.WHITE);
		user_name_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		user_name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		user_name_lbl.setBounds(140, 79, 99, 29);
		frame.getContentPane().add(user_name_lbl);
		
		JLabel n_lbl = new JLabel("Nombre:");
		n_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		n_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		n_lbl.setBounds(62, 79, 74, 29);
		frame.getContentPane().add(n_lbl);
		
		JLabel r_lbl = new JLabel("Rol:");
		r_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
		r_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
		r_lbl.setBounds(314, 79, 74, 29);
		frame.getContentPane().add(r_lbl);
		
		JButton make_appointment_btn = new JButton("Pedir Cita");
		make_appointment_btn.setSelectedIcon(null);
		make_appointment_btn.setBackground(new Color(255, 255, 255));
		make_appointment_btn.setIcon(new ImageIcon(Homepage.class.getResource("/icons8-hospital-48.png"))); // Hospital icon by Icons8
		make_appointment_btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String d = "doctor";
				if(rol_lbl.getText().toLowerCase().equals(d)) {
					JOptionPane.showMessageDialog(null, "El doctor no puede pedir una cita médica");
				}else {
					frame.dispose();
					Calendar window = new Calendar();
					window.username_lbl.setText(user_name_lbl.getText().toUpperCase());
					window.setVisible(true);
				}
				
			}
		});
		make_appointment_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		make_appointment_btn.setBounds(30, 210, 190, 57);
		frame.getContentPane().add(make_appointment_btn);
		
		JButton view_appointment_btn = new JButton("Ver Cita/as");
		view_appointment_btn.setIcon(new ImageIcon(Homepage.class.getResource("/icons8-eye-48.png"))); // Eye icon by Icons8
		view_appointment_btn.setFont(new Font("Tahoma", Font.PLAIN, 18));
		view_appointment_btn.setBackground(Color.WHITE);
		view_appointment_btn.setBounds(30, 313, 190, 57);
		frame.getContentPane().add(view_appointment_btn);
		
		


		
		
	}
}

