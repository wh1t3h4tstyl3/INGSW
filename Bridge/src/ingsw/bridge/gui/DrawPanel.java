package ingsw.bridge.gui;

import java.awt.CardLayout;
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
	
	public DrawPanel() {
		super(new GridLayout(3, 1));
		
		init();
	}

	private void init() {
		// Create and set up the content pane.
		setPreferredSize(new Dimension(1366, 768));

		// Create and Setup Buttons
		String[] fields = { HP, DELL, ASUS };
		JComboBox<Object> comboBox = new JComboBox<>(fields);
		comboBox.setEditable(false);
		comboBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if(e.getStateChange() == ItemEvent.DESELECTED) {
					String brand = "ingsw.bridge.abstractions." + (String)e.getItem();
					try {
						MainProgram.computerAbstraction = 
								(ComputerAbstraction) Class.forName(brand).newInstance();
					} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
						e1.printStackTrace();
					}
					CardLayout c = (CardLayout) cardPanel.getLayout();
					c.show(cardPanel, "IMPLEMENTATION");
				}
			}
		});

		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(comboBox);
		
		
		cardPanel = new JPanel(new CardLayout());
		cardPanel.setVisible(true);
		
		// CARDS
		// IMPLEMENTATION CARD
		JPanel card = new JPanel();
		JButton button = new JButton("Intel");
		button.setName("ingsw.bridge.implementations.IntelImpl");
		button.addActionListener(this);
		card.add(button);
		button = new JButton("AMD");
		button.setName("ingsw.bridge.implementations.AMDImpl");
		button.addActionListener(this);
		card.add(button);
		
		cardPanel.add(card, "IMPLEMENTATION");
		
		// COMPONENTS CARD
		card = new JPanel();
		button = new JButton("ADD CPU");
		card.add(button);
		button = new JButton("ADD GPU");
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
		try {
			MainProgram.computerAbstraction.setImplementation(
					(Implementation) Class.forName(
					((JButton)e.getSource()).getName()
				).newInstance()
			);
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}
				
		
		CardLayout c = (CardLayout) cardPanel.getLayout();
		c.show(cardPanel, "COMPONENTS");
		
	}
}
