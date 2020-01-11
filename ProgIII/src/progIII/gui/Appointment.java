package progIII.gui;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollBar;

import progIII.bd.SqliteDatabase;

public class Appointment {

	public JFrame frame;
	private JList Appointment_list;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Appointment window = new Appointment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Appointment() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		Appointment_list = new JList();
		Appointment_list.setBounds(10, 21, 414, 217);
		frame.getContentPane().add(Appointment_list);
		loadList();
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 21, 17, 217);
		frame.getContentPane().add(scrollBar);
	}
	
	public void loadList() {
		Connection con = SqliteDatabase.initBD("Usuarios");
		SqliteDatabase.usarCrearTablasBD(con);
		
		try (PreparedStatement pst = con.prepareStatement("SELECT * FROM appointment")){
			
			ResultSet rs = pst.executeQuery();
			
			DefaultListModel list = new DefaultListModel();
			
			while(rs.next()) {
				list.addElement(rs.getString("reason"));
			}
			Appointment_list.setModel(list);
			pst.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}
