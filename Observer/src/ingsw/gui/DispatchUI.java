package ingsw.gui;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class DispatchUI extends JFrame {
	private static final long serialVersionUID = 1L;
	private GUIManager manager;
	
	public DispatchUI(GUIManager manager) {
		this.manager = manager;
		initWindow();
	}

	private void initWindow() {
		setResizable(false);
		setTitle("Dispatch Manager");
		JPanel container = new JPanel(new GridLayout(3, 0));
		
		JPanel titlePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setFont(new Font("Wide Latin", Font.PLAIN, 22));
				String s = "DISPATCH MANAGER";
				
				g.drawString(s, this.getWidth()/2 - g.getFontMetrics().stringWidth(s)/2, this.getHeight()/2 + 10);
			}
		};
		
		container.add(titlePanel);
		
		final JButton addButton = new JButton("Accept");
		addButton.addActionListener(e -> {
			try{
				manager.startDispatch();
			} catch(Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		final JButton sellButton = new JButton("Process");
		sellButton.addActionListener(e -> {
			try{
				manager.process();
			} catch(Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(sellButton);
		container.add(buttonPanel);
		
		buttonPanel = new JPanel();
		final JButton hideList = new JButton("Send");
		hideList.addActionListener(e -> {
			try{
				manager.send();
			} catch(Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		buttonPanel.add(hideList);
		
		final JButton hideSellButton = new JButton("Deliver");
		hideSellButton.addActionListener(e -> {
			try{
				manager.finalize();
				dispose();
			} catch(Exception exception) {
				JOptionPane.showMessageDialog(this, exception.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			}
		});
		buttonPanel.add(hideSellButton);
		
		container.add(buttonPanel);
		
		add(container);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	}
}
