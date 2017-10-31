package ingsw.decorator.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JPanel;

import ingsw.decorator.FrameDecorator;
import ingsw.decorator.PaintingComponent;

public class DrawPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private PaintingComponent component;
	
	public DrawPanel(PaintingComponent component) {
		super(new BorderLayout());
		this.component = component;
		initScreen();
	}
	
	private void initScreen() {
		setPreferredSize(new Dimension(1366, 768));
		setVisible(true);
		addComponentListener(new ResizeAdapter());
		
		JPanel selection = new JPanel();
		selection.setVisible(true);
		selection.setPreferredSize(new Dimension(200, 100));
		JButton addButton = new JButton("add Golden Frame");
		
		addButton.addActionListener(new ActionListener() {
		
			@Override
			public void actionPerformed(ActionEvent e) {
				if(((JButton) e.getSource()).getText().equals("add Golden Frame")) {
					component = new FrameDecorator(component);
					addButton.setText("remove Golden Frame");
				}
				else {
					component = component.getDecorator();
					addButton.setText("add Golden Frame");
				}
				
				repaint();
			}
		});
		selection.add(addButton);
		
		JPanel rightPanel = new JPanel(new BorderLayout());
		rightPanel.setPreferredSize(new Dimension(200, 768));
		rightPanel.add(selection, BorderLayout.SOUTH);
		
		add(rightPanel, BorderLayout.EAST);
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		component.drawComponent((Graphics2D)g);
	}
	
	private class ResizeAdapter extends ComponentAdapter {
		@Override
		public void componentResized(ComponentEvent e) {
			component.resetImage(new Dimension(((JPanel)e.getSource()).getWidth(), ((JPanel)e.getSource()).getHeight()));
			
			repaint();
		}
	}

}
