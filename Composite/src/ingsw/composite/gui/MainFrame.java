package ingsw.composite.gui;

import java.awt.Frame;

import javax.swing.JFrame;

public class MainFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Composite");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Display the window.
		//frame.add(new DrawPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
				
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}

}
