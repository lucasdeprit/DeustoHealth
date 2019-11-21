package progIII.gui;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
public class Agenda extends Frame implements ActionListener{


	/**
	 * 
	 */
	protected JTextArea textArea;
	protected String newLine = "\n";
	private static final long serialVersionUID = 1L;
<<<<<<< HEAD
	 static final private String TEXT_ENTERED = "text";
	 static final private String PREVIOUS = "previous";
	    static final private String NEXT = "next";
=======
	static final private String TEXT_ENTERED = "text";
>>>>>>> branch 'lucas' of https://github.com/lucasdeprit/DeustoHealth

	public Agenda() {
		JToolBar toolBar = new JToolBar("Still draggable");
<<<<<<< HEAD
		 addButtons(toolBar);
	        toolBar.setFloatable(false);
	        toolBar.setRollover(true);
	 
	        //Create the text area used for output.  Request
	        //enough space for 5 rows and 30 columns.
	        textArea = new JTextArea(5, 30);
	        textArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(textArea);
	 
	        //Lay out the main panel.
	        setPreferredSize(new Dimension(450, 130));
	        add(toolBar, BorderLayout.PAGE_START);
	        add(scrollPane, BorderLayout.CENTER);
	
		
		
	}
	 protected JButton makeNavigationButton(String imageName ,String actionCommand,String toolTipText,String altText) {
		 //Look for the image.
	        String imgLocation = "/"
	                             + imageName
	                             + ".jpeg";
	    URL imageURL = Agenda.class.getResource(imgLocation);
=======



	}
	protected JButton makeNavigationButton(String imageName,
			String actionCommand,
			String toolTipText,
			String altText) {
		//Look for the image.
		String imgLocation = "images/"
				+ imageName
				+ ".gif";
		URL imageURL = JToolBar.class.getResource(imgLocation);

		//Create and initialize the button.
>>>>>>> branch 'lucas' of https://github.com/lucasdeprit/DeustoHealth
		JButton button = new JButton();
		button.setActionCommand(actionCommand);
		button.setToolTipText(toolTipText);
		button.addActionListener(this);
<<<<<<< HEAD
		if (imageURL != null) {                      //image found
            button.setIcon(new ImageIcon(imageURL, altText));
        } else {                                     //no image found
            button.setText(altText);
            System.err.println("Resource not found: "
                               + imgLocation);
        }
=======

		if (imageURL != null) {                      //image found
			button.setIcon(new ImageIcon(imageURL, altText));
		} else {                                     //no image found
			button.setText(altText);
			System.err.println("Resource not found: " + imgLocation);
		}

>>>>>>> branch 'lucas' of https://github.com/lucasdeprit/DeustoHealth
		return button;
<<<<<<< HEAD
}
	 protected void addButtons(JToolBar toolBar) {
	        JButton button = null;
	 
	        //first button
	        button = makeNavigationButton("back", PREVIOUS,
	                                      "Back to previous something-or-other",
	                                      "Previous");
	        toolBar.add(button);
	 
	 
	        //third button
	        button = makeNavigationButton("next", NEXT,
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
	 private static void createAndShowGUI() {
	        //Create and set up the window.
	        JFrame frame = new JFrame("ToolBarDemo2");
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 
	        //Add content to the window.
	        frame.add(new Agenda());
	 
	        //Display the window.
	        frame.pack();
	        frame.setVisible(true);
	    }
=======
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

>>>>>>> branch 'lucas' of https://github.com/lucasdeprit/DeustoHealth

	public static void main(String[] args) {
		 SwingUtilities.invokeLater(new Runnable() {
	            public void run() {
	                //Turn off metal's use of bold fonts
	            UIManager.put("swing.boldMetal", Boolean.FALSE);
	            createAndShowGUI();
	            }
	        });
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub

	}


}
