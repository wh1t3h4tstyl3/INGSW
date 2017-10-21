package ingsw.bridge.gui;

import javax.swing.JFrame;

import ingsw.bridge.abstractions.ComputerAbstraction;
import ingsw.bridge.abstractions.HP;

public class MainProgram {
	
	public static ComputerAbstraction computerAbstraction;
	
	private static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Bridge");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		// Display the window.
		frame.add(new DrawPanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		computerAbstraction = new HP();
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}
