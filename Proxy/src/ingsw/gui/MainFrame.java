package ingsw.gui;

import java.awt.Frame;

import javax.swing.JFrame;

public class MainFrame {

	private static void createAndShowGUI() {
		
		// Create and set up the window.
		JFrame frame = new JFrame("WallPaper Collection");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Create and set up the content pane.
		frame.add(new MainPanel());
		
		// Display the window.
		frame.setResizable(false);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
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
