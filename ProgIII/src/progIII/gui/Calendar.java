package progIII.gui;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JMonthChooser;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Calendar {

	private JFrame frame;
	//private JMonthChooser mes;
	private String mes;
	private SimpleDateFormat sdf;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar window = new Calendar();
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
	public Calendar() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		sdf =  new SimpleDateFormat("MM");
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnAceptar = new JButton();
		
		btnAceptar.setText("Aceptar");
		JCalendar calendar = new JCalendar();
		calendar.setTodayButtonVisible(true);
		btnAceptar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(btnAceptar.isSelected()) {
					calendar.getMonthChooser().getMonth();
									}
				
			}
		});
		calendar.setTodayButtonText("Seleccionon Dia Actual");
		frame.getContentPane().add(calendar, BorderLayout.CENTER);
		frame.getContentPane().add(btnAceptar,BorderLayout.SOUTH);
	}

}
