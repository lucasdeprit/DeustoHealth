package progIII.gui;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JToolBar;
public class Agenda extends Frame implements ActionListener{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	 static final private String TEXT_ENTERED = "text";

	public Agenda() {
		JToolBar toolBar = new JToolBar("Still draggable");
	
		
		
	}
	 protected JButton makeNavigationButton(String imageName ,String actionCommand,String toolTipText,String altText) {

		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
		return button;
}
	 protected void addButtons(JToolBar toolBar) {
	        JButton button = null;
	 
	        //first button
	        button = makeNavigationButton("Back24", PREVIOUS,
	                                      "Back to previous something-or-other",
	                                      "Previous");
	        toolBar.add(button);
	 
	 
	        //third button
	        button = makeNavigationButton("Forward24", NEXT,
	                                      "Forward to something-or-other",
	                                      "Next");
	        toolBar.add(button);
	 
	        //separator
	        toolBar.addSeparator();
	 
	 
	        //fifth component is NOT a button!
	        JTextField textField = new JTextField("A text field");
	        textField.setColumns(10);
	        textField.addActionListener(this);
	        textField.setActionCommand(TEXT_ENTERED);
	        toolBar.add(textField);
	    }

	public static void main(String[] args) {
		Agenda a = new Agenda();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	

}
