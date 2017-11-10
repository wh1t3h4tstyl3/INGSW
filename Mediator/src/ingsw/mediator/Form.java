package ingsw.mediator;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import ingsw.data.CSVParser;

public class Form extends JPanel {
	private static final long serialVersionUID = 1L;
	
	private JComboBox<String> regions;
	private JComboBox<String> capitals;
	private JComboBox<String> places;
	private CSVParser parser;
	private JButton button;
	private JTextField name;
	private JTextField surname;
	private JTextField tel;
	
	public Form() {
		init();
	}

	private void init() {
		
		setVisible(true);
		setPreferredSize(new Dimension(400, 400));
		
		parser = new CSVParser();
		try {
			parser.read(new File("data/dataItaly.csv"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
//		AutoCompleteTextField auto = new AutoCompleteTextField();
//		ArrayList<String> possibilities = (ArrayList<String>) c.getRegionsNames();
//		auto.setPossibilities(possibilities);
//		auto.setInitialHint("Insert Region name here...");
//		add(auto);
//		auto = new AutoCompleteTextField();
//		auto.setInitialHint("Insert Regional Capital name here...");
//		add(auto);
		
		JPanel boxesPanel = new JPanel(new GridBagLayout());
		GridBagConstraints constraint = new GridBagConstraints();
		constraint.insets = new Insets(5, 15, 5, 15);
		constraint.anchor = GridBagConstraints.EAST;
		
		
		JLabel label = new JLabel("Regione:");
		constraint.gridx = 0;
		constraint.gridy = 0;
		boxesPanel.add(label, constraint);
		
		label = new JLabel("Provincia:");
		constraint.gridx = 0;
		constraint.gridy = 1;
		boxesPanel.add(label, constraint);
		
		label = new JLabel("Città:");
		constraint.gridx = 0;
		constraint.gridy = 2;
		boxesPanel.add(label, constraint);
		
		label = new JLabel("Nome:");
		constraint.gridx = 0;
		constraint.gridy = 3;
		boxesPanel.add(label, constraint);
		
		label = new JLabel("Cognome:");
		constraint.gridx = 0;
		constraint.gridy = 4;
		boxesPanel.add(label, constraint);
		
		label = new JLabel("Telefono:");
		constraint.gridx = 0;
		constraint.gridy = 5;
		boxesPanel.add(label, constraint);
				
		ChangeListener changeListener = new ChangeListener();
		constraint.fill = GridBagConstraints.HORIZONTAL;
		String[] comboBoxItems = parser.getRegionsNames();
		regions = new JComboBox<>(comboBoxItems);
		regions.addActionListener(changeListener);
		constraint.gridx = 1;
		constraint.gridy = 0;
		boxesPanel.add(regions, constraint);

		capitals = new JComboBox<>();
		capitals.addItem("Scegli un capoluogo...");
		capitals.setEnabled(false);
		capitals.addActionListener(changeListener);
		constraint.gridx = 1;
		constraint.gridy = 1;
		boxesPanel.add(capitals, constraint);
		
		places = new JComboBox<>();
		places.setEnabled(false);
		places.addItem("Scegli una città...");
		constraint.gridx = 1;
		constraint.gridy = 2;
		boxesPanel.add(places, constraint);

		name = new JTextField();
		constraint.gridx = 1;
		constraint.gridy = 3;
		boxesPanel.add(name, constraint);
		
		surname = new JTextField();
		constraint.gridx = 1;
		constraint.gridy = 4;
		boxesPanel.add(surname, constraint);
				
		tel = new JTextField(8);
		constraint.gridx = 1;
		constraint.gridy = 5;
		boxesPanel.add(tel, constraint);
		
		button = new JButton("Salva");
		button.addActionListener(changeListener);
		constraint.fill = GridBagConstraints.NONE;
		constraint.gridx = 1;
		constraint.gridy = 6;
		boxesPanel.add(button, constraint);
		
		add(boxesPanel);		
	}
	
	private void changed(JComponent component) {
		if (component instanceof JComboBox<?>) {
			JComboBox<?> box = (JComboBox<?>) component;

			if (!((String) box.getSelectedItem()).startsWith("Scegli")) {
				JComboBox<String> type = null;
				String[] values = null;
				if (box == regions) {
					type = capitals;
					values = parser.getCapitalNames(box.getSelectedItem());
					places.setEnabled(false);
				}

				else if (box == capitals) {
					type = places;
					values = parser.getPlacesNames(regions.getSelectedItem(), box.getSelectedItem());
				}

				type.setEnabled(true);
				type.setModel(new DefaultComboBoxModel<String>(values));
			}
		}
		
		else if(component instanceof JButton) {
			System.out.println(regions.getSelectedItem());
			System.out.println(capitals.getSelectedItem());
			System.out.println(places.getSelectedItem());
			System.out.println(name.getText());
			System.out.println(surname.getText());
			System.out.println(tel.getText());
		}
	}

	private class ChangeListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			changed((JComponent)e.getSource());
		}
		
	}
}
