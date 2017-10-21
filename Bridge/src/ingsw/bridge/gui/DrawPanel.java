package ingsw.bridge.gui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import ingsw.bridge.abstractions.ComputerAbstraction;
import ingsw.bridge.implementations.Implementation;

public class DrawPanel extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final static String HP = "HP";
	private final static String DELL = "Dell";
	private final static String ASUS = "Asus";
	private JPanel cardPanel;
	private JButton buttonCPU;
	private JButton buttonGPU;
	
	public DrawPanel() {
		super(new GridLayout(3, 1));
		
		init();
	}

	private void init() {
		// Create and set up the content pane.
		setPreferredSize(new Dimension(1366, 768));
		setBackground(Color.BLUE.darker());
		// Create and Setup Buttons
		String[] fields = { HP, DELL, ASUS };
		JComboBox<Object> comboBox = new JComboBox<>(fields);
		comboBox.setEditable(false);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if(e.getStateChange() == ItemEvent.SELECTED) {
					String brand = "ingsw.bridge.abstractions." + (String)e.getItem();
					try {
						MainProgram.computerAbstraction = 
								(ComputerAbstraction) Class.forName(brand).newInstance();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					
					CardLayout c = (CardLayout) cardPanel.getLayout();
					c.show(cardPanel, "IMPLEMENTATION");
					
					buttonCPU.setEnabled(true);
					buttonGPU.setEnabled(true);
					
					if(brand.equals("ingsw.bridge.abstractions." + HP)) DrawPanel.this.setBackground(Color.BLUE.darker());
					else if(brand.equals("ingsw.bridge.abstractions." + ASUS)) DrawPanel.this.setBackground(Color.DARK_GRAY);
					else if(brand.equals("ingsw.bridge.abstractions." + DELL)) DrawPanel.this.setBackground(Color.RED.darker());
					else DrawPanel.this.setBackground(null);
					
					repaint();
				}
			}
		});

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setOpaque(false);
		comboBoxPanel.add(comboBox);
		
		
		cardPanel = new JPanel(new CardLayout());
		cardPanel.setVisible(true);
		cardPanel.setOpaque(false);
		
		// CARDS
		// IMPLEMENTATION CARD
		JPanel card = new JPanel();
		card.setOpaque(false);
		card.setLayout(null);
		JButton button = new JButton("Intel");
		button.setName("ingsw.bridge.implementations.IntelImpl");
		button.addActionListener(this);
		button.setBounds(500, 85, 100, 64);
		card.add(button);
		button = new JButton("AMD");
		button.setName("ingsw.bridge.implementations.AMDImpl");
		button.setBounds(610, 85, 100, 64);
		button.addActionListener(this);
		card.add(button);
		button = new JButton("Nvidia");
		button.setName("ingsw.bridge.implementations.IntelNvidiaImpl");
		button.setBounds(720, 85, 100, 64);
		button.addActionListener(this);
		card.add(button);
		
		cardPanel.add(card, "IMPLEMENTATION");
		
		// COMPONENTS CARD
		card = new JPanel();
		card.setLayout(null);
		card.setOpaque(false);
		buttonCPU = new JButton("ADD CPU");
		buttonCPU.setName("CPU");
		buttonCPU.setBounds(580, 85, 100, 64);
		buttonCPU.addActionListener(this);
		card.add(buttonCPU);
		buttonGPU = new JButton("ADD GPU");
		buttonGPU.setName("GPU");
		buttonGPU.setBounds(690, 85, 100, 64);
		buttonGPU.addActionListener(this);
		card.add(buttonGPU);
		
		button = new JButton("BACK");
		button.setName("BACK");
		button.setBounds(635, 180, 100, 40);
		button.addActionListener(this);
		card.add(button);
		
		cardPanel.add(card, "COMPONENTS");
		
		JPanel empty = new JPanel();
		empty.setVisible(false);
		
		add(comboBoxPanel);
		add(empty);
		add(cardPanel);
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		MainProgram.computerAbstraction.publish(g);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Set new Implementation
		
		String name = ((JButton)e.getSource()).getName();
		
		if(name.equals("CPU")) {
			MainProgram.computerAbstraction.addCpu();
			((JButton)e.getSource()).setEnabled(false);
			repaint();
		}
		
		else if(name.equals("GPU")) {
			MainProgram.computerAbstraction.addGpu();
			((JButton)e.getSource()).setEnabled(false);
			repaint();
		}
		
		else if(name.equals("BACK")) {
			CardLayout c = (CardLayout) cardPanel.getLayout();
			c.show(cardPanel, "IMPLEMENTATION");
			MainProgram.computerAbstraction.removeAll();
			buttonCPU.setEnabled(true);
			buttonGPU.setEnabled(true);
			repaint();
		}
		
		else {
			try {
				MainProgram.computerAbstraction.setImplementation(
						(Implementation) Class.forName((name)).newInstance()
				);
				
			} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
				e1.printStackTrace();
			}
						
			CardLayout c = (CardLayout) cardPanel.getLayout();
			c.show(cardPanel, "COMPONENTS");
		}
	}
}
