package progIII.gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.ComponentOrientation;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.text.DateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;

public class Calendar extends JFrame implements PropertyChangeListener {

	
	private static final long serialVersionUID = 1L;
	//the TextField for typing the date
	JFormattedTextField  textField = new JFormattedTextField(DateFormat.getDateInstance(DateFormat.SHORT));
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
		setSize(368, 362);
		Container cp = getContentPane();
		FlowLayout flowLayout = new FlowLayout();
		
		cp.setLayout(flowLayout);			
		 			
		 
		textField.setValue(new Date());
		textField.setPreferredSize(new Dimension(130, 30));
		    
		// display the window with the calendar
		CalendarWindow calendarWindow = new CalendarWindow(); 
		    
		//wire a listener for the PropertyChange event of the calendar window
		calendarWindow.addPropertyChangeListener(this);
		
		
		JButton calendarButton = new JButton("Pick a Date");
				
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

		//add the UI controls to the ContentPane
		cp.add(textField);
		cp.add(calendarButton);
		cp.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
        
        
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
