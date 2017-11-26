package ingsw.gui;

import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import ingsw.observer.Product;

public class ManagerUI extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GUIManager manager;
	
	public ManagerUI(GUIManager manager) {
		this.manager = manager;
		manager.addProduct(new Product(ingsw.observer.Type.LAPTOP, "DELL", "7559", 999, 10));
		initWindow();
	}

	private void initWindow() {
		setResizable(true);
		setTitle("Store Manager");
		JPanel container = new JPanel(new GridLayout(3, 0));
		
		JPanel titlePanel = new JPanel() {
			private static final long serialVersionUID = 1L;
			
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setFont(new Font("Wide Latin", Font.PLAIN, 25));
				String s = "STORE MANAGER";
				
				g.drawString(s, this.getWidth()/2 - g.getFontMetrics().stringWidth(s)/2, this.getHeight()/2 + 10);
			}
		};
		
		container.add(titlePanel);
		
		final JButton addButton = new JButton("Add new Product");
		addButton.addActionListener(e -> addPopup());
		
		final JButton sellButton = new JButton("Sell selected item");
		sellButton.addActionListener(e -> {
			manager.removeObject();
		});
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(addButton);
		buttonPanel.add(sellButton);
		container.add(buttonPanel);
		
		buttonPanel = new JPanel();
		final JButton hideList = new JButton("Hide List");
		hideList.addActionListener(e -> {
			if(hideList.getText().equals("Hide List"))
					hideList.setText("Show List");
			else
				hideList.setText("Hide List");
			
			manager.showList();
		});
		buttonPanel.add(hideList);
		
		final JButton hideSellButton = new JButton("Show Sell's Window");
		hideSellButton.addActionListener(e -> {
			if(hideSellButton.getText().equals("Hide Sell's Window"))
					hideSellButton.setText("Show Sell's Window");
			else
				hideSellButton.setText("Hide Sell's Window");
			
			manager.showSellWindow();
		});
		buttonPanel.add(hideSellButton);
		
		container.add(buttonPanel);
		
		add(container);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	private void addPopup() {
		JTextField brand = new JTextField();
		JTextField model = new JTextField();
		JTextField price = new JTextField();
		Integer[] items = new Integer[100];
		int i = 0;
		while (i < 100)
			items[i++] = i;
		JComboBox<Integer> amount = new JComboBox<>(items);

		JPanel myPanel = new JPanel(new GridLayout(0, 1));

		ButtonGroup buttonGroup = new ButtonGroup();
		JPanel buttonPanel = new JPanel();

		for (ingsw.observer.Type type : ingsw.observer.Type.values()) {
			if (!type.equals(ingsw.observer.Type.NONE)) {
				JRadioButton radioButton = new JRadioButton(type.toString());
				radioButton.setSelected(true);
				buttonPanel.add(radioButton);
				buttonGroup.add(radioButton);
			}
		}

		myPanel.add(buttonPanel);

		myPanel.add(new JLabel("Brand:"));
		myPanel.add(brand);

		myPanel.add(new JLabel("Model:"));
		myPanel.add(model);

		myPanel.add(new JLabel("Price (in euro):"));
		myPanel.add(price);

		myPanel.add(new JLabel("Amount:"));
		myPanel.add(amount);

		Object[] optionsE = { "Ok", "Cancel" };
		int selection = JOptionPane.showOptionDialog(null, myPanel, "Insert new Product", JOptionPane.YES_OPTION,
				JOptionPane.DEFAULT_OPTION, null, optionsE, optionsE[0]);

		String type = null;
		for (Component c : buttonPanel.getComponents()) {
			if (((JRadioButton) c).isSelected()) {
				type = ((JRadioButton) c).getText();
				break;
			}
		}

		if (selection == 0) {
			try {
				manager.addProduct(new Product(ingsw.observer.Type.valueOf(type), brand.getText(), model.getText(),
						Integer.valueOf(price.getText()), (Integer) amount.getSelectedItem()));
			} catch (Exception ex) {
				JOptionPane.showMessageDialog(this, "INVALID Price Format\n\nOnly DIGIT is allowed!", "Price Error",
						JOptionPane.ERROR_MESSAGE);
			}
		}
	}
}
