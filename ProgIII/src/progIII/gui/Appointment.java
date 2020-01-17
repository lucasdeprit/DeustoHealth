package progIII.gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;

import progIII.bd.SqliteDatabase;
import javax.swing.JButton;

public class Appointment {
//ClASE APPOINTMENT
	public JFrame frame;
	private JList Appointment_list;
	public JLabel user_name_lb = new JLabel("");
	public String rol;
	public String name;
	

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

	public Appointment(String n, String rol) {
		// CAMBIO.
		this.name = n;
		this.rol = rol;
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
		Appointment_list.setBounds(10, 11, 414, 217);
		frame.getContentPane().add(Appointment_list);
		loadList();

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(407, 11, 17, 217);
		frame.getContentPane().add(scrollBar);

		JButton btnSalir = new JButton("SALIR");
		btnSalir.setBounds(20, 239, 89, 23);
		frame.getContentPane().add(btnSalir);
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.dispose();
				Homepage homepage = new Homepage();
				homepage.user_name_lbl.setText(user_name_lb.getText().toUpperCase());
				homepage.rol_lbl.setText(rol.toString());
				homepage.frame.setVisible(true);
			}
		});
		JButton btnVerDetalles = new JButton("VER DETALLES");
		btnVerDetalles.setBounds(164, 239, 114, 23);
		frame.getContentPane().add(btnVerDetalles);
		btnVerDetalles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Appointment_list.setVisible(false);

				JTextArea Appointment_details_list = new JTextArea();
				Appointment_details_list.setBounds(1, 21, 414, 217);
				frame.getContentPane().add(Appointment_details_list);

				loadDetailsText(Appointment_details_list);

			}
		});

	}

	public void loadList() {

		System.out.println(rol);
		Connection con = SqliteDatabase.initBD("Usuarios");
		SqliteDatabase.usarCrearTablasBD(con);

		if (rol.equals("paciente")) {

			try (PreparedStatement pst = con.prepareStatement(
					"SELECT * FROM appointment where id_patient like (select id from patient where name= '" + name
							+ "')")) {
				
				ResultSet rs = pst.executeQuery();

				DefaultListModel list = new DefaultListModel();

				while (rs.next()) {

					list.addElement(rs.getString("reason"));
				}
				Appointment_list.setModel(list);
				pst.close();
				rs.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			try (PreparedStatement pst = con.prepareStatement(
					"SELECT * FROM appointment where id_doctor like (select id from doctor where name= '" + name
							+ "')")) {
				
				ResultSet rs = pst.executeQuery();

				DefaultListModel list = new DefaultListModel();

				while (rs.next()) {

					list.addElement(rs.getString("reason"));
				}
				Appointment_list.setModel(list);
				pst.close();
				rs.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}
	}

	public void loadDetailsText(JTextArea Appointment_details_list) {
		Connection con = SqliteDatabase.initBD("Usuarios");
		SqliteDatabase.usarCrearTablasBD(con);

		try (PreparedStatement pst = con.prepareStatement(
				"SELECT * FROM appointment where reason = '" + Appointment_list.getSelectedValue().toString() + "'")) {
			ResultSet rs = pst.executeQuery();

			while (rs.next()) {

				Appointment_details_list.setText(

						"Razon: " + rs.getString("reason") + "\n" + "Fecha: " + rs.getDate("date_ini") + "\n"
								+ "Doctor(id): " + rs.getInt("id_doctor") + "\n" + "Paciente(id): "
								+ rs.getInt("id_patient")

				);
			}

			pst.close();
			rs.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
