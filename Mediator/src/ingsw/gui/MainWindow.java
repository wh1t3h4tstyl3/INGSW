package ingsw.gui;

import javax.swing.JFrame;

import ingsw.mediator.Form;

public class MainWindow {
private static void createAndShowGUI() {
		
		// Create and set up the window.
		JFrame frame = new JFrame("WallPaper Collection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		frame.add(new Form());
		
		// Display the window.
		frame.setResizable(false);

		frame.pack();
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
