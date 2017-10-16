package bu.gui;

import java.io.File;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
	public static JPanel mainScreen;
	static File file;
	public static JFrame frame;
	
	static {
		mainScreen = new MainScreen();
		mainScreen.setName("FIRST PANEL");
		file = null;	
	}
	
	private static void createAndShowGUI() {
	
		frame = new JFrame("THEME CONVERTER");
		
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(mainScreen);
		
		frame.pack();
		
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI();
			}
		});
		
	}
}
