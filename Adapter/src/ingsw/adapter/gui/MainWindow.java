package ingsw.adapter.gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import javafx.scene.paint.Color;

public class MainWindow {
	
	private static double r = 0.0, g = 0.0, b = 0.0, a = 1.0;
	
	private static void userInit() {
		
		try {
			r = Double.parseDouble(JOptionPane.showInputDialog("Select Red value (range 0.0 - 1.0)"));
		} catch(NumberFormatException e) {
			r = 0.0;
		}
		
		if(r < 0.0 || r > 1.0) {
			JOptionPane.showMessageDialog(null, "the range was exceeded -> set to 0.0");
			r = 0.0;
		}
		
		try {
			g = Double.parseDouble(JOptionPane.showInputDialog("Select Green value (range 0.0 - 1.0)"));
		} catch(NumberFormatException e) {
			g = 0.0;
		}
		
		if(g < 0.0 || g > 1.0) {
			JOptionPane.showMessageDialog(null, "the range was exceeded -> set to 0.0");
			g = 0.0;
		}
		
		
		try {
			b = Double.parseDouble(JOptionPane.showInputDialog("Select Blue value (range 0.0 - 1.0)"));
		} catch(NumberFormatException e) {
			b = 0.0;
		}
		
		if(b < 0.0 || b > 1.0) {
			JOptionPane.showMessageDialog(null, "the range was exceeded -> set to 0.0");
			b =  0.0;
		}
	}
	
	private static void createAndShowGUI(java.awt.Color color) {
		// Create and set up the window.
		JFrame frame = new JFrame("Adapter");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Create and set up the content pane.
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(1366, 768));
		panel.setLayout(null);
		panel.setBackground(color);
		panel.setVisible(true);
		
		JButton buttonDarker = new JButton("Darker");
		JButton buttonBrighter = new JButton("Brighter");
		
		buttonDarker.setBounds(480, 334, 200, 100);
		buttonDarker.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));
		buttonDarker.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(color.darker());
				buttonBrighter.setEnabled(true);
				buttonDarker.setEnabled(false);
				panel.validate();
				panel.repaint();
			}
		});
		
		panel.add(buttonDarker);
		
		
		buttonBrighter.setBounds(686, 334, 200, 100);
		buttonBrighter.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));
		buttonBrighter.setEnabled(false);
		buttonBrighter.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.setBackground(color.brighter());
				buttonBrighter.setEnabled(false);
				buttonDarker.setEnabled(true);
			}
		});
		
		panel.add(buttonBrighter);
		
		
		frame.add(panel);

		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		
		userInit();
		
		javafx.scene.paint.Color fxColor = new Color(r, g, b, a);
		
		java.awt.Color awtColor = new FxToAwtColorAdapter(fxColor);
		
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(awtColor);
			}
		});
	}
}
