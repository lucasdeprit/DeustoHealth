package progIII.gui;

import java.awt.EventQueue;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.Color;

public class Calendar extends JFrame implements PropertyChangeListener {

	
	private static final long serialVersionUID = 1L;
	//the TextField for typing the date
	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
	private JTextField reason_txf;
	public JLabel username_lbl = new JLabel("New label");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calendar window = new Calendar();
					window.setVisible(true);
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
														
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(396, 372);
		Container cp = getContentPane();
		textField.setHorizontalAlignment(SwingConstants.CENTER);
		textField.setBounds(165, 86, 205, 30);
		 			
		 
		textField.setValue(new Date());
		textField.setPreferredSize(new Dimension(130, 30));
		    
		// display the window with the calendar
		CalendarWindow calendarWindow = new CalendarWindow(); 
		    
		//wire a listener for the PropertyChange event of the calendar window
		calendarWindow.addPropertyChangeListener(this);
		
		
		JButton calendarButton = new JButton("Seleccionar fecha");
		calendarButton.setBounds(10, 90, 145, 23);
				
		calendarButton.addActionListener(new ActionListener()
		{
		  public void actionPerformed(ActionEvent e)
		  {
			//render the calendar window below the text field
			calendarWindow.setLocation(textField.getLocationOnScreen().x, (textField.getLocationOnScreen().y + textField.getHeight()));
			//get the Date and assign it to the calendar
			Date d = (Date)textField.getValue();				
				
			calendarWindow.resetSelection(d);				
			calendarWindow.setUndecorated(true);
		    calendarWindow.setVisible(true);
		  }
		});
		getContentPane().setLayout(null);

		//add the UI controls to the ContentPane
		cp.add(textField);
		cp.add(calendarButton);
		cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		
		reason_txf = new JTextField();
		reason_txf.setBounds(165, 165, 205, 120);
		getContentPane().add(reason_txf);
		reason_txf.setColumns(10);
		
		JLabel reason_lbl = new JLabel("Motivo de la consulta :");
		reason_lbl.setHorizontalAlignment(SwingConstants.CENTER);
		reason_lbl.setBounds(20, 212, 135, 14);
		getContentPane().add(reason_lbl);
		
		JComboBox<String> time_comboBox = new JComboBox<String>();
		time_comboBox.setBounds(165, 127, 205, 23);
		getContentPane().add(time_comboBox);
        time_comboBox.addItem("08:00");
        time_comboBox.addItem("08:30");
        time_comboBox.addItem("09:00");
        time_comboBox.addItem("09:30");
        time_comboBox.addItem("10:00");
        time_comboBox.addItem("10:30");
        time_comboBox.addItem("11:00");
        time_comboBox.addItem("11:30");
        time_comboBox.addItem("12:00");
        time_comboBox.addItem("12:30");
        time_comboBox.addItem("13:00");
        time_comboBox.addItem("13:30");
        time_comboBox.addItem("14:00");
        time_comboBox.addItem("14:30");
        time_comboBox.addItem("15:00");
        time_comboBox.addItem("15:30");
        time_comboBox.addItem("16:00");
        time_comboBox.addItem("16:30");
        time_comboBox.addItem("17:00");
        time_comboBox.addItem("17:30");
        time_comboBox.addItem("18:00");
        time_comboBox.addItem("18:30");
        time_comboBox.addItem("19:00");
        time_comboBox.addItem("19:30");
        time_comboBox.addItem("20:00");
        
        JLabel time_lbl = new JLabel("Seleccionar hora");
        time_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        time_lbl.setBounds(10, 127, 145, 23);
        getContentPane().add(time_lbl);
        
        JButton exit_btn = new JButton("SALIR");
        exit_btn.setBounds(10, 299, 162, 23);
        getContentPane().add(exit_btn);
        
        JButton save_btn = new JButton("GUARDAR");
        save_btn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		FileWriter flwriter = null;
        		try {
        			//crea el flujo para escribir en el archivo
        			flwriter = new FileWriter("data/citas.txt");
        			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
        			BufferedWriter bfwriter = new BufferedWriter(flwriter);
        				bfwriter.write(username_lbl.getText().toString() + "," + textField.getText().toString() + "," + time_comboBox.getSelectedItem()
        						+ "," + reason_txf.getText().toString() + "\n");
        			
        			//cierra el buffer intermedio
        			bfwriter.close();
        			System.out.println("Archivo creado satisfactoriamente..");
         
        		} catch (IOException f) {
        			f.printStackTrace();
        		} finally {
        			if (flwriter != null) {
        				try {//cierra el flujo principal
        					flwriter.close();
        				} catch (IOException t) {
        					t.printStackTrace();
        				}
        			}
        		}
        	}
        		
        });
        save_btn.setBounds(182, 299, 188, 23);
        getContentPane().add(save_btn);
        
        username_lbl.setHorizontalAlignment(SwingConstants.CENTER);
        username_lbl.setForeground(Color.BLACK);
        username_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
        username_lbl.setBounds(88, 11, 99, 29);
        getContentPane().add(username_lbl);
        
        JLabel name_lbl = new JLabel("Nombre:");
        name_lbl.setHorizontalAlignment(SwingConstants.RIGHT);
        name_lbl.setFont(new Font("Tahoma", Font.PLAIN, 19));
        name_lbl.setBounds(10, 11, 74, 29);
        getContentPane().add(name_lbl);
	}
	
	 @Override
		public void propertyChange(PropertyChangeEvent event) {
			
     	//get the selected date from the calendar control and set it to the text field
			if (event.getPropertyName().equals("selectedDate")) {
	            
				java.util.Calendar cal = (java.util.Calendar)event.getNewValue();
				Date selDate =  cal.getTime();
				textField.setValue(selDate);
	        }
			
		}
}